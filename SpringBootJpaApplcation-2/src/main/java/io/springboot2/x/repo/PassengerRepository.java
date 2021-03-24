package io.springboot2.x.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.springboot2.x.domain.Passenger;

@Repository
public interface PassengerRepository extends PagingAndSortingRepository<Passenger, Integer> {

}
