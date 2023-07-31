package com.example.spingadmin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 基础数据类
 *
 * @author adekang
 **/
@Data
@EqualsAndHashCode
public class UploadData {
    private String Publication_Type;
    private String Authors;
}