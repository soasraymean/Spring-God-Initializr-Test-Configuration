package com.tyjohntompson.springwebapp.repository;

import com.tyjohntompson.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
