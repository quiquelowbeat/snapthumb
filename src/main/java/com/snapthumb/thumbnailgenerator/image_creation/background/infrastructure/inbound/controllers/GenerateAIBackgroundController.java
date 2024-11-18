package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.inbound.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snapthumb.thumbnailgenerator.image_creation.background.application.AIBackgroundGenerator;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundGenerated;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions.CantGenerateAIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos.AIBackgroundResponse;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos.PromptRequest;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.vavr.control.Either;

@RestController
@RequestMapping("/v1/ai-backgrounds")
@Tag(name = "AI Background Generation", description = "AI background generation endpoints")
public class GenerateAIBackgroundController {

    private final AIBackgroundGenerator generator;

    public GenerateAIBackgroundController(AIBackgroundGenerator generator) {
        this.generator = generator;
    }

    @PostMapping("/{uuid}/generate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "AI background generated successfully"),
            @ApiResponse(responseCode = "400", description = "Error generating AI background")
    })
    public ResponseEntity<Either<String, AIBackgroundResponse>> generateBackground(@PathVariable String uuid,
            @RequestBody PromptRequest promptRequest) {
        try {
            AIBackgroundGenerated backgroundGenerated = generator.generateBackground(promptRequest.prompt());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Either.right(AIBackgroundResponse.create(backgroundGenerated)));
        } catch (CantGenerateAIBackground e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Either.left("Error generating AI background."));
        }
    }

}
