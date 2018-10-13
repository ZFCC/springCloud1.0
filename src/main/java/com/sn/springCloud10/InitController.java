package com.sn.springCloud10;

import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class InitController {

    @GetMapping("/hello")
    @ResponseBody
    public User helloWord(){
        User user = new User();
        user.setAge(20);
        user.setId("1");
        user.setUserName("我是你好");
        user.setPassWord("123");
        System.out.println("today is interesting  \n"+new Date());
        return user;
    }

}
