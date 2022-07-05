package com.rest.main.service;

import com.rest.main.entity.AirlineInfo;

public interface IAirlineService {
	
	String bookingReservation(AirlineInfo airlineInfo);

	Long findCustomerID(Long airlineID);
	
	String updateSeatNo(Long custID , int SeatNo, Long airlineID);
}
