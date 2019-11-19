package com.practice.rest.webservices.restfulwebservices.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retrieveUsers() {
	return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable("id") int userId) {
	User user = userDaoService.findUser(userId);
	if(user == null) {
	    throw new UserNotFoundException("id :"+userId );
	}
	
	//retrieveUSer
	/*
	 * EntityModel<User> entityModel = new EntityModel<User>(user);
	 * ControllerLinkBuilder linkTo =
	 * linkTo(methodOn(this.getClass()).retrieveUsers());
	 * entityModel.add(linkTo.withRel("all-users"));
	 */
	return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
	User savedUser = userDaoService.saveUser(user);
	return ResponseEntity.status(HttpStatus.CREATED).location(ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(savedUser.getId()).toUri()).body(user);
    }
    
    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> createUser(@PathVariable("id") int id) {
	User deletedUser = userDaoService.deleteById(id);
	if(deletedUser == null) {
	    throw new UserNotFoundException("id :"+id);
	}
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
