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

    /**
     * 通过用户名获取用户的实例对象
     *
     * @param username 需要查询的用户名
     * @return 该用户名对应的用户实例对象
     */
    public UserPojo findByUsername(String username) {
        Optional<UserPojo> userPojo = userRepository.findByUsername(username);
        return userPojo.isPresent() ? userPojo.get() : new UserPojo();
    }

    /**
     * 获得所有用户的实例对象的List集合
     *
     * @return 所有用户的实例对象的List集合
     */
    public List<UserPojo> findAllUsers() {
        return userRepository.findAll();
    }

    /**
     * 新增或更新用户实例对象
     *
     * @param userPojo 要操作的用户实例对象
     * @return 操作后的用户实例对象
     */
    @Transactional
    public UserPojo saveOrUpdate(UserPojo userPojo) {
        return userRepository.save(userPojo);
    }

    /**
     * 通过ID获取指定的用户实例对象
     *
     * @param id 要查询的ID
     * @return 该ID对应的用户实例对象
     */
    public UserPojo findUserInfoById(String id) {
        Optional<UserPojo> userPojo = userRepository.findById(id);
        if (userPojo.isPresent()) {
            return userPojo.get();
        }
        return new UserPojo();
    }
}
