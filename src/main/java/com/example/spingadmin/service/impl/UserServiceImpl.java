package com.example.spingadmin.service.impl;

import com.example.spingadmin.entity.User;
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

}
