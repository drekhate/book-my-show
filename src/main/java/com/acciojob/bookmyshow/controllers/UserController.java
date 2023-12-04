package com.acciojob.bookmyshow.controllers;

import com.acciojob.bookmyshow.dtos.AddUserRequest;
import com.acciojob.bookmyshow.models.User;
import com.acciojob.bookmyshow.services.UserService;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody AddUserRequest addUserRequest) {
        String result = userService.addUser(addUserRequest);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
