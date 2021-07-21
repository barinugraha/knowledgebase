package com.dom.kb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dom.kb.exception.ResourceNotFoundException;
import com.dom.kb.model.Users;
import com.dom.kb.repo.UsersRepository;

@RestController
@RequestMapping("/api")
public class UsersController {

	@Autowired
	UsersRepository usersRepository;
	
	@GetMapping("/users")
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @PostMapping("/users")
    public Users createUsers(@Valid @RequestBody Users users) {
        return usersRepository.save(users);
    }

    @GetMapping("/users/{id}")
    public Users getUsersById(@PathVariable(value = "id") Long usersId) {
        return usersRepository.findById(usersId)
                .orElseThrow(() -> new ResourceNotFoundException("Users", "id", usersId));
    }

    @PutMapping("/users/{id}")
    public Users updateUSers(@PathVariable(value = "id") Long usersId,
                                           @Valid @RequestBody Users usersDetails) {

    	Users users = usersRepository.findById(usersId)
                .orElseThrow(() -> new ResourceNotFoundException("Users", "id", usersId));

    	users.setUsername(usersDetails.getUsername());
    	users.setPassword(usersDetails.getPassword());
    	users.setFullname(usersDetails.getFullname());

        Users updatedUsers = usersRepository.save(users);
        return updatedUsers;
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUsers(@PathVariable(value = "id") Long usersId) {
    	Users users = usersRepository.findById(usersId)
                .orElseThrow(() -> new ResourceNotFoundException("Users", "id", usersId));

    	usersRepository.delete(users);

        return ResponseEntity.ok().build();
    }
}
