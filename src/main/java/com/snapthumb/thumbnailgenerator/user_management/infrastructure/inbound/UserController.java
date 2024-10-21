package com.snapthumb.thumbnailgenerator.user_management.infrastructure.inbound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snapthumb.thumbnailgenerator.user_management.application.UserRegister;
import com.snapthumb.thumbnailgenerator.user_management.domain.UserRequest;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserRegister userRegister;

    public UserController(UserRegister userRegister) {
        this.userRegister = userRegister;
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<String> registerUser(@PathVariable String uuid,
            @RequestBody UserRequest request) {
        try {
            userRegister.register(uuid, request.name(), request.lastName(),
               request.email(), request.rawPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body("User saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving user data");
        }
    }
    
}
