package com.sk.biz1.controller;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static Logger logger = Logger.getLogger(DemoController.class);

    @RequestMapping(value ="/index/{username}" ,method= RequestMethod.GET)
    public String index(@PathVariable("username") String username) {
        logger.info("username:"+username);
        return username;
    }
}
