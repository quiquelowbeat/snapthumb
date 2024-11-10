package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.inbound.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snapthumb.thumbnailgenerator.image_creation.background.application.UploadedBackgroundRegister;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions.CantRegisterBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos.UploadedBackgroundRequest;

@RestController
@RequestMapping("/v1/uploaded-backgrounds")
public class UploadedBackgroundController {

    private final UploadedBackgroundRegister uploadedBackgroundRegister;

    public UploadedBackgroundController(UploadedBackgroundRegister uploadedBackgroundRegister) {
        this.uploadedBackgroundRegister = uploadedBackgroundRegister;
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<String> saveUploadedBackground(@PathVariable String uuid,
            @RequestBody UploadedBackgroundRequest request) {
        try {
            uploadedBackgroundRegister.register(uuid, request.url(), request.title(), request.description(),
                    request.uploadedAt());
            return ResponseEntity.ok("Background saved successfully.");
        } catch (CantRegisterBackground e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving uploaded background data.");
        }
    }
}
