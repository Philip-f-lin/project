package com.linphilip.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linphilip.springboot.dao.UserMapper;
import com.linphilip.springboot.dto.UserRequest;
import com.linphilip.springboot.model.User;
import com.linphilip.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Autowired
    private UserMapper userMapper;

    /*public int save(User user){
        if(user.getId() == null){
            return userMapper.insert(user);
        }else {
            return userMapper.update(user);
        }
    }*/

    public Integer deleteById(Integer id) {
        return null;
        //return userMapper.delete(id);
    }

    public List<User> selectPage(Integer pageNum, Integer pageSize, String username) {
        //return userMapper.selectPage(pageNum, pageSize, username);
        return null;
    }

    public Integer selectTotal(String username) {
        return null;
        //return userMapper.selectTotal(username);
    }

    @Override
    public boolean saveUser(User user) {
        return saveOrUpdate(user);



    }

    @Override
    public boolean login(UserRequest userRequest) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userRequest.getUsername());
        queryWrapper.eq("password", userRequest.getPassword());
        try{
            User one= getOne(queryWrapper);
            return one != null;
        }catch (Exception e){
            return false;
        }

    }
}
