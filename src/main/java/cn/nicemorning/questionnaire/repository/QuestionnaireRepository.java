/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: QuestionnaireRepository.java
 * Author: NiceMorning
 */

package cn.nicemorning.questionnaire.repository;

import cn.nicemorning.questionnaire.entity.QuestionnairePojo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionnaireRepository extends MongoRepository<QuestionnairePojo, String> {
    List<QuestionnairePojo> findAllByUid(String uid);

    List<QuestionnairePojo> findByUid(String uid, Pageable pageable);

}
