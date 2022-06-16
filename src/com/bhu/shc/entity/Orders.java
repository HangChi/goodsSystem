package com.bhu.shc.entity;

public class Orders {
	private int orderId;
	private String orderName;
	private int orderNum;
	private String remark;
	private double orderSum;
	private String orderDate;
	private String orderStmt;
	private int buyerId;
	private int goodId;
	private int deliveryId;
	
	
	public Orders() {
		super();
	}
	public Orders(int orderId, String orderName, int orderNum, String remark, double orderSum, String orderDate,
			String orderStmt, int buyerId, int goodId, int deliveryId) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderNum = orderNum;
		this.remark = remark;
		this.orderSum = orderSum;
		this.orderDate = orderDate;
		this.orderStmt = orderStmt;
		this.buyerId = buyerId;
		this.goodId = goodId;
		this.deliveryId = deliveryId;
	}
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public double getOrderSum() {
		return orderSum;
	}
	public void setOrderSum(double orderSum) {
		this.orderSum = orderSum;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStmt() {
		return orderStmt;
	}
	public void setOrderStmt(String orderStmt) {
		this.orderStmt = orderStmt;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	
	
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderName=" + orderName + ", orderNum=" + orderNum + ", remark="
				+ remark + ", orderSum=" + orderSum + ", orderDate=" + orderDate + ", orderStmt=" + orderStmt
				+ ", buyerId=" + buyerId + ", goodId=" + goodId + ", deliveryId=" + deliveryId + "]";
	}
}
