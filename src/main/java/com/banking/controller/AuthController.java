package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.banking.service.UserService;

@RestController
@RequestMapping("/api")

public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequest request) {
        boolean success = userService.login(request.getUsername(), request.getPassword());
        if (success) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
        }
    
}
}

class UserLoginRequest {
    private String username;
    private String password;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserLoginRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public UserLoginRequest() {
		super();
	}
    
}
