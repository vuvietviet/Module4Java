package com.codegym.repository;

import com.codegym.model.Deparment;
import org.springframework.data.repository.CrudRepository;

public interface IDeparmentRepo extends CrudRepository<Deparment, Long> {
}
