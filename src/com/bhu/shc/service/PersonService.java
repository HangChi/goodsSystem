package com.bhu.shc.service;

import java.util.List;

import com.bhu.shc.entity.Person;

public interface PersonService {
	
	//查询全部Person信息
	List<Person> PersonInfo();
	
	//新增Person信息
	int personAdd(Person person);
	
	//修改Person信息
	int personUpdate(String description,String userName);
	
	//删除Person信息
	int personDelete(int personId);
	
	//按条件查询Person信息
	Person selectByName(String userName);
}
