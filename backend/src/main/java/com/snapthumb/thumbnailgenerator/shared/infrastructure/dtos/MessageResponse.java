package com.snapthumb.thumbnailgenerator.shared.infrastructure.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;

@Schema(description = "Response object containing a message")
public record MessageResponse(
        @Schema(description = "Message text", example = "Operation completed successfully") @JsonProperty("message") String message) {

}
