package com.susantoboxshipping.vo;

public class ShipmentBooking {
	private Integer id;
	private Integer numOfBox;
	private String desAddress;
	private String picAdress;
	private Integer shipmentInfoId;
	private String messageCus;
	private Integer status;
	private String picTime;
	private String messageShi;
	private String cusEmail;
	private String shiEmail;
	private String colEmail;
	
	@Override
	public String toString() {
		return "ShipmentBooking [id=" + id + ", numOfBox=" + numOfBox + ", desAddress=" + desAddress + ", picAdress="
				+ picAdress + ", shipmentInfoId=" + shipmentInfoId + ", messageCus=" + messageCus + ", status=" + status
				+ ", picTime=" + picTime + ", messageShi=" + messageShi + ", cusEmail=" + cusEmail + ", shiEmail="
				+ shiEmail + ", colEmail=" + colEmail + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumOfBox() {
		return numOfBox;
	}
	public void setNumOfBox(Integer numOfBox) {
		this.numOfBox = numOfBox;
	}
	public String getDesAddress() {
		return desAddress;
	}
	public void setDesAddress(String desAddress) {
		this.desAddress = desAddress;
	}
	public String getPicAdress() {
		return picAdress;
	}
	public void setPicAdress(String picAdress) {
		this.picAdress = picAdress;
	}
	public Integer getShipmentInfoId() {
		return shipmentInfoId;
	}
	public void setShipmentInfoId(Integer shipmentInfoId) {
		this.shipmentInfoId = shipmentInfoId;
	}
	public String getMessageCus() {
		return messageCus;
	}
	public void setMessageCus(String messageCus) {
		this.messageCus = messageCus;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPicTime() {
		return picTime;
	}
	public void setPicTime(String picTime) {
		this.picTime = picTime;
	}
	public String getMessageShi() {
		return messageShi;
	}
	public void setMessageShi(String messageShi) {
		this.messageShi = messageShi;
	}
	public String getCusEmail() {
		return cusEmail;
	}
	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}
	public String getShiEmail() {
		return shiEmail;
	}
	public void setShiEmail(String shiEmail) {
		this.shiEmail = shiEmail;
	}
	public String getColEmail() {
		return colEmail;
	}
	public void setColEmail(String colEmail) {
		this.colEmail = colEmail;
	}
}
