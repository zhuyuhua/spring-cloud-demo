package com.somnus.springcloud.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {


    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloError")
    public String helloService(String name){

        String value = restTemplate.getForObject("http://SPRING-CLOUD-SERVICE-HELLO/service-hello?name="+name,String.class);
        return  value;

    }

    public String helloError(String name){
        System.out.println("Hello,"+name+", sorry error in helloError()");
        return "Error in helloService,for hystrix,name:"+name;
    }

}
