package com.snapthumb.thumbnailgenerator.user_management.infrastructure.inbound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snapthumb.thumbnailgenerator.user_management.application.UserFinder;
import com.snapthumb.thumbnailgenerator.user_management.application.UserRegister;
import com.snapthumb.thumbnailgenerator.user_management.domain.User;
import com.snapthumb.thumbnailgenerator.user_management.domain.exceptions.CantSaveUser;
import com.snapthumb.thumbnailgenerator.user_management.domain.exceptions.UserNotFound;
import com.snapthumb.thumbnailgenerator.user_management.infrastructure.dtos.DTOUserFactory;
import com.snapthumb.thumbnailgenerator.user_management.infrastructure.dtos.UserRequest;
import com.snapthumb.thumbnailgenerator.user_management.infrastructure.dtos.UserResponse;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserRegister register;
    private final UserFinder finder;

    public UserController(UserRegister register, UserFinder finder) {
        this.register = register;
        this.finder = finder;
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<String> registerUser(@PathVariable String uuid,
            @RequestBody UserRequest request) {
        try {
            register.register(uuid, request.name(), request.lastName(),
                    request.email(), request.password());
            return ResponseEntity.status(HttpStatus.CREATED).body("User saved successfully");
        } catch (CantSaveUser e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving user data");
        }
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserResponse> findUserBy(@PathVariable String uuid) {
        try {
            User user = finder.find(uuid);
            UserResponse userResponse = DTOUserFactory.create(user);
            return ResponseEntity.ok().body(userResponse);
        } catch (UserNotFound e) {
            return ResponseEntity.notFound().build();
        }
    }
}
