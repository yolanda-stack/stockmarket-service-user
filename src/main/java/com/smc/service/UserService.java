package com.smc.service;


import java.util.Date;

import com.smc.entity.User;

public interface UserService {
   
    User getUserByUsername(String username);
    User saveUserInfo(User user);
    int setConfirmedByUsername(String username, String confirmed);
    int setUpdatetsByUsername(String username, Date updatets);
    User getUserByUsernameAndPassword(String username, String password);
    
	}