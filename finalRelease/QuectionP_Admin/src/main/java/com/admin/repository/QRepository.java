package com.admin.repository;

import com.admin.model.Quection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QRepository extends JpaRepository<Quection,Integer> {

}
