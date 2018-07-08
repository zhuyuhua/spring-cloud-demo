package com.somnus.springboot.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhuyuhua on 2018/6/8.
 */
@RestController
public class HelloController {

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String index(){


        return "Hello World";
    }
}
