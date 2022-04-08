package com.edward.edu.controller;


import com.edward.edu.bean.EduUser;
import com.edward.edu.vo.EduResult;
import org.springframework.web.bind.annotation.*;

@RestController //ResponseBody+Controller
@CrossOrigin
@RequestMapping("/eduservice/user")
public class LoginController {

    @PostMapping("/login")
    public EduResult login(@RequestBody EduUser user) {
        System.out.println(user);
        return EduResult.ok().data("token", "admin");
    }

    @RequestMapping("/info")
    public EduResult getInfo(String token) {
        System.out.println(token);
        return EduResult.ok().data("roles", "admin").data("name","coovy").data("avatar","http://localhost/2022-03-30/touxiang.jpg");
    }

}
