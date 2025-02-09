package com.snapthumb.thumbnailgenerator.user_management.infrastructure.inbound.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snapthumb.thumbnailgenerator.user_management.application.UserFinder;
import com.snapthumb.thumbnailgenerator.user_management.application.UserRegister;
import com.snapthumb.thumbnailgenerator.user_management.domain.User;
import com.snapthumb.thumbnailgenerator.user_management.domain.UserNotFound;
import com.snapthumb.thumbnailgenerator.user_management.infrastructure.dtos.UserRequest;
import com.snapthumb.thumbnailgenerator.user_management.infrastructure.dtos.UserResponse;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.vavr.control.Either;

@RestController
@RequestMapping("/v1/users")
@Tag(name = "Users", description = "User management endpoints")
public class UserController {

        private final UserRegister register;
        private final UserFinder finder;

        public UserController(UserRegister register, UserFinder finder) {
                this.register = register;
                this.finder = finder;
        }

        @PostMapping("/{uuid}")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "User registered successfully"),
                        @ApiResponse(responseCode = "400", description = "Error validating sent data")
        })
        public ResponseEntity<Void> registerUser(@PathVariable String uuid,
                        @RequestBody UserRequest request) {
                register.register(uuid, request.firstName(), request.lastName(),
                                request.email(), request.password());
                return ResponseEntity.status(HttpStatus.CREATED).build();

        }

        @GetMapping("/{uuid}")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "User found successfully", useReturnTypeSchema = true),
                        @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
        })
        public ResponseEntity<UserResponse> findUserBy(@PathVariable String uuid) {
                Either<UserNotFound, User> found = finder.find(uuid);
                return found.fold(error -> ResponseEntity.notFound().build(),
                                user -> ResponseEntity.ok().body(UserResponse.createFrom(user)));

        }
}
