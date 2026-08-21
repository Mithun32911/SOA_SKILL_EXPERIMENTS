package soa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soa.model.Signup;
import soa.service.service;

@RestController
@RequestMapping("/signup")

public class controller {
	
	service SS;
	
	public controller(service SS) {
		this.SS = SS;
	}
	
	@PostMapping
	public Object signup(@RequestBody Signup signup) {
		return SS.signup(signup);
	}
	
	@GetMapping("/{username}")
	public Object getUser(@PathVariable String username) {
		return SS.getUser(username);
	}
	
	
	

}
