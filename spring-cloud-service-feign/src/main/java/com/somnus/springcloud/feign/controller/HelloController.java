package com.somnus.springcloud.feign.controller;

import com.somnus.springcloud.feign.service.SchedualServiceHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    SchedualServiceHello schedualServiceHello;

    @GetMapping(value = "/service-feign")
    public String sayHello(@RequestParam String name) {

        System.out.println("in "+this.getClass().getName()+".sayHello1(),name:"+name);

        return schedualServiceHello.sayHiFromClientOne( name );

    }


}
