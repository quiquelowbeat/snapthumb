package com.snapthumb.thumbnailgenerator.presigner.infrastructure.inbound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.snapthumb.thumbnailgenerator.presigner.application.UrlPresigner;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/presigned-urls")
@Tag(name = "S3 Presigned URLs", description = "Generate presigned URLs for S3 file uploads")
public class PresignedUrlController {

    private final UrlPresigner urlPresigner;

    public PresignedUrlController(UrlPresigner urlPresigner) {
        this.urlPresigner = urlPresigner;
    }

    @GetMapping
    public ResponseEntity<String> generatePresignedUrl(@RequestParam String fileType) {
        try {
            String presignedUrl = urlPresigner.presign(fileType);
            return ResponseEntity.ok(presignedUrl);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating presigned url");
        }
    }
}
