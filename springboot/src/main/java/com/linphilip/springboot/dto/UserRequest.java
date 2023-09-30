package com.linphilip.springboot.dto;

import lombok.Data;

// 接收前端登錄請求的參數
@Data
public class UserRequest {
    private String username;
    private String password;
}
