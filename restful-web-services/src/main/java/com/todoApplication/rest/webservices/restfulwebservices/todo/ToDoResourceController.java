package com.todoApplication.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ToDoResourceController {

	@Autowired
	TodoHardcodedService todoService;
	
	@GetMapping("user/{username}/todos")
	public List<ToDo> getToDosList(@PathVariable String username){
		return todoService.getAllTodosOfUser(username);
	}
	
	@DeleteMapping("user/{username}/todos/{id}")
	public ResponseEntity<Void> deleteToDo(@PathVariable String username, @PathVariable long id) {
		ToDo todo = todoService.deleteAToDo(id);
		if(todo != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("user/{username}/todos/{id}")
	public ToDo retrieveTodo(@PathVariable String username,@PathVariable long id){
		return todoService.findToDo(id);
	}
	
	@PutMapping("user/{username}/todos/{id}")
	public ResponseEntity<ToDo> upsateAndSaveTodo(@PathVariable String username,@PathVariable long id , 
			@RequestBody ToDo todo){
		ToDo updatedTodo = todoService.save(todo);
		return new ResponseEntity<ToDo>(updatedTodo,HttpStatus.OK);
	}
	
	@PostMapping("user/{username}/todos")
	public ResponseEntity<Void> addNewTodo(@PathVariable String username,@RequestBody ToDo todo){
		ToDo createdTodo = todoService.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}