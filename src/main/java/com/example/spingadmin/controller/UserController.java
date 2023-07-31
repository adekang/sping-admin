package com.example.spingadmin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.spingadmin.entity.User;
import com.example.spingadmin.mapper.UserMapper;
import com.example.spingadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> index() {
        return userService.list();
    }


    /**
     * 新增或修改用户
     */
    @PostMapping("/save")
    public Boolean save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Integer id) {
        return userService.removeById(id);
    }

    /**
     * 分页查询
     */
    // 方案一
    // @GetMapping("/page")
    // public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
    //     pageNum = (pageNum - 1) * pageSize;
    //     List<User> data = userMapper.findPage(pageNum, pageSize);
    //     Integer total = userMapper.selectTotal();
    //     Map<String, Object> map = new HashMap<>();
    //     map.put("data", data);
    //     map.put("total", total);
    //
    //     return map;
    // }

    // 方案二
    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String username,
                                @RequestParam(defaultValue = "") String nickname) {
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (!"".equals(username))
            queryWrapper.like("username", username);
        if (!"".equals(nickname))
            queryWrapper.like("nickname", nickname);

        IPage<User> userPage = userService.page(page, queryWrapper);

        return userPage;
    }


}