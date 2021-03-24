package io.springboot.junit;

import java.util.List;

public class User_Profile {

	
	public String userIdSuggestion(String firstName,String lastName) {
		String suggestion=firstName.substring(0,4)+lastName.substring(0,4);
		return suggestion.toUpperCase();	
	}
	public String takingIdUser(List<String> listOfIds,String suggestion) {
		String id=suggestion;
		for (int i=1;i<=100;i++) {
			if(listOfIds.contains(id)) {
				id=suggestion+i;
			}else {
				break;
			}
		}
		//For sleep...
		try {
			Thread.sleep(3000);
		}catch(Exception e) {}
		  
		listOfIds.add(id);
		return id;
		
	}
	
	
	
	
}
