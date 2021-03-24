package com.mvnrepo.serviceimpl;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvnrepo.entity.EmployeeMongo;
import com.mvnrepo.entity.Gender;
import com.mvnrepo.repo.RegisterMongoRepository;
import com.mvnrepo.service.IRegisterMongoService;


@Service
public class RegisterMongoServiceImpl implements IRegisterMongoService {

	@Autowired
	private RegisterMongoRepository repository;
	
	
	@Override
	public boolean registerEmployee(String fullName, String email, Integer experience, Gender gender,
			Date dateOfBirth) {
		// TODO Auto-generated method stub
		
		EmployeeMongo    obj=new  EmployeeMongo();
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
	    	 repository.save(obj);
	    	 return  true;  
	    }
		
	}
     
	@Override
	public List<EmployeeMongo> getListOfEmployees() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<EmployeeMongo> editEmployeePage(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<EmployeeMongo> getUpdateEmployee(EmployeeMongo  employee) {
		// TODO Auto-generated method stub
		      repository.save(employee);
		return repository.findAll();
	}

	@Override
	public List<EmployeeMongo> getDeleteEmployee(String id) {
		// TODO Auto-generated method stub
		             repository.deleteById(id);
		return repository.findAll();  
	}  

}
