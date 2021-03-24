package io.springboot2.x.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.springboot2.x.domain.Passenger;
import io.springboot2.x.service.IPassengerService;

@Controller
public class PaginationController {

	@Autowired
	private IPassengerService service;
	
	@GetMapping(value = "/getPassengers")
	public String getPassengers(@RequestParam(value = "pageNor",defaultValue = "0")Integer pageNor,Model model) {
		
		Page<Passenger> page=service.getEmployees(pageNor);
		
		List<Passenger> passengerList=page.getContent();
		boolean previous=page.hasPrevious();
		boolean next=page.hasNext();
		Integer i=page.getNumber();
		
		model.addAttribute("previous", previous);
		model.addAttribute("next", next);
		model.addAttribute("currentPageNor", i);
		model.addAttribute("passengers", passengerList);
		
		return "ShowPassengers";
		
	}
	

}
