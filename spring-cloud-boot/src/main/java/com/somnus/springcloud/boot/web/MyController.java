package com.somnus.springcloud.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {


    @Autowired(required = false)
    private List<User> users = Collections.emptyList();

    @Autowired(required = false)
    private Map<String,User> userMap = new HashMap<>();

    @RequestMapping("/list")
    public Object listUsers(){
        return users;
    }

    @RequestMapping("/map")
    public Object mapUsers(){
        return  userMap;
    }

    @Bean("user1")
    User user1(){
        return new User("1","a");
    }

    @Bean("user2")
    User user2(){
        return new User("2","bb");
    }



}


