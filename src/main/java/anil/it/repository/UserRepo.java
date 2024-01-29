package anil.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import anil.it.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	public User findByEmailAndPassword(String email, String password);

}
