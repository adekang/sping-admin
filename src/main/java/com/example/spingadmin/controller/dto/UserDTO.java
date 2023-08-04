package com.example.spingadmin.controller.dto;


import cn.hutool.core.annotation.Alias;
import lombok.Data;


/**
 * <p>
 * 接受前端登录的请求参数
 * </p>
 *
 * @since 2023-08-03
 */
@Data
public class UserDTO {
    @Alias("用户名")
    private String username;
    @Alias("密码")
    private String password;
    @Alias("昵称")
    private String nickname;
    @Alias("头像")
    private String avatarUrl;
}
