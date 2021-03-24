package com.mvnrepo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mvnrepo.model.Theater;

@Service
public class TheaterService {

	private static Theater[] theaters;
	static {
		theaters=new Theater[]{
			new Theater("Prasad-Imax","Valmiki"),
			new Theater("Sathyam","Kamma Rajamlo Kadapa Reddlu"),
			new Theater("Prasad-Imax","Frozen2"),
			new Theater("Pvr","Something")
		};
	}
	
	public List<Theater> getTheaterByMovieName(String movieName) {
		
		List<Theater> found= new ArrayList<Theater>();
		for (Theater theater : theaters) {
			if (theater.getMovieName().equals(movieName)) {
				found.add(theater);
				
			}
			
		}
		
		return found;
	}
	
	
	
	
	
}
