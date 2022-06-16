package com.bhu.shc.entity;

public class Buyers {
	private int buyerId;
	private String buyerName;
	private String buyerAddr;
	private String buyerTele;
	private int orderNum;
	
	public Buyers() {
		super();
	}
	public Buyers(int buyerId, String buyerName, String buyerAddr, String buyerTele, int orderNum) {
		super();
		this.buyerId = buyerId;
		this.buyerName = buyerName;
		this.buyerAddr = buyerAddr;
		this.buyerTele = buyerTele;
		this.orderNum = orderNum;
	}
	
	
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getBuyerAddr() {
		return buyerAddr;
	}
	public void setBuyerAddr(String buyerAddr) {
		this.buyerAddr = buyerAddr;
	}
	public String getBuyerTele() {
		return buyerTele;
	}
	public void setBuyerTele(String buyerTele) {
		this.buyerTele = buyerTele;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	
	@Override
	public String toString() {
		return "Buyers [buyerId=" + buyerId + ", buyerName=" + buyerName + ", buyerAddr=" + buyerAddr + ", buyerTele="
				+ buyerTele + ", orderNum=" + orderNum + "]";
	}
	
}
