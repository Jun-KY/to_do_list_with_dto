package com.jun.to_do_list_with_dto.controller;

import com.jun.to_do_list_with_dto.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller@RequiredArgsConstructor
public class SignupController {
    private final UserRepository userRepository;

    @GetMapping("/signup")
    public String showSignup(Model model){
        model.addAttribute("signupDto");

        return "signup";
    }

}
