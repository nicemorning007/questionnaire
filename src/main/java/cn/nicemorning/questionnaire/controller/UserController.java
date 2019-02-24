/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: UserController.java
 * Author: NiceMorning
 */

package cn.nicemorning.questionnaire.controller;

import cn.nicemorning.questionnaire.entity.PageResultEntity;
import cn.nicemorning.questionnaire.entity.UserPojo;
import cn.nicemorning.questionnaire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signin")
    public PageResultEntity signIn(HttpSession session,
                                   @RequestParam("username") String username,
                                   @RequestParam("password") String password) {
        UserPojo userPojo = new UserPojo("5c71037b67ab09b99df1451e", "username",
                "password", "nickname");
        session.setAttribute("user", userPojo);
        return new PageResultEntity(200, "success", userPojo);
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.removeAttribute("user");
        return new ModelAndView("redirect:/index");
    }

}
