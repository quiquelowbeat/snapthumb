package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.inbound;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snapthumb.thumbnailgenerator.image_creation.background.application.BackgroundRegister;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackgroundRequest;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.Background;

@RestController
@RequestMapping("/v1/ai-backgrounds")
public class AIBackgroundController {

    private final BackgroundRegister backgroundRegister;

    public AIBackgroundController(BackgroundRegister backgroundRegister) {
        this.backgroundRegister = backgroundRegister;
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<String> saveAIBackground(@PathVariable String uuid,
            @RequestBody AIBackgroundRequest request) {
        try {
            Background background = new AIBackground(UUID.fromString(uuid), request.url(),
                    request.prompt(), request.title(), request.description());
            backgroundRegister.save(background);
            return ResponseEntity.ok("AI generated background saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving AI generated background data");
        }
    }
}
