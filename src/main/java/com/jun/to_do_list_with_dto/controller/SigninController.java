package com.jun.to_do_list_with_dto.controller;

import com.jun.to_do_list_with_dto.dto.SigninDto;
import com.jun.to_do_list_with_dto.model.User;
import com.jun.to_do_list_with_dto.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SigninController {
    private final UserRepository userRepository;

    @GetMapping({"/", "/signin"})
    public String showLogin(Model model) {
        model.addAttribute("signinDto", new SigninDto());

        return "signin";
    }

    @PostMapping("/signin")
    public String doSignin(
            @Valid @ModelAttribute SigninDto signinDto,
            BindingResult bindingResult,
            HttpSession httpSession,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "signin";
        }
        try {
            User user = userRepository.findByUsername(signinDto.getUsername());

            if (!user.getPassword().equals(signinDto.getPassword())) {
                model.addAttribute("error", "Your Password is incorrect");

                return "signin";
            }
            httpSession.setAttribute("user", user);

            return "redirect:/todos";
        } catch (Exception e) {
            model.addAttribute("error", "Invalid User");

            return "signin";
        }

    }

    @GetMapping("/signout")
    public String signout(HttpSession session){
        session.invalidate();

        return "redirect:/signin";
    }
}
