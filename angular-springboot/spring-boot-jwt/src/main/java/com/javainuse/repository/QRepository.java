package com.javainuse.repository;

import com.javainuse.model.Quection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QRepository extends JpaRepository<Quection,Integer> {

}
