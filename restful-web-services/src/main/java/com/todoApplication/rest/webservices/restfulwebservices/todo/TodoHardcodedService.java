package com.todoApplication.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

//@Component
@Service
public class TodoHardcodedService {
	
	public static List<ToDo> todos = new ArrayList();
	static long idCounter = 0;

	static {
		todos.add(new ToDo(++idCounter, "Indhu", "Learn to dance", new Date(), false));
		todos.add(new ToDo(++idCounter, "Indhu", "Learn Angular", new Date(), false));
		todos.add(new ToDo(++idCounter, "Indhu", "Learn Microservices", new Date(), false));
		todos.add(new ToDo(++idCounter, "Indhu", "Learn Spring", new Date(), false));
		todos.add(new ToDo(++idCounter, "Indhu", "Learn Python", new Date(), false));
	}
	
	public List<ToDo> getAllTodosOfUser(String username) {
		return todos;
	}
	
	public ToDo deleteAToDo(long id) {
		ToDo toDo = findToDo(id);
		if(toDo == null) return null;
		if(todos.remove(toDo)) return toDo;
		return null;
	}

	public ToDo findToDo(long id) {
		for(ToDo todo:todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	public ToDo save(ToDo todo) {
		if(todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}
		else {
			deleteAToDo(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
}
