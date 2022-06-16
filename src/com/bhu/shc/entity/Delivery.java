package com.bhu.shc.entity;

public class Delivery {
	private int deliveryId;
	private String deliveryName;
	private String orign;
	private String destination;
	private double deliveryPrice;
	
	public Delivery() {
		super();
	}
	public Delivery(int deliveryId, String deliveryName, String orign, String destination, double deliveryPrice) {
		super();
		this.deliveryId = deliveryId;
		this.deliveryName = deliveryName;
		this.orign = orign;
		this.destination = destination;
		this.deliveryPrice = deliveryPrice;
	}
	
	
	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public String getOrign() {
		return orign;
	}
	public void setOrign(String orign) {
		this.orign = orign;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getDeliveryPrice() {
		return deliveryPrice;
	}
	public void setDeliveryPrice(double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}
	
	@Override
	public String toString() {
		return "Delivery [deliveryId=" + deliveryId + ", deliveryName=" + deliveryName + ", orign=" + orign
				+ ", destination=" + destination + ", deliveryPrice=" + deliveryPrice + "]";
	}
}
