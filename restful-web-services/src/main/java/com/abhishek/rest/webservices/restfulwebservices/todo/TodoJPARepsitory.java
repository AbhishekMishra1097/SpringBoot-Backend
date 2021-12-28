package com.abhishek.rest.webservices.restfulwebservices.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoJPARepsitory extends JpaRepository<Todo, Long>{

	List<Todo> findByUsername(String username);
}
