package com.linphilip.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linphilip.springboot.dto.UserRequest;
import com.linphilip.springboot.model.User;
import com.linphilip.springboot.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 新增和修改
    @PostMapping("/login")
    public boolean login(@RequestBody UserRequest userRequest) {
        String username = userRequest.getUsername();
        String password = userRequest.getPassword();
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return false;
        }
        return userService.login(userRequest);
    }

    // 新增和修改
    @PostMapping("/save")
    public boolean save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // 查詢所有
    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.list();
    }

    // 刪除
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return userService.removeById(id);
    }

    // 多個刪除
    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return userService.removeBatchByIds(ids);
    }

    /*// 分頁查詢 Mybatis
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam String username) {
        // 當前頁 = (pageNum - 1) * 每頁顯示行數（個數）
        pageNum = (pageNum - 1) * pageSize;
        username = "%" + username + "%";
        List<User> data = userService.selectPage(pageNum, pageSize, username);
        Integer total = userService.selectTotal(username);
        Map<String, Object> map = new HashMap<>();
        map.put("data", data);
        map.put("total", total);

        return map;
    }*/

    // 分頁查詢 MybatisPlus
    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String username,
                                @RequestParam(defaultValue = "") String nickname,
                                @RequestParam(defaultValue = "") String address) {
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(!"".equals(username)){
            queryWrapper.like("username", username);
        }
        if(!"".equals(nickname)){
            queryWrapper.like("nickname", nickname);
        }
        if(!"".equals(address)){
            queryWrapper.like("address", address);
        }
        queryWrapper.orderByDesc("id");

        return userService.page(page, queryWrapper);


    }
}
