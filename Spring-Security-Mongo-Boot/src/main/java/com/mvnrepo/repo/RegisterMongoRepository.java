package com.mvnrepo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mvnrepo.entity.Employee;

public interface RegisterMongoRepository extends MongoRepository<Employee,String> {

}
