package com.bhu.shc.service;

import java.util.List;

import com.bhu.shc.entity.Users;

public interface UserService {
	
	List<Users> usersInfo();
	
	/**
	 * 登录功能
	 * @param name
	 * @param pwd
	 * @return 返回状态码  200-登录成功  404-用户名不存在  500-密码错误
	 */
	int login(String name, String pwd);
	
	/**
	 * 注册功能
	 * @param name
	 * @param password
	 * @return 0--注册失败 1--注册成功
	 */
	int register(String name, String password);
	
	/**
	 * 注销功能
	 * @param name
	 * @return 0--注销失败 1--注销成功
	 */
	int logout(String name);
}
