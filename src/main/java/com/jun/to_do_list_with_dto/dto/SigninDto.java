package com.jun.to_do_list_with_dto.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class SigninDto {
    @NotBlank(message = "Input ID")
    private String username;

    @NotBlank(message = "Input Password")
    private String password;
}
