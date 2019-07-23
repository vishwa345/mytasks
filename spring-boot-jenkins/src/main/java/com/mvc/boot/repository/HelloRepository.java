package com.mvc.boot.repository;

import java.util.List;

import com.mvc.boot.models.HelloModel;
import org.springframework.data.repository.CrudRepository;

public interface HelloRepository  extends CrudRepository<HelloModel, Long> {
    List<HelloModel> findByGreeting(String greeting);
}
