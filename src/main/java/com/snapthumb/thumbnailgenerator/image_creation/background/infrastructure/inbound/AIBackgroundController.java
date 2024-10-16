package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.inbound;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snapthumb.thumbnailgenerator.image_creation.background.application.AIBackgroundRegister;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackgroundRequest;

@RestController
@RequestMapping("/v1/ai-backgrounds")
public class AIBackgroundController {

    private final AIBackgroundRegister register;

    public AIBackgroundController(AIBackgroundRegister register) {
        this.register = register;
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<String> saveAIBackground(@PathVariable String uuid,
            @RequestBody AIBackgroundRequest request) {
        try {
            AIBackground background = new AIBackground(UUID.fromString(uuid), request.url(),
                    request.prompt(), request.title(), request.description());
            register.save(background);
            return ResponseEntity.status(HttpStatus.CREATED).body("AI generated background saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving AI generated background data");
        }
    }
}
