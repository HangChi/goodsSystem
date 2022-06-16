package com.bhu.shc.service.imp;

import java.util.List;

import com.bhu.shc.entity.Person;
import com.bhu.shc.mapper.PersonMapper;
import com.bhu.shc.service.PersonService;

public class PersonServiceImp implements PersonService {

	
	PersonMapper personMapper = new PersonMapper();
	
	@Override
	public List<Person> PersonInfo() {
		// TODO Auto-generated method stub
		return personMapper.selectAll();
	}

	@Override
	public int personAdd(Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int personUpdate(String description, String userName) {
		// TODO Auto-generated method stub
		return personMapper.updateDesc(description, userName);
	}

	@Override
	public int personDelete(int personId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Person selectByName(String name) {
		// TODO Auto-generated method stub
		return personMapper.selectByName(name);
	}

}
