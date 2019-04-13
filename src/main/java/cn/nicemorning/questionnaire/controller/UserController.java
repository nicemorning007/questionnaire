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
        UserPojo userPojo = userService.findByUsername(username);
        System.out.println(userPojo);
        if (userPojo.getId() != null) {
            if (userPojo.getPassword().equals(password)) {
                session.setAttribute("user", userPojo);
                return new PageResultEntity(200, "success", userPojo);
            } else {
                return new PageResultEntity(400, "用户名或密码错误", null);
            }
        }
        return new PageResultEntity(400, "用户名不存在", null);
    }

    @PostMapping("/signup")
    public PageResultEntity signup(@RequestParam("username") String username,
                                   @RequestParam("password") String password,
                                   @RequestParam("nickname") String nickname) {
        UserPojo userPojo = new UserPojo(username, password, nickname);
        UserPojo check = userService.findByUsername(username);
        if (check.getId() == null) {
            UserPojo user = userService.saveOrUpdate(userPojo);
            if (user.getId() != null) {
                return new PageResultEntity(200, "注册成功", null);
            }
        } else {
            return new PageResultEntity(400, "用户名已存在", null);
        }
        return new PageResultEntity(500, "发生未知错误", null);
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.removeAttribute("user");
        return new ModelAndView("redirect:/index");
    }

    @GetMapping("/getInfo")
    public PageResultEntity getInfo(@RequestParam("id") String id) {
        return new PageResultEntity(200, "success", userService.findUserInfoById(id));
    }

    @PostMapping("/editInfo")
    public PageResultEntity editInfo(@RequestParam("uid") String uid,
                                     @RequestParam("nickname") String nickname) {
        UserPojo userPojo = userService.findUserInfoById(uid);
        if (userPojo.getId() != null) {
            userPojo.setNickname(nickname);
            userPojo = userService.saveOrUpdate(userPojo);
            if (userPojo.getNickname() == nickname) {
                return new PageResultEntity(200, "修改成功", userPojo);
            }
        }
        return new PageResultEntity(500, "发生未知错误", null);
    }

    @PostMapping("/editpwd")
    public PageResultEntity editpwd(@RequestParam("uid") String uid,
                                     @RequestParam("password") String password) {
        UserPojo userPojo = userService.findUserInfoById(uid);
        if (userPojo.getId() != null) {
            userPojo.setPassword(password);
            userPojo = userService.saveOrUpdate(userPojo);
            if (userPojo.getPassword() == password) {
                return new PageResultEntity(200, "修改成功", userPojo);
            }
        }
        return new PageResultEntity(500, "发生未知错误", null);
    }

}
