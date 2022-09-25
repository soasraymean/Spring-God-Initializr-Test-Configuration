package com.tyjohntompson.springwebapp.repository;

import com.tyjohntompson.springwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {



}
