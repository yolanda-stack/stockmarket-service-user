package com.smc.dao;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;

import com.smc.entity.User;


public interface UserDao extends JpaRepository<User,Long>{

	User findByUsername(String username);
	
	 @Modifying
	 @Transactional
	 @Query("update User u set u.confirmed = :confirmed where u.username=:username")
	 int saveUsersByUsernameAndConfirmed(@Param("username") String username, @Param("confirmed") String confirmed);
	
	 @Modifying
	 @Transactional
	 @Query("update User u set u.updatets = :updatets where u.username=:username")
	 int saveUsersByUsernameAndUpdatets(@Param("username") String username, @Param("updatets") Date updatets);
	
	 User findByUsernameAndPassword(String username, String password);



}
