package com.somnus.springcloud.boot.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * Created by zhuyuhua on 2018/6/8.
 */

@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(getClass());

    private static boolean is_run = true;

    @RequestMapping(value="/run",method = RequestMethod.GET)
    public String index(){

        is_run=true;

        new Thread(new Runnable() {

            @Override
            public void run() {

                while (is_run) {
                    try {
                        logger.debug(this.getClass().getName() + new Date());
                        logger.info(this.getClass().getName() + new Date());
                        logger.warn(this.getClass().getName() + new Date());
                        logger.trace(this.getClass().getName() + new Date());
                        logger.error(this.getClass().getName() + new Date());
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {

                    }
                }

            }
        }).start();

        return "running";

    }

    @RequestMapping(value="/stop",method = RequestMethod.GET)
    public String stop(){

        this.is_run = false;

        return "stop";

    }
}
