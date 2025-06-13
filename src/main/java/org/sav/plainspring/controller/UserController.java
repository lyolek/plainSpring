package org.sav.plainspring.controller;

import lombok.extern.slf4j.Slf4j;
import org.sav.plainspring.pojo.User;
import org.sav.plainspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

	UserService userService;


	public UserController(@Qualifier("userService") UserService userService) {
		this.userService = userService;
		log.info("--------------------------UserControllerConstructor----------------------------");
	}

	@GetMapping("/{id}")
	public ResponseEntity<String> getUser(@PathVariable int id) {
		return ResponseEntity.ok(userService.getName(id));
	}

	@GetMapping(value = "/all", produces = "application/json")
	public ResponseEntity<List<User>> getAll() {
		return ResponseEntity.ok(userService.getAll());
	}

	@PostConstruct
	public void init() {
		log.info("--------------------------init----------------------------");
	}
}
