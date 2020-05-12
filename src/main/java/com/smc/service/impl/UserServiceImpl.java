package com.smc.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smc.entity.User;
import com.smc.service.UserService;
import com.smc.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao usersReao;
	
	public User getUserByUsername(String username) {
		return usersReao.findByUsername(username);
	}
	
	public User saveUserInfo(User user) {
		return usersReao.save(user);
	};
	
	public int setConfirmedByUsername(String username, String confirmed) {
		return usersReao.saveUsersByUsernameAndConfirmed(username, "1");
	};
	
	public int setUpdatetsByUsername(String username, Date updatets) {
		return usersReao.saveUsersByUsernameAndUpdatets(username, updatets);
	};

	public User getUserByUsernameAndPassword(String username, String password) {
		return usersReao.findByUsername(username);
	}
    
}