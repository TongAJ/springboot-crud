package com.atguigu.springbootcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "admin".equals(password)){
            //登陆成功
            session.setAttribute("loginName",username);
            return "redirect:/main.html";
        }else{
            //登陆失败
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }
}