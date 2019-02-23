/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: PageController.java
 * Author: NiceMorning
 */

package cn.nicemorning.questionnaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class is used to make page routing
 */
@Controller
public class PageController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/signUp")
    public String signUp() {
        return "signUp";
    }

    @RequestMapping("/userCenter")
    public String userCenter() {
        return "userCenter";
    }

    @RequestMapping("/myquestionnaire")
    public String myquestionnaire() {
        return "myquestionnaire";
    }

    @RequestMapping("/myinfomation")
    public String myinfomation() {
        return "myinfomation";
    }

    @RequestMapping("/addquestionnaire")
    public String addquestionnaire() {
        return "addquestionnaire";
    }
}
