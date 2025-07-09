package com.jun.to_do_list_with_dto.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TodoDto {
    private Integer id;

    @NotBlank(message = "Enter the title")
    private String title;
    private boolean completed;
}
