package com.example.spingadmin.service;

import com.example.spingadmin.common.Result;
import com.example.spingadmin.controller.dto.UserDTO;
import com.example.spingadmin.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author adekang
 * @since 2023-08-03
 */
public interface IUserService extends IService<User> {

    UserDTO login(UserDTO userDTO);

    User register(UserDTO user);
}
