package com.mvnrepo.repo;

import java.util.List;

import com.mvnrepo.beans.Country;
import com.mvnrepo.beans.UserBean;



public interface IEmailRepo {
	List<Country>   getAllCountries();
	boolean   saveUser(UserBean  userBean);
}
