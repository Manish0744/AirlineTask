package com.rest.main.exception;

public class ReservationBookingException extends RuntimeException{
	
	public ReservationBookingException() {
		super();
	}
	public ReservationBookingException(String msg)
	{
		super(msg);
	}
}
