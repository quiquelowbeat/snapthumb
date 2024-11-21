package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.inbound.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snapthumb.thumbnailgenerator.image_creation.background.application.UploadedBackgroundRegister;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions.CantRegisterBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos.UploadedBackgroundRequest;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/uploaded-backgrounds")
@Tag(name = "Uploaded Backgrounds", description = "Uploaded background management endpoints")
public class UploadedBackgroundController {

    private final UploadedBackgroundRegister uploadedBackgroundRegister;

    public UploadedBackgroundController(UploadedBackgroundRegister uploadedBackgroundRegister) {
        this.uploadedBackgroundRegister = uploadedBackgroundRegister;
    }

    @PostMapping("/{uuid}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Background uploaded successfully"),
            @ApiResponse(responseCode = "400", description = "Error saving uploaded background")
    })
    public ResponseEntity<String> saveUploadedBackground(@PathVariable String uuid,
            @RequestBody UploadedBackgroundRequest request) {
        try {
            uploadedBackgroundRegister.register(uuid, request.url(), request.title(), request.description(),
                    request.uploadedAt());
            return ResponseEntity.ok("Uploaded Background saved successfully.");
        } catch (CantRegisterBackground e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error saving uploaded background data.");
        }
    }
}
