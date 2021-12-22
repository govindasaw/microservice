/**
 * 
 */
package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;

/**
 * @author Govin
 *
 */
@RestController
@RequestMapping("user")
public class UsersController {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<?> userById(@PathVariable("id") Long id) {
		User entity = userService.getUserById(id);
		return new ResponseEntity<User>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllUsers() {
		List<User> entity = userService.getAllUsers();
		return new ResponseEntity<List<User>>(entity, new HttpHeaders(), HttpStatus.OK);
	}

}
