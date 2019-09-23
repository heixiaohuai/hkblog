package com.hk.hkblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by 何坤
 * @Classname BootstrapController
 * @Description TODO
 * @Date 2019/9/19 9:01
 */
@Controller
public class BootstrapController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/bootstrap01")
    public String bootstrap01(){
        return "/bootstrap/bootstrap01";
    }

    @GetMapping("/bootstrap02")
    public String bootstrap02(){
        return "/bootstrap/bootstrap02";
    }

    @GetMapping("/bootstrap03")
    public String bootstrap03(){
        return "/bootstrap/bootstrap03";
    }

    @GetMapping("/bootstrap04")
    public String bootstrap04(){
        return "/bootstrap/bootstrap04";
    }

    @GetMapping("/bootstrap05")
    public String bootstrap05(){
        return "/bootstrap/bootstrap05";
    }
}
