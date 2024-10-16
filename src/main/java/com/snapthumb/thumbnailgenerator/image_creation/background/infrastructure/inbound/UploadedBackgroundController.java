package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.inbound;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snapthumb.thumbnailgenerator.image_creation.background.application.UploadedBackgroundRegister;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackgroundRequest;

@RestController
@RequestMapping("/v1/uploaded-backgrounds")
public class UploadedBackgroundController {

    private final UploadedBackgroundRegister register;

    public UploadedBackgroundController(UploadedBackgroundRegister register) {
        this.register = register;
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<String> saveUploadedBackground(@PathVariable String uuid,
            @RequestBody UploadedBackgroundRequest request) {
        try {
            UploadedBackground background = new UploadedBackground(UUID.fromString(uuid), request.url(), request.title(),
                    request.description());
            register.save(background);
            return ResponseEntity.ok("Background saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving background data");
        }
    }
}
