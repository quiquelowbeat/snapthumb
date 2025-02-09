package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.inbound.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snapthumb.thumbnailgenerator.image_creation.background.application.AIBackgroundGenerator;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos.AIBackgroundResponse;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos.PromptRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/ai-backgrounds")
@Tag(name = "AI Backgrounds", description = "AI background management endpoints")
public class GenerateAIBackgroundController {

        private final AIBackgroundGenerator generator;

        public GenerateAIBackgroundController(AIBackgroundGenerator generator) {
                this.generator = generator;
        }

        @PostMapping("/{uuid}/generate")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "AI background generated successfully", content = @Content(schema = @Schema(implementation = AIBackgroundResponse.class))),
                        @ApiResponse(responseCode = "400", description = "Error validating sent data")
        })
        public ResponseEntity<AIBackgroundResponse> generateBackground(@PathVariable String uuid,
                        @RequestBody PromptRequest promptRequest) {
                return generator.generateBackground(promptRequest.prompt())
                                .map(background -> ResponseEntity.status(HttpStatus.CREATED)
                                                .body(AIBackgroundResponse.createFrom(background)))
                                .getOrElseGet(error -> ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                                                .build());
        }
}
