/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: Authority.java
 * Author: NiceMorning
 */

package cn.nicemorning.security.db.mapper;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 该实体类用于存储身份权限分级。
 */
@Document(collection = "security")
public class Authority {
    @Id
    private String id;
    private int identity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                ", identity=" + identity +
                '}';
    }

    public Authority(int identity) {
        this.identity = identity;
    }

    public Authority() {
    }
}
