package com.susantoboxshipping.vo;

import java.sql.Timestamp;

public class ShipmentInfo {
	private Integer id;
	private Timestamp departureDate;
	private Timestamp arrivalDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Timestamp departureDate) {
		this.departureDate = departureDate;
	}
	public Timestamp getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Timestamp arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	@Override
	public String toString() {
		return "ShipmentInfo [id=" + id + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + "]";
	}
	
}
