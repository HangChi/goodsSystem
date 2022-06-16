package com.bhu.shc.service.imp;

import java.util.List;

import com.bhu.shc.entity.Users;
import com.bhu.shc.mapper.UserMapper;
import com.bhu.shc.service.UserService;

public class UserServiceImp implements UserService {

	UserMapper userMapper = new UserMapper();
	
	@Override
	public List<Users> usersInfo() {
		// TODO Auto-generated method stub
		return userMapper.selectAll();
	}
	
	@Override
	public int login(String name, String pwd) {
		
		Users user = userMapper.selectByName(name);
		
		//对获取到的结果进行业务逻辑判断
		if(user == null) {
			//若结果为空，则该用户不存在，返回404
			return 404;	
		}else if(!user.getPassword().equals(pwd)){
			//若该用户存在但密码错误，则返回500
			return 500;
		}else {
			//若以上两个条件均不成立，则登录成功
			return 200;
		}
		
	}

	@Override
	public int register(String name, String password) {
		Users user = new Users(name,password);
		return userMapper.insert(user);
	}

	@Override
	public int logout(String name) {
		// TODO Auto-generated method stub
		return userMapper.delete(name);
	}

	

}
