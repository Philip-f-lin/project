package com.linphilip.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linphilip.springboot.model.User;
import com.linphilip.springboot.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/save")
    public boolean save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // 查詢所有
    @GetMapping("/")
    public List<User> findAll() {
        return userService.list();
    }

    // 刪除
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return userService.removeById(id);
    }

    /*// 分頁查詢
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

    // 分頁查詢
    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String username) {
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", username);
        return userService.page(page, queryWrapper);


    }
}
