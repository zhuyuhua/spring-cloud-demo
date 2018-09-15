package com.somnus.springcloud.feign.service;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHello{

    @Override
    public String sayHiFromClientOne(String name) {

        return "in "+this.getClass().getName()+".sayHiFromClientOne(),sorry.";

    }
}
