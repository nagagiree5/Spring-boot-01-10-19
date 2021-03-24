package com.mvnrepo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvnrepo.entity.EmployeeJpa;

@Repository
public interface RegisterJpaRepository extends JpaRepository<EmployeeJpa,String> {

}
