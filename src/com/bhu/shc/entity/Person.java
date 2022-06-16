package com.bhu.shc.entity;

public class Person {
	private String userName;
	private String userSex;
	private String userBirth;
	private String userHireDate;
	private String userDesc;
	
	
	public Person() {
		super();
	}
	public Person(String userName, String userSex, String userBirth, String userHireDate, String userDesc) {
		super();
		this.userName = userName;
		this.userSex = userSex;
		this.userBirth = userBirth;
		this.userHireDate = userHireDate;
		this.userDesc = userDesc;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserHireDate() {
		return userHireDate;
	}
	public void setUserHireDate(String userHireDate) {
		this.userHireDate = userHireDate;
	}
	public String getUserDesc() {
		return userDesc;
	}
	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}
	
	
	@Override
	public String toString() {
		return "Person [userName=" + userName + ", userSex=" + userSex + ", userBirth=" + userBirth + ", userHireDate="
				+ userHireDate + ", userDesc=" + userDesc + "]";
	}
	
}
