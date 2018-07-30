package com.atguigu.springbootcrud.controller;

import com.atguigu.springbootcrud.component.MyRunnableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("username") String username){
        if(username.equals("aaa")){
            throw new MyRunnableException("用户不存在");
        }
        return "Hello SpringBoot_crud";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","你好");
        /* /classpath/templates/success.html */
        return "success";
    }
}
