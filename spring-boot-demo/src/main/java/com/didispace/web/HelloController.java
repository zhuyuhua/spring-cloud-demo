package com.didispace.web;


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


    @Autowired
    DiscoveryClient discoveryClient;


    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String index(){


        List<ServiceInstance> list = discoveryClient.getInstances("SPRING-BOOT-DEMO");
        System.out.println("discoveryClient.getServices().size() = " + discoveryClient.getServices().size());

        for( String s :  discoveryClient.getServices()){
            System.out.println("services " + s);
            List<ServiceInstance> serviceInstances =  discoveryClient.getInstances(s);
            for(ServiceInstance si : serviceInstances){
                System.out.println("    services:" + s + ":getHost()=" + si.getHost());
                System.out.println("    services:" + s + ":getPort()=" + si.getPort());
                System.out.println("    services:" + s + ":getServiceId()=" + si.getServiceId());
                System.out.println("    services:" + s + ":getUri()=" + si.getUri());
                System.out.println("    services:" + s + ":getMetadata()=" + si.getMetadata());
            }

        }

        System.out.println(list.size());
        if (list != null && list.size() > 0 ) {
            System.out.println( list.get(0).getUri()  );
        }

        return "Hello World";
    }
}
