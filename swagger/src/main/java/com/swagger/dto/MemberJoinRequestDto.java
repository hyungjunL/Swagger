package com.swagger.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(title = "MEM_REQ_01 : 회원가입 요청 DTO")
public class MemberJoinRequestDto {

    @NotBlank(message = "사용자 이메일을 입력해주세요.")
    @Email(message = "이메일 형식에 맞지 않습니다.")
    @Schema(description = "사용자 이메일", example = "testtest@gmail.com")
    @JsonProperty("user_email")
    private String userEmail;

    @NotBlank(message = "사용자 이름을 입력해주세요.")
    @Size(min = 3, max = 15, message = "사용자 이름은 3글자 이상, 15글자 이하로 입력해야 합니다.")
    @Schema(description = "사용자 이름", example = "John Doe")
    @JsonProperty("user_name")
    private String userName;

    @NotBlank
    @Schema(description = "비밀번호", example = "test123!")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}", message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    @JsonProperty("user_password")
    private String userPassword;
}
