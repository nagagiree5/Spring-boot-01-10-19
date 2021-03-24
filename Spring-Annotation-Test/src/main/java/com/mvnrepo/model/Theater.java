package com.mvnrepo.model;

public class Theater {

	private String movieName;
	private String theaterName;
	public Theater(String movieName, String theaterName) {
		this.movieName = movieName;
		this.theaterName = theaterName;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	
}
