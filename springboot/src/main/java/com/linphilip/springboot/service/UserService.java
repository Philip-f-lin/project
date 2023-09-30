package com.linphilip.springboot.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.linphilip.springboot.dto.UserRequest;
import com.linphilip.springboot.model.User;

import java.util.List;


public interface UserService extends IService<User> {

    //public abstract Integer save(User user);

    Integer deleteById(Integer id);

    List<User> selectPage(Integer pageNum, Integer pageSize, String username);

    Integer selectTotal(String username);

    boolean saveUser(User user);

    boolean login(UserRequest userRequest);
}
