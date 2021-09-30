package com.example.swaggerdemo.controller;


import com.example.swaggerdemo.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
public class SwaggerController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello Swagger";
    }

    //只要我们的接口中，返回值中存在实体类，它就会被扫描到swagger中
    @ApiOperation ( "方法注释" )
    @PostMapping(value = "/user")
    public User user(){
        return  new User ();
    }
    @ApiOperation ( "方法注释" )
    @PostMapping(value = "/hello2")
    public String hello2(@ApiParam("用户名")@RequestParam("username") String username){
        System.out.println (username);
        return  username;
    }
}
