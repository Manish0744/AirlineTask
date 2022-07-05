package com.rest.main.entity;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "CustomerInfo")
public class CustomerInfo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long custID;
	
	private String custName;
	
	@JsonFormat(pattern = "yyy-MM-dd")
	private Date custDOB;
	
	private String custMobileNo;
	
	private String custEmailID;
	
	private String custTicketType;
	
	
	@ManyToMany(mappedBy = "customerInfo")
	Set<AirlineInfo> airlineInfo = new LinkedHashSet<>();
	

	public Long getCustID() {
		return custID;
	}

	public void setCustID(Long custID) {
		this.custID = custID;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Date getCustDOB() {
		return custDOB;
	}

	public void setCustDOB(Date custDOB) {
		this.custDOB = custDOB;
	}

	public String getCustMobileNo() {
		return custMobileNo;
	}

	public void setCustMobileNo(String custMobileNo) {
		this.custMobileNo = custMobileNo;
	}

	public String getCustEmailID() {
		return custEmailID;
	}

	public void setCustEmailID(String custEmailID) {
		this.custEmailID = custEmailID;
	}

	public String getCustTicketType() {
		return custTicketType;
	}

	public void setCustTicketType(String custTicketType) {
		this.custTicketType = custTicketType;
	}

	@Override
	public String toString() {
		return "CustomerInfo [custID=" + custID + ", custName=" + custName + ", custDOB=" + custDOB + ", custMobileNo="
				+ custMobileNo + ", custEmailID=" + custEmailID + ", custTicketType=" + custTicketType + "]";
	}
}
