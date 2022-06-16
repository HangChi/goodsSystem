package com.bhu.shc.entity;

public class Sellers {
	private int sellerId;
	private String sellerName;
	private String sellerAddr;
	private String sellerTele;
	private String certification;
	
	public Sellers() {
		super();
	}
	public Sellers(int sellerId, String sellerName, String sellerAddr, String sellerTele, String certification) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerAddr = sellerAddr;
		this.sellerTele = sellerTele;
		this.certification = certification;
	}

	
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerAddr() {
		return sellerAddr;
	}
	public void setSellerAddr(String sellerAddr) {
		this.sellerAddr = sellerAddr;
	}
	public String getSellerTele() {
		return sellerTele;
	}
	public void setSellerTele(String sellerTele) {
		this.sellerTele = sellerTele;
	}
	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	
	@Override
	public String toString() {
		return "Sellers [sellerId=" + sellerId + ", sellerName=" + sellerName + ", sellerAddr=" + sellerAddr
				+ ", sellerTele=" + sellerTele + ", certification=" + certification + "]";
	}
}
