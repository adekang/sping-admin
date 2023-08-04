package com.example.spingadmin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.spingadmin.common.Constants;
import com.example.spingadmin.common.Result;
import com.example.spingadmin.controller.dto.UserDTO;
import com.example.spingadmin.entity.User;
import com.example.spingadmin.exception.ServiceException;
import com.example.spingadmin.mapper.UserMapper;
import com.example.spingadmin.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author adekang
 * @since 2023-08-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public UserDTO login(UserDTO userDTO) {
        User userInfo = getUserInfo(userDTO);
        if (userInfo != null) {
            BeanUtil.copyProperties(userInfo, userDTO, true);
            return userDTO;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }

    @Override
    public User register(UserDTO user) {
        User userInfo = getUserInfo(user);
        if (userInfo == null) {
            userInfo = new User();
            BeanUtil.copyProperties(user, userInfo, true);
            save(userInfo);
            return userInfo;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名已存在");
        }
    }

    private User getUserInfo(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDTO.getUsername());
        queryWrapper.eq("password", userDTO.getPassword());
        User one;
        try {
            one = getOne(queryWrapper);
        } catch (Exception e) {
            throw new ServiceException(Constants.CODE_500, "系统异常");
        }
        return one;
    }
}
