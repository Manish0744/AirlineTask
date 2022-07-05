package com.rest.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.main.entity.AirlineInfo;
import com.rest.main.service.IAirlineService;

@RestController
@RequestMapping("/Reservation")
public class ReservationController {
	
	@Autowired
	private IAirlineService iAirlineService;
	
	@PostMapping("/reservationBooking")
	public String booking(@RequestBody AirlineInfo airlineInfo)
	{
		return iAirlineService.bookingReservation(airlineInfo);
	}

	@PutMapping("/reselectSeatNo/{airlineID}/{SeatNo}")
	public String reselectSeatNo(@PathVariable Long airlineID, @PathVariable int SeatNo )
	{
		Long custID = iAirlineService.findCustomerID(airlineID);
		System.out.println(custID + " -------------");
		
		return iAirlineService.updateSeatNo(custID , SeatNo , airlineID);
	}
}
