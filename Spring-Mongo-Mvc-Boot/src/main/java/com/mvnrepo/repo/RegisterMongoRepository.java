package com.mvnrepo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mvnrepo.entity.Employee;
@Repository
public interface RegisterMongoRepository extends MongoRepository<Employee,String> {

}
