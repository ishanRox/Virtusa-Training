package com.angular.ishan.repository;

import com.angular.ishan.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
Long deleteByQuectionId(Integer id);
}
