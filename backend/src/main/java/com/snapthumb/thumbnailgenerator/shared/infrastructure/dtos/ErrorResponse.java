package com.snapthumb.thumbnailgenerator.shared.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response object containing an error message")
public record ErrorResponse(
        @Schema(description = "Error message text", example = "Invalid input provided") @JsonProperty("error") String error) {

}
