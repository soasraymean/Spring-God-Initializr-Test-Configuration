package com.tyjohntompson.springwebapp.repository;

import com.tyjohntompson.springwebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
