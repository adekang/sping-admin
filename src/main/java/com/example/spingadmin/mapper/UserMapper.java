package com.example.spingadmin.mapper;

import com.example.spingadmin.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();

    @Select("insert into user (username, nickname, password, email, phone, address) values (#{username},#{nickname},#{password},#{email},#{phone},#{address})")
    Integer insert(User user);

    Integer update(User user);

    @Delete("delete from user where id = #{id}")
    Integer delete(Integer id);

    //  分页 page = (pageNum - 1) * pageSize
    @Select("select * from user limit #{pageNum},#{pageSize}")
    List<User> findPage(Integer pageNum, Integer pageSize);

    @Select("select count(*) from user")
    Integer selectTotal();
}
