package com.rest.main.entity;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "AirlineInfo")
public class AirlineInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long airlineID;
	
	private String airlineName;
	
	@JsonFormat(pattern = "yyy-MM-dd")
	private Date travelingDate;
	
	private String travelingPlace;
	
	private int SeatNo;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Reservation", joinColumns = @JoinColumn(name = "AirlineID" , referencedColumnName = "airlineID"),
	inverseJoinColumns = @JoinColumn(name = "CustomerID" , referencedColumnName = "custID"))
	Set<CustomerInfo> customerInfo = new LinkedHashSet();

	public Long getAirlineID() {
		return airlineID;
	}

	public void setAirlineID(Long airlineID) {
		this.airlineID = airlineID;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public Date getTravelingDate() {
		return travelingDate;
	}

	public void setTravelingDate(Date travelingDate) {
		this.travelingDate = travelingDate;
	}

	public String getTravelingPlace() {
		return travelingPlace;
	}

	public void setTravelingPlace(String travelingPlace) {
		this.travelingPlace = travelingPlace;
	}

	public int getSeatNo() {
		return SeatNo;
	}

	public void setSeatNo(int seatNo) {
		SeatNo = seatNo;
	}

	public Set<CustomerInfo> getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(Set<CustomerInfo> customerInfo) {
		this.customerInfo = customerInfo;
	}

	@Override
	public String toString() {
		return "AirlineInfo [airlineID=" + airlineID + ", airlineName=" + airlineName + ", travelingDate="
				+ travelingDate + ", travelingPlace=" + travelingPlace + ", SeatNo=" + SeatNo + ", customerInfo="
				+ customerInfo + "]";
	}
}
