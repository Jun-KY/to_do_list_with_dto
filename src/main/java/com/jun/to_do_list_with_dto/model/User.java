package com.jun.to_do_list_with_dto.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
}
