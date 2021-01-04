package com.todoApplication.rest.webservices.restfulwebservices.todo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<ToDo, Long>{
	List<ToDo> findByUsername(String username);

}
