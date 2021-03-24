package com.mvnrepo.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvnrepo.entity.EmployeeJpa;
import com.mvnrepo.entity.Gender;
import com.mvnrepo.repo.RegisterJpaRepository;
import com.mvnrepo.service.IRegisterJpaService;


@Service
public class RegisterJpaServiceImpl implements IRegisterJpaService {

	@Autowired
	private RegisterJpaRepository repository;
	
	
	@Override
	public boolean registerEmployee(String fullName, String email, Integer experience, Gender gender,
			Date dateOfBirth) {
		// TODO Auto-generated method stub
		
		EmployeeJpa    obj=new  EmployeeJpa();
		   obj.setFullName(fullName);
		   obj.setEmail(email);
		   obj.setExperience(experience);
		   obj.setGender(gender.name());
		   obj.setDateOfBirth(dateOfBirth);
		
		
		boolean   flag = repository.existsById(email);
		
	    if(flag ==true) {
	    	return  false;
	    }
	    else {  
	    	 repository.saveAndFlush(obj);
	    	 return  true;  
	    }
		
	}
     
	@Override
	public List<EmployeeJpa> getListOfEmployees() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<EmployeeJpa> editEmployeePage(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<EmployeeJpa> getUpdateEmployee(EmployeeJpa  employee) {
		// TODO Auto-generated method stub
		      repository.saveAndFlush(employee);
		return repository.findAll();
	}

	@Override
	public List<EmployeeJpa> getDeleteEmployee(String id) {
		// TODO Auto-generated method stub
		             repository.deleteById(id);
		return repository.findAll();  
	}  

}
