package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.inbound.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snapthumb.thumbnailgenerator.image_creation.background.application.AIBackgroundRegister;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos.AIBackgroundRequest;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos.MessageResponse;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/ai-backgrounds")
@Tag(name = "AI Backgrounds", description = "AI background management endpoints")
public class AIBackgroundController {

    private final AIBackgroundRegister aiBackgroundRegister;

    public AIBackgroundController(AIBackgroundRegister aiBackgroundRegister) {
        this.aiBackgroundRegister = aiBackgroundRegister;
    }

    @PostMapping("/{uuid}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "AI background saved successfully"),
            @ApiResponse(responseCode = "400", description = "Error validating sent data")
    })
    public ResponseEntity<MessageResponse> saveAIBackground(@PathVariable String uuid,
            @RequestBody AIBackgroundRequest request) {
        aiBackgroundRegister.register(uuid, request.url(), request.prompt(), request.title(), request.description(),
                request.createdAt());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(MessageResponse.create("AI generated background saved successfully."));
    }
}