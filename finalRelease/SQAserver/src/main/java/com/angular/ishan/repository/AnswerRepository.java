package com.angular.ishan.repository;

import com.angular.ishan.model.Answer;
import com.angular.ishan.model.Quection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
Long deleteByQuectionId(Integer id);

}
