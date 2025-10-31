package com.operation.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.operation.Entity.User;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findById(Integer id);
	
	Optional<User> findByName(String name);

	boolean existsByName(String name);
	

}
