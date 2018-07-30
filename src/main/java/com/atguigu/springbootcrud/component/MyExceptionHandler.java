package com.atguigu.springbootcrud.component;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    /*@ResponseBody
    @ExceptionHandler(MyRunnableException.class)
    public Map<String,Object> handlerException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user not exist");
        map.put("message",e.getMessage());
        return map;
    }*/

    @ExceptionHandler(MyRunnableException.class)
    public String handlerException(Exception e, HttpServletRequest request){
        /* 给一个状态码 不然默认是200 没有2xx.html 则用blank页面然后默认写一个错误页面*/
        request.setAttribute("javax.servlet.error.status_code",500);
        Map<String,Object> map = new HashMap<>();
        map.put("code","user not exist");
        map.put("message",e.getMessage());
        /* 以ext为key，放进request域中*/
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
