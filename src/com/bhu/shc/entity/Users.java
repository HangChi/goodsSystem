package com.bhu.shc.entity;

public class Users {
	private String userName;
	private String password;
	
	public Users(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public Users() {
		super();
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Users [userName=" + userName + ", password=" + password + "]";
	}
	
}
