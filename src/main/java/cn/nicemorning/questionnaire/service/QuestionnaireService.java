/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: QuestionnaireService.java
 * Author: NiceMorning
 */

package cn.nicemorning.questionnaire.service;

import cn.nicemorning.questionnaire.entity.QuestionnairePojo;
import cn.nicemorning.questionnaire.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionnaireService {
    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    public List<QuestionnairePojo> findAllByUid(String uid) {
        List<QuestionnairePojo> questionnairePojos =
                questionnaireRepository.findAllByUid(uid);
        return questionnairePojos.size() > 0 ? questionnairePojos : new ArrayList<>();
    }

    @Transactional
    public QuestionnairePojo saveOrUpdate(QuestionnairePojo questionnairePojo) {
        return questionnaireRepository.save(questionnairePojo);
    }

    public List<QuestionnairePojo> findAllByPageByUid(int page, int limit, String uid) {
        return questionnaireRepository.findByUid(uid, PageRequest.of(page - 1, limit));
    }
}
