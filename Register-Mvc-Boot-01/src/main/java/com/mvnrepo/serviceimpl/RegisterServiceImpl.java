package com.mvnrepo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvnrepo.beans.RegisterBean;
import com.mvnrepo.dao.IRegisterDao;
import com.mvnrepo.service.IRegisterService;

@Repository
public class RegisterServiceImpl implements IRegisterService {

	@Autowired
	private IRegisterDao dao;
	
	@Override
	public boolean getRegisterUser(RegisterBean registerBean) {
		// TODO Auto-generated method stub
		return dao.registerUser(registerBean);
	}

}  
