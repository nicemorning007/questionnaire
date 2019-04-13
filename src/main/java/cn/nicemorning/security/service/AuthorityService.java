/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: AuthorityService.java
 * Author: NiceMorning
 */

package cn.nicemorning.security.service;

import cn.nicemorning.security.entity.AuthorityPojo;
import cn.nicemorning.security.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;

    /**
     * 通过UID获取用户的权限实例对象
     * @param uid 要查询的用户ID
     * @return 如果该用户存在权限等级控制，则返回该权限等级控制实例对象；否则返回一个新的不含属性的权限等级控制实例对象。
     */
    public AuthorityPojo getUserAuthority(String uid) {
        AuthorityPojo authorityPojo = this.authorityRepository.getAuthorityPojoByUid(uid);
        return authorityPojo.getId() != null ? authorityPojo : new AuthorityPojo();
    }
}
