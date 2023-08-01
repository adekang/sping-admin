package com.example.spingadmin.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.example.spingadmin.entity.Files;
import com.example.spingadmin.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 文件上传相关接口
 */
@RestController
@RequestMapping("/files")
public class FileController {
    @Resource
    FileMapper fileMapper;
    @Value("${files.upload.path}")
    private String fileUploadPath;

    /**
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {
//        文件属性
        String originalFilename = file.getOriginalFilename();
        String type = FileUtil.extName(originalFilename);
        long size = file.getSize();
// 存储到磁盘
        File uploadFile = new File(fileUploadPath);
//        判断文件目录是否存在
        if (!uploadFile.exists()) {
            uploadFile.mkdirs();
        }
//        文件的唯一标识码
        String uuid = IdUtil.fastSimpleUUID();
        String fileUuid = uuid + StrUtil.DOT + type;
        File file1 = new File(fileUploadPath + fileUuid);
//        获取到的文件存入磁盘
        file.transferTo(file1);
//        存储数据库  将文件表示码存入数据库
        String url = "http://localhost:8080/files/" + fileUuid;
        Files saveFile = new Files();
        saveFile.setName(originalFilename);
        saveFile.setType(type);
        saveFile.setSize(size/1024); // kb
        saveFile.setUrl(url);
        fileMapper.insert(saveFile);
        return url;
    }

    /**
     * 文件下载接口 根据文件的唯一标识码下载文件
     * "http://localhost:8080/files/" + fileUuid;
     * @param fileUuid
     * @param response
     * @throws IOException
     */
    @GetMapping("/{fileUuid}")
    public void download(@PathVariable String fileUuid, HttpServletResponse response) throws IOException {
        File file = new File(fileUploadPath + fileUuid);
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileUuid, "UTF-8"));
        response.setContentType("application/octet-stream");
        ServletOutputStream outputStream = response.getOutputStream();
//        将文件写入到输出流
        outputStream.write(FileUtil.readBytes(file));
        outputStream.flush();
        outputStream.close();
    }
}


