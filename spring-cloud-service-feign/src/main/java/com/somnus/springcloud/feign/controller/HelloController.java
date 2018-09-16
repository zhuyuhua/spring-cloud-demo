package com.somnus.springcloud.feign.controller;

import com.somnus.springcloud.feign.service.SchedualServiceHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    SchedualServiceHello schedualServiceHello;

    @GetMapping(value = "/service-feign")
    public String sayHello(@RequestParam String name) {

        System.out.println("in "+this.getClass().getName()+".sayHello(),name:"+name);

        return schedualServiceHello.sayHiFromClientOne( name );

    }

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String hiConsumer(@RequestParam String name){

        String value = schedualServiceHello.sayHiFromClientOne( name );
        System.out.println("in "+this.getClass().getName()+",value:"+value);

        return  value;

    }


}
