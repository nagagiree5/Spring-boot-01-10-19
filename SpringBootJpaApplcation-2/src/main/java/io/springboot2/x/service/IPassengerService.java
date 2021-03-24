package io.springboot2.x.service;

import org.springframework.data.domain.Page;

import io.springboot2.x.domain.Passenger;

public interface IPassengerService {

Page<Passenger> getEmployees(Integer pageNor);	

}
