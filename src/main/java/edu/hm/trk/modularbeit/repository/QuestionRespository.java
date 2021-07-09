package edu.hm.trk.modularbeit.repository;

import edu.hm.trk.modularbeit.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRespository extends CrudRepository<Question,Long> {
}
