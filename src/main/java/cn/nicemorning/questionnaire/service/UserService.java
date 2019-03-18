/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: UserService.java
 * Author: NiceMorning
 */

package cn.nicemorning.questionnaire.service;

import cn.nicemorning.questionnaire.entity.UserPojo;
import cn.nicemorning.questionnaire.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserPojo findByUsername(String username) {
        Optional<UserPojo> userPojo = userRepository.findByUsername(username);
        return userPojo.isPresent() ? userPojo.get() : new UserPojo();
    }

    public List<UserPojo> findAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public UserPojo saveOrUpdate(UserPojo userPojo) {
        return userRepository.save(userPojo);
    }

    public UserPojo findUserInfoById(String id) {
        Optional<UserPojo> userPojo = userRepository.findById(id);
        if (userPojo.isPresent()) {
            return userPojo.get();
        }
        return new UserPojo();
    }
}
