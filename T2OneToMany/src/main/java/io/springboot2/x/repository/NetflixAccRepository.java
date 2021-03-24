package io.springboot2.x.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.springboot2.x.domain.NetflixAcc;
public interface NetflixAccRepository extends JpaRepository<NetflixAcc,String> {

}
