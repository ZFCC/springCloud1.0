package com.sn.springCloud10;

import com.sn.springCloud10.redisServcie.RedisServcie;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class MyApplicationController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    RedisServcie redisService;

    @GetMapping("/myAPP")
    @ResponseBody
    public String getMyName(){
        String str = applicationContext.getEnvironment().getProperty("myAPP.environMent.name");
        User user = new User();
        user.setAge(20);
        user.setId("1");
        user.setUserName("我是你好");
        user.setPassWord("123");
        System.out.println("today is interesting  \n"+new Date());
//        redisService.set("hello", user);

//        System.out.println(redisService.get("hello").toString());
        return str+new Date() +"\n"+ redisService.get("hello").toString();
    }
    @GetMapping("/myAPP1")
    @ResponseBody
    public String deleteRedis(){
        redisService.remove("hello");
        return "redis is delete"+ redisService.get("hello");
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User testUser(@PathVariable String id){
        User user = new User();
        user.setId(id);
        user.setAge(10);
        user.setUserName("niaho");
        user.setPassWord("123");
        return user;
    }
}
