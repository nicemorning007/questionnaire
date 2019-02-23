package cn.nicemorning.questionnaire.repository;

import cn.nicemorning.questionnaire.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

	Person findByName(String name);

	@Query("{'age': { '$lt' : ?0}}")
	List<Person> withQueryFindByAge(Integer age);

}
