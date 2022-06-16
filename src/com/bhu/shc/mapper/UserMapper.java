package com.bhu.shc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bhu.shc.entity.Users;
import com.bhu.shc.util.BaseDao;

public class UserMapper {
	BaseDao baseDao = new BaseDao();
	
	public List<Users> selectAll(){
		String sql = "select * from users";
		ResultSet rs = baseDao.query(sql, null);
		
		List<Users> list = new ArrayList<Users>();
		try {
			while(rs.next()) {
				String userName = rs.getString(1);
				String password = rs.getString(2);
				
				Users user = new Users(userName, password);
				list.add(user);
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
	
	//条件查询
	public Users selectByName(String name) {
		String sql = "select * from users where username = ?";
		Object[] params = {name};
		
		ResultSet rs = baseDao.query(sql, params);
		Users user = null;
		try {
			while(rs.next()) {
				String userName = rs.getString(1);
				String password = rs.getString(2);
				
				user = new Users(userName, password);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			baseDao.closeAll();
		}
		return user;
	}
	
	//增加用户信息
	public int insert(Users user) {
		String sql = "insert into users values(?,?)";
		Object[] params = {user.getUserName(),user.getPassword()};
		return baseDao.update(sql, params);
	}
	
	
	//删除用户信息
	public int delete(String userName) {
		String sql = "delete from users where username=?";
		Object[] params = {userName};
		return baseDao.update(sql, params);
	}
}
