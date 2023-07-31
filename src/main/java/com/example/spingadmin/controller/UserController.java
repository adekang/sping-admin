package com.example.spingadmin.controller;

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
        return userMapper.findAll();
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
    public Integer delete(@RequestParam Integer id) {
        return userMapper.delete(id);
    }

    /**
     * 分页查询
     */
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<User> data = userMapper.findPage(pageNum, pageSize);
        Integer total = userMapper.selectTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("data", data);
        map.put("total", total);

        return map;
    }


}