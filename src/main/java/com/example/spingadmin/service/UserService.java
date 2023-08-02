package com.example.spingadmin.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spingadmin.entity.User;
import com.example.spingadmin.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    public Boolean saveUser(User user) {
        // if (user.getId() == null) {
        //     return this.save(user);
        // } else {
        //     return this.updateById(user);
        // }
        return saveOrUpdate(user);
    }


    // @Autowired
    // private UserMapper userMapper;

    // public Integer save(User user) {
    //     if (user.getId() == null) {
    //         return userMapper.insert(user);
    //     } else {
    //         return userMapper.update(user);
    //     }
    // }
}
