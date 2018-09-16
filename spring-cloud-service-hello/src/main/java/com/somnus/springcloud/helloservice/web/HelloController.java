package com.somnus.springcloud.helloservice.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhuyuhua on 2018/6/8.
 */
@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${server.port}")
    private String port;

    @Autowired
    private org.springframework.cloud.client.discovery.DiscoveryClient discoveryClient;




    @RequestMapping(value="/service-hello",method = RequestMethod.GET)
    public String hello(@RequestParam String name){

        System.out.println("in "+this.getClass().getName()+",name:"+name+",port:"+port);


        //获取instance信息
        discoveryClient.getServices().forEach(id -> {
            discoveryClient.getInstances(id).forEach(instance -> {
                logger.info("/hello-service, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
            });
        });


        return "hello "+name+", i am from service-hello, port:"+port;
    }


}
