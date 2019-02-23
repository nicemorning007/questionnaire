/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: UserRepository.java
 * Author: NiceMorning
 */

package cn.nicemorning.questionnaire.repository;

import cn.nicemorning.questionnaire.entity.UserPojo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * 用于User集合的持久化操作
 *
 * @author Nicemorning
 */
public interface UserRepository extends MongoRepository<UserPojo, String> {
    /**
     * Find user object by username.
     * @param username query username
     * @return which user object`s username equls query username.
     */
    Optional<UserPojo> findByUsername(String username);

}
