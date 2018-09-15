package com.somnus.springcloud.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;


    @RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer(@RequestParam String name){

        String value = helloService.helloService(name);
        System.out.println("in "+this.getClass().getName()+",value:"+value);

        return  value;

    }
}
