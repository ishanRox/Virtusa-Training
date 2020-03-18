package com.angular.ishan.repository;

import com.angular.ishan.model.Quection;
import com.angular.ishan.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuectionRepository extends JpaRepository<Quection, Integer> {
 List<Quection> findBySubjectId(Integer id);
}