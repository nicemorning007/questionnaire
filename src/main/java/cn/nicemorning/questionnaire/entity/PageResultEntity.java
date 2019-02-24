/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: PageResultEntity.java
 * Author: NiceMorning
 */

package cn.nicemorning.questionnaire.entity;

/**
 * 用于返回需要分页的封装类
 *
 * @author Nicemorning
 */
public class PageResultEntity {
    private int code;
    private String msg;
    private int count;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageResultEntity{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }

    /**
     * 构建可用于分页的封装类
     *
     * @param code  状态代码
     * @param msg   用户提示信息
     * @param count data总条目数
     * @param data  封装信息
     */
    public PageResultEntity(int code, String msg, int count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    /**
     * 构建不含分页的封装类
     *
     * @param code 状态代码
     * @param msg  用户提示信息
     * @param data 封装信息
     */
    public PageResultEntity(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 构建空数据封装类
     */
    public PageResultEntity() {
    }
}
