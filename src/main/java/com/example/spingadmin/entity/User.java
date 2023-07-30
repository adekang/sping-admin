package com.example.spingadmin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String nickname;
    @JsonIgnore
    private String password;
    private String email;
    private String phone;
    private String address;
}
