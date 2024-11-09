package main.java.com.apps.diary.service;

import java.util.Optional;

import main.java.com.apps.diary.entity.UserEntity;


public interface UserService 
{
	
	Optional<UserEntity> getUserByEmail(String email);
	
	Boolean insertUser(UserEntity user);
	

}
