package com.linphilip.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.linphilip.springboot.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /*@Select("select * from user")
    List<User> findAll();


    @Insert("INSERT INTO user (username, password, nickname, email, phone, address)" +
            " VALUES (#{username}, #{password}, #{nickname}, #{email}, #{phone}, #{address})")
    int insert(User user);


    Integer update(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    Integer delete(@Param("id") Integer id);

    @Select("select * from user where username like #{username} limit #{pageNum}, #{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize, String username);

    @Select("select count(*) from user where username like concat('%', #{username}, '%')")
    Integer selectTotal(String username);*/
}
