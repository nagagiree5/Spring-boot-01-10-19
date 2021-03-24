package com.mvnrepo.daoimpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mvnrepo.beans.Gender;
import com.mvnrepo.beans.RegisterBean;
import com.mvnrepo.dao.IRegisterDao;

@Repository
public class RegisterDaoImpl implements IRegisterDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	  
	@Override
	public boolean registerUser(RegisterBean registerBean) {
		// TODO Auto-generated method stub
		
		//String query="INSERT INTO `giridb`.`register_user` (`fullname`, `email`, `experience`, `gender`, `dateofbirth`) VALUES (?,?,?,?,?)";

		String query2="INSERT INTO giridb.register_user(fullname,email,experience, gender,dateofbirth) VALUES (?,?,?,?,?)";
	
		String fullname=registerBean.getFullName();
		Gender gender=registerBean.getGender();
		String email=registerBean.getEmail();    
		int experience=registerBean.getExperience();
		Date dateofbirth=registerBean.getDateOfBirth();
		
		int  i = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM register_user WHERE email=?", Integer.class,email);
		
				
		
		if(i==1) {   //try pass insert query return-true email is primerykey exception occure...
			return false;
		}else {      //catch exception  return-false
			int i2=jdbcTemplate.update(query2, fullname,email,experience,gender.name(),dateofbirth);
			return  true;
		}    
	}  

}
