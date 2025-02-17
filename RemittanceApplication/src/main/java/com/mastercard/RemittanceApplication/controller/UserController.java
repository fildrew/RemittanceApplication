package com.mastercard.RemittanceApplication.controller;

import com.mastercard.RemittanceApplication.dto.UserDTO;
import com.mastercard.RemittanceApplication.model.User;
import com.mastercard.RemittanceApplication.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/registration")
    public String getRegistrationPage()
    {
        return "register";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute UserDTO userDTO, Model model)
    {
        userService.saveUser(userDTO);
        model.addAttribute("message","Registered Successfully..!!");
        return "register";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @GetMapping("/user-page")
    public String getUserPage(Model model, Principal principal)
    {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "user";
    }

    @GetMapping("/admin-page")
    public String getAdminPage(Model model, Principal principal)
    {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "admin";
    }

    @GetMapping("/profile")
    public String showProfile(Model model, Authentication authentication)
    {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findByUsername(userDetails.getUsername());
        model.addAttribute("user",user);
        return "profile";
    }

}
