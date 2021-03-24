package io.springboot2.x.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import io.springboot2.x.domain.NetflixUser;

public interface NetflixUserRepository extends JpaRepository<NetflixUser,String> {

}
