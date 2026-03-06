package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private EmpService empService;

    //登录
    @PostMapping
    public Result login(@RequestBody Emp emp){
        log.info("用户登录");
        LoginInfo loginInfo = empService.login(emp);
        if(loginInfo != null)
            return Result.success(loginInfo);
        return Result.error("用户名或密码错误");
    }
}
