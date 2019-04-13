/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: AuthorityRepositiry.java
 * Author: NiceMorning
 */

package cn.nicemorning.security.repository;

import cn.nicemorning.security.entity.AuthorityPojo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorityRepository extends MongoRepository<AuthorityPojo, String> {
    AuthorityPojo getAuthorityPojoByUid(String uid);
}
