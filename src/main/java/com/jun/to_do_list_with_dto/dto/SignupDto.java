package com.jun.to_do_list_with_dto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class SignupDto {
    @NotBlank(message = "Input Id")
    @Size(min=3, max=10, message = "ID supposed to contain 3~10 letters")
    private String username;

    @NotBlank(message = "Input Password")
    @Size(min=6, max=20, message = "Password supposed to contain 6~20 characters")
    private String password;


}
