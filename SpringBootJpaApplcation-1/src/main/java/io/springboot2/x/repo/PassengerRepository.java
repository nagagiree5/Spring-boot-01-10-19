package io.springboot2.x.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.springboot2.x.domain.Passenger;


@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
	
	Passenger   findByEmailId(String  emailId);
	
	@Query("select  passenger  from  Passenger  passenger  where  passenger.seatNumber between  ?1  and  ?2")	
	List<Passenger>   readPassengersBetweenSeatNumbers(Integer  s1, Integer  s2);
	
	@Query("select  passenger  from  Passenger  passenger  where  passenger.seatNumber between  :begin  and  :end")	
	List<Passenger>   readPassengersBetweenSeat(@Param("begin")Integer  s1, @Param("end")Integer  s2);
	
	
	
	
	
	List<Passenger>    byFirstName();

}
