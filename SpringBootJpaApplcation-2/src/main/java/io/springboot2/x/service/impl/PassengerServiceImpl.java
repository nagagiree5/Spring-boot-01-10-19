package io.springboot2.x.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import io.springboot2.x.domain.Passenger;
import io.springboot2.x.repo.PassengerRepository;
import io.springboot2.x.service.IPassengerService;

@Service
public class PassengerServiceImpl implements IPassengerService {
	@Autowired
	private PassengerRepository repository;

	@Override
	public Page<Passenger> getEmployees(Integer pageNor) {
		// TODO Auto-generated method stub
		
		Pageable pageable=PageRequest.of(pageNor,3,Sort.by("firstName").ascending());
		return repository.findAll(pageable);
	}

}
