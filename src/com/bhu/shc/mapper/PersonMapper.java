package com.bhu.shc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bhu.shc.entity.Person;
import com.bhu.shc.util.BaseDao;

public class PersonMapper {
	
	BaseDao baseDao = new BaseDao();
	
	//查询全部个人信息
	public List<Person> selectAll(){
		String sql = "select * from person";
		ResultSet rs = baseDao.query(sql, null);
		List<Person> list = new ArrayList<Person>();
		
		try {
			while(rs.next()) {
				String userName = rs.getString(1);
				String userSex = rs.getString(2);
				String userBirth = rs.getString(3);
				String userHireDate = rs.getString(4);
				String userDesc = rs.getString(5);
				
				Person person = new Person(userName, userSex, userBirth, userHireDate, userDesc);
				list.add(person);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			baseDao.closeAll();
		}
		return list;
	}
	
	//修改个人描述
	public int updateDesc(String desc,String userName) {
		String sql = "update person set user_description = ? where user_name = ?";
		Object[] params = {desc,userName};
		return baseDao.update(sql, params);
	}
	
	public Person selectByName(String name) {
		String sql = "select * from person where user_name = ?";
		Object[] params = {name};
		List<Person> list = new ArrayList<Person>();
		Person person = null;
		ResultSet rs = baseDao.query(sql, params);

		try {
			while(rs.next()) {
				String userName = rs.getString(1);
				String userSex = rs.getString(2);
				String userBirth = rs.getString(3);
				String userHireDate = rs.getString(4);
				String userDesc = rs.getString(5);
				
				person = new Person(userName, userSex, userBirth, userHireDate, userDesc);
				list.add(person);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			baseDao.closeAll();
		}
		return person;
	}
}
