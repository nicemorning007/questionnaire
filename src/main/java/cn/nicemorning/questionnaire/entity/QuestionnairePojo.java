/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: QuestionnairePojo.java
 * Author: NiceMorning
 */

package cn.nicemorning.questionnaire.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "questionnaire")
public class QuestionnairePojo {
    @Id
    private String id;
    @Indexed
    private String uid;
    private String qid;
    private String qname;
    private int qcount;

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

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public int getQcount() {
        return qcount;
    }

    public void setQcount(int qcount) {
        this.qcount = qcount;
    }

    @Override
    public String toString() {
        return "QuestionnairePojo{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", qid='" + qid + '\'' +
                ", qname='" + qname + '\'' +
                ", qcount=" + qcount +
                '}';
    }
}
