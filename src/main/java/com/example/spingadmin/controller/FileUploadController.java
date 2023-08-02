package com.example.spingadmin.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.spingadmin.entity.Papers;
import com.example.spingadmin.entity.UploadData;
import com.example.spingadmin.mapper.PapersMapper;
import com.example.spingadmin.service.PapersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private UploadData UploadData;
    private Papers papers;
    @Autowired
    private PapersMapper papersMapper;
    @Autowired
    private PapersService papersService;


    @ApiOperation("文件上传")
    @PostMapping("/upload")
    @CrossOrigin
    public String upload(MultipartFile file) throws IOException {
        List<Papers> papersList = new ArrayList<>();

        EasyExcel.read(file.getInputStream(), UploadData.class, new AnalysisEventListener<UploadData>() {
            @Override
            public void invoke(UploadData data, AnalysisContext context) {
                Papers papers = new Papers();
                copyFieldToBean(data, papers);


                papersList.add(papers);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                // 数据解析完成后，将papersList保存到数据库
                papersService.saveBatch(papersList);
            }
        }).sheet().doRead();

        return "true";
    }


    public static void copyFieldToBean(Object from, Object to) {
        Map<String, Object> srcMap = new HashMap<>();
        // from 子类已经父类里面所有的属性
        for (Class<?> clazz = from.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                Field[] srcFields = clazz.getDeclaredFields();
                for (Field srcField : srcFields) {
                    try {
                        if (Modifier.isStatic(srcField.getModifiers())) {
                            // 过滤掉static
                            continue;
                        }
                        srcField.setAccessible(true);
                        srcMap.put(srcField.getName(), srcField.get(from)); //获取属性值
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }
        // to 子类已经父类里面所有的属性
        for (Class<?> clazz = to.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                Field[] destFields = clazz.getDeclaredFields();
                for (Field destField : destFields) {
                    if (Modifier.isStatic(destField.getModifiers())) {
                        // 过滤掉static
                        continue;
                    }
                    destField.setAccessible(true);
                    if (srcMap.get(destField.getName()) == null) {
                        continue;
                    }
                    try {
                        destField.set(to, srcMap.get(destField.getName())); //给属性赋值
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }


    }
}
