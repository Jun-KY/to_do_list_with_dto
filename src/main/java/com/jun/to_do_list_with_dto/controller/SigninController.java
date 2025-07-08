package com.jun.to_do_list_with_dto.controller;

import com.jun.to_do_list_with_dto.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller @RequiredArgsConstructor
public class SigninController {
    private final UserRepository userRepository;

    @GetMapping({"/", "/signin"})
    public String showLogin(){
        return "signin";
    }
}
