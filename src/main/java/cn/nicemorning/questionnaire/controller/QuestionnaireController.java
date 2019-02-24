/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: QuestionnaireController.java
 * Author: NiceMorning
 */

package cn.nicemorning.questionnaire.controller;

import cn.nicemorning.questionnaire.entity.PageResultEntity;
import cn.nicemorning.questionnaire.entity.QuestionnairePojo;
import cn.nicemorning.questionnaire.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @GetMapping("/getAllQuestionnaireByUid")
    public PageResultEntity getMyQuestionnaire(@RequestParam("uid") String uid,
                                               @RequestParam("page") int page,
                                               @RequestParam("limit") int limit) {
        List<QuestionnairePojo> questionnairePojos = questionnaireService.findAllByPageByUid(page, limit, uid);
        if (questionnairePojos.size() > 0) {
            //为配合layui，code需为0
            return new PageResultEntity(0, "success", questionnaireService.findAllByUid(uid).size(),
                    questionnairePojos);
        }
        return new PageResultEntity(200, "没有数据", null);
    }

    @GetMapping("/getCountByUid")
    public PageResultEntity getCountByUid(@RequestParam("uid") String uid) {
        return new PageResultEntity(200, "success", questionnaireService.findAllByUid(uid).size());
    }
}
