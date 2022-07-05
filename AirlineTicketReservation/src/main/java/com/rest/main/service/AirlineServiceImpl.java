package com.rest.main.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.main.entity.AirlineInfo;
import com.rest.main.entity.CustomerInfo;
import com.rest.main.exception.ReservationBookingException;
import com.rest.main.repository.AirlineRepository;
import com.rest.main.repository.CustomerRepository;

@Service
public class AirlineServiceImpl implements IAirlineService {
	
	@Autowired
	private AirlineRepository airlineRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String bookingReservation(AirlineInfo airlineInfo) {
		
		if (airlineInfo.getAirlineName().isEmpty())
			throw new ReservationBookingException("Airline Name is Mandatory.");
		
		if(airlineInfo.getCustomerInfo().isEmpty())
			throw new ReservationBookingException("Custmoer Info is Mandatory.");
		else
		{
			Set<CustomerInfo> custInfos = airlineInfo.getCustomerInfo();
			for(CustomerInfo custInfo : custInfos)
			{
				System.out.println(custInfo.getCustTicketType() + "-------------------");
				if(custInfo.getCustTicketType().isEmpty() || (! custInfo.getCustTicketType().equals("1st Class") && !custInfo.getCustTicketType().equals("Coach")))
					throw new ReservationBookingException("Custmoer Ticket Type should be 1st Class or Coach only.");
			}
		}
		AirlineInfo airlineInfo2 = airlineRepository.save(airlineInfo);
		if(airlineInfo2.getAirlineID() != null)
			return "Reservation Booking has been done and Reservation ID is : " + airlineInfo2.getAirlineID();
		else
			return null;
	}

	@Override
	public Long findCustomerID(Long airlineID) {
		Optional<AirlineInfo> airlineInfo = airlineRepository.findById(airlineID);
		Set<CustomerInfo> custInfos =  airlineInfo.get().getCustomerInfo();
		Long custID = new Long(0);
		for(CustomerInfo custInfo : custInfos)
		{
			 custID = custInfo.getCustID().longValue();
		}
		return custID;
	}

	@Override
	public String updateSeatNo(Long custID , int SeatNo , Long airlineID) {
		
		Optional<CustomerInfo> custInfo = customerRepository.findById(custID);
		
		if(custInfo.get().getCustTicketType().equals("1st Class") && SeatNo > 20)
			throw new ReservationBookingException("Your ticket Type is 1st Class and you can select seat no. from 1 to 20 only");
		else
		{
			AirlineInfo airlineInfo = airlineRepository.findById(airlineID).orElseThrow(() -> new ReservationBookingException(""));
			airlineInfo.setSeatNo(SeatNo);
			airlineRepository.save(airlineInfo);
		}
		
		return "Seat No has been changed for Reservation ID is : " + airlineID;
	}
}
