/**
 * 
 */
package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repository.UserRepository;

/**
 * @author Govin
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent())
			return user.get();
		return null;
	}

	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}

}
