package com.example.spingadmin.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Papers {
    @TableId(type = IdType.AUTO)
    @ExcelIgnore
    private Integer id;

    @TableField("publicationType")
    private String publicationType;

    @TableField("authors")
    private String authors;

    @TableField("title")
    private String articleTitle;

    @TableField("ISBN")
    private String isbn;

    @TableField("eISSN")
    private String eissn;


}



