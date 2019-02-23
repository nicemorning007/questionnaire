/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: UserController.java
 * Author: NiceMorning
 */

package cn.nicemorning.questionnaire.controller;

import cn.nicemorning.questionnaire.entity.ResultEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
//    @Autowired
//    private

    @RequestMapping("/signin")
    public ResultEntity signIn(@RequestParam("usernamae") String username,
                               @RequestParam("password") String password) {

        return new ResultEntity();
    }
}
