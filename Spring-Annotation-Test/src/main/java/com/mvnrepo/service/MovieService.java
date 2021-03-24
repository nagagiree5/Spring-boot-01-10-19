package com.mvnrepo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mvnrepo.model.Theater;

@Service
public class MovieService {
	
	@Autowired
	TheaterService theaterService;
	
	@Value("${movie.name}")
	String movieName;
	
	public void getListOfMoviesHere() {
		List<Theater> listFound=theaterService.getTheaterByMovieName(movieName);
		for (Theater theater : listFound) {
			System.out.println("Theater name: "+theater.getTheaterName()+"Movie name"+theater.getMovieName());
			  
		}
		
	}
	

}
