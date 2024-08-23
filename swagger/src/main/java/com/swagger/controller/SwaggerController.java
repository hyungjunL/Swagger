package com.swagger.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.dto.BasicResponseDto;
import com.swagger.dto.MemberJoinRequestDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Example", description = "Example API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/example")
public class SwaggerController {

	@PostMapping
	@Operation(summary = "Example API Summary", description = "Swagger test")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(schema = @Schema(implementation = BasicResponseDto.class)) }),
			@ApiResponse(responseCode = "404", description = "Not Found") })
	public ResponseEntity<BasicResponseDto> exampleAPI(@RequestBody @Valid MemberJoinRequestDto memberJoinRequestDto) {
		String s = String.format("Request Email : %s", memberJoinRequestDto.getUserEmail());
		BasicResponseDto response = new BasicResponseDto();
		response.setCode(200);
		response.setMessage("success");
		response.setData(s);
		return ResponseEntity.ok(response);
	}
}
