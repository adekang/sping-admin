package com.example.spingadmin.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Papers {
    @TableId(type = IdType.AUTO)
    @ExcelIgnore
    private Integer id;
    @ExcelProperty("Article Title")
    private String title;
    @ExcelProperty("Source Title")
    private String source;
    @ExcelProperty("Authors")
    private String authors;
}
