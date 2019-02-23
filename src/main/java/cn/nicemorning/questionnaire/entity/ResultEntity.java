/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: ResultEntity.java
 * Author: NiceMorning
 */

package cn.nicemorning.questionnaire.entity;

public class ResultEntity {
    private int code;
    private Object data;
    private String msg;

    public ResultEntity(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public ResultEntity() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
