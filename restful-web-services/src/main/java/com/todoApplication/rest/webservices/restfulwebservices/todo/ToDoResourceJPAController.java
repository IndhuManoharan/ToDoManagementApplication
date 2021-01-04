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
public class ToDoResourceJPAController {

	@Autowired
	TodoRepository todoRepository;
	
	@Autowired
	TodoHardcodedService todoService;
	
	@GetMapping("/jpa/user/{username}/todos")
	public List<ToDo> getToDosList(@PathVariable String username){
		return todoRepository.findByUsername(username);
//		return todoService.getAllTodosOfUser(username);
	}
	
	@DeleteMapping("/jpa/user/{username}/todos/{id}")
	public ResponseEntity<Void> deleteToDo(@PathVariable String username, @PathVariable long id) {
//		ToDo todo = todoService.deleteAToDo(id);
		todoRepository.deleteById(id);
//		if(todo != null) {
			return ResponseEntity.noContent().build();
//		}
//		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/jpa/user/{username}/todos/{id}")
	public ToDo retrieveTodo(@PathVariable String username,@PathVariable Long id){
		return todoRepository.findById(id).get();
	}
	
	@PutMapping("/jpa/user/{username}/todos/{id}")
	public ResponseEntity<ToDo> upsateAndSaveTodo(@PathVariable String username,@PathVariable long id , 
			@RequestBody ToDo todo){
		ToDo updatedTodo = todoRepository.save(todo);
		return new ResponseEntity<ToDo>(updatedTodo,HttpStatus.OK);
	}
	
	@PostMapping("/jpa/user/{username}/todos")
	public ResponseEntity<Void> addNewTodo(@PathVariable String username,@RequestBody ToDo todo){
		todo.setUsername(username);
		ToDo createdTodo = todoRepository.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}

