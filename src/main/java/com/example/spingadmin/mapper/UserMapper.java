package com.example.spingadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.spingadmin.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user")
    List<User> findAll();

    // @Select("insert into gin_demo.user (username, nickname, password, email, phone, address) values (#{username},#{nickname},#{password},#{email},#{phone},#{address})")
    // int insert(User user);

    Integer update(User user);

    @Delete("delete from user where id = #{id}")
    Integer delete(Integer id);

    //  分页 page = (pageNum - 1) * pageSize
    @Select("select * from user limit #{pageNum},#{pageSize}")
    List<User> findPage(Integer pageNum, Integer pageSize);

    @Select("select count(*) from user")
    Integer selectTotal();
}
