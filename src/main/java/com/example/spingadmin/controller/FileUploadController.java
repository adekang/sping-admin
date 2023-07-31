package com.example.spingadmin.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson2.JSON;
import com.example.spingadmin.entity.UploadData;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * ClassName: 文件上传
 * Description:文件上传Description
 *
 * @author adekang
 * @date: 2023/7/31
 * @since 1.3.9
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {

    private UploadData uploadData;

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    @CrossOrigin
    public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), UploadData.class, new PageReadListener<UploadData>(dataList -> {
            for (UploadData uploadData : dataList) {
                System.out.println("读取到一条数据{}" + JSON.toJSONString(uploadData));
            }
        })).sheet().doRead();
        return "true";
    }

}
