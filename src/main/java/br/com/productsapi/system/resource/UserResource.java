package br.com.productsapi.system.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.productsapi.system.dao.UserDAO;
import br.com.productsapi.system.models.User;

@RestController
@RequestMapping("/api/users")
public class UserResource {
	
	@Autowired
	private UserDAO userDAO;
	
	@PostMapping(value="/signup")
	public User createUser(@RequestBody User user) {
		userDAO.save(user);
		return user;
	}

}
