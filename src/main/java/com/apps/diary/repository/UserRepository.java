package main.java.com.apps.diary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.com.apps.diary.entity.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity, Integer> 
{
	
    Optional<UserEntity> findByEmail(String email);
    


}
