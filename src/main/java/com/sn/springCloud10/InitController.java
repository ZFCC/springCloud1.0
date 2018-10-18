package com.sn.springCloud10;

import com.sn.springCloud10.redisServcie.RedisServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class InitController {

    @Autowired
    RedisServcie redisService;

    @GetMapping("/hello")
    @ResponseBody
    public User helloWord(){
        User user = new User();
        user.setAge(20);
        user.setId("1");
        user.setUserName("我是你好");
        user.setPassWord("123");
        System.out.println("today is interesting  \n"+new Date());

        redisService.set("hello", user);

//        System.out.println(redisService.get("hello").toString());
        return user;
    }


}
