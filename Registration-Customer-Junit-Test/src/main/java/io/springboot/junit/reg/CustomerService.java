package io.springboot.junit.reg;

import java.util.ArrayList;
import java.util.List;



public class CustomerService {
	List<String>  emailIdList=new ArrayList<String>();
	List<Long>  aadharIdList=new ArrayList<Long>();
	
	public  CustomerService( ) {
		emailIdList.add("nagagirigollapalli@gmail.com");
		emailIdList.add("poojahegde@yahoo.com");
		
		aadharIdList.add(98873342219L);
		aadharIdList.add(91772344111L);
		
	}
	
	public  boolean   validate(RegistrationDto  dto) {
		if(isCustomerWithEmailIdExist(dto.getEmailId()) || isCustomerWithAadharIdExist(dto.getAadharId()))
		{
			return  false;
		}
		else {
			return  true;
		}
		
	}
	
	public  boolean   isCustomerWithEmailIdExist(String emailId) {
		if(emailIdList.contains(emailId)) {
			return true;
		}
		else {
			return  false;
		}
		
	}
	
	public  boolean   isCustomerWithAadharIdExist(long  aadharId) {
		if(aadharIdList.contains(aadharId)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public   boolean   registerCustomer(RegistrationDto  dto) throws NextGenBankException {
		try {
			if(validate(dto)) {
				Thread.sleep(2000);
				return  true;
			}
			else {
				throw  new  NextGenBankException("customer is already registered");
			}
		/*}catch(SathyaBankException  e) {
			System.out.println(e);
			return  false;
		}*/
		}catch(InterruptedException  ie) {
			return false;
		}
		
			
	}

}
