/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: Authority.java
 * Author: NiceMorning
 */

package cn.nicemorning.security.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 该实体类用于存储身份权限分级。
 */
@Document(collection = "security")
public class AuthorityPojo {
    @Id
    private String id;
    @Indexed
    private String uid;
    // 0:普通用户；1:管理员用户
    private int identity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", identity=" + identity +
                '}';
    }

    public AuthorityPojo(int identity) {
        this.identity = identity;
    }

    public AuthorityPojo() {
    }
}
