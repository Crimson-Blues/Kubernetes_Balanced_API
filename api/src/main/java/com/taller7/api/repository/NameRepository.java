package com.taller7.api.repository;

import com.taller7.api.model.Name;
import org.springframework.data.jpa.repository.JpaRepository;

// By extending JpaRepository, you instantly get .save(), .findById(), .findAll(), and .delete() for free!
public interface NameRepository extends JpaRepository<Name, Long> {
}