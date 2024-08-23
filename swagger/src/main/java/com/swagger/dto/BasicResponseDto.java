package com.swagger.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BasicResponseDto {

	@Schema(description = "응답 코드", example = "200")
	private int code;

	@Schema(description = "응답 메시지", example = "Success")
	private String message;

	@Schema(description = "응답 데이터", example = "Any Data")
	private Object data;
}
