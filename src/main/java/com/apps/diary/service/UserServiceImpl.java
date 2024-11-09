package main.java.com.apps.diary.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.apps.diary.entity.UserEntity;
import main.java.com.apps.diary.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService 
{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public Optional<UserEntity> getUserByEmail(String email) 
	{
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}
	
	
	@Override
	public Boolean insertUser(UserEntity user) 
	{
		
		UserEntity savedUser=userRepository.save(user);
		
		if(savedUser.getId()>0)
		{
			return true;
		}
		return false;
	}

}
