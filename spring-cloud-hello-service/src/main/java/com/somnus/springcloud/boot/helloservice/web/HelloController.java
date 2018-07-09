package com.somnus.springcloud.boot.helloservice.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhuyuhua on 2018/6/8.
 */
@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${server.port}")
    private String port;

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String index(@RequestParam String name){

        System.out.println("in hello(),name:"+name);

        return "Hello World: "+name;
    }
}
