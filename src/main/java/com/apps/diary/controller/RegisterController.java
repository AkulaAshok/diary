package main.java.com.apps.diary.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import main.java.com.apps.diary.entity.UserEntity;
import main.java.com.apps.diary.service.EmailService;
import main.java.com.apps.diary.service.UserService;

@Controller
public class RegisterController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    EmailService emailService;

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute("user") UserEntity userEntity, Model model) {
        Optional<UserEntity> user = userService.getUserByEmail(userEntity.getEmail());

        if (user.isPresent()) {
            model.addAttribute("errorMsg", "Email Already Registered");
            return "register";
        }

        Boolean status = userService.insertUser(userEntity);

        if (status) {
            // Send registration email
            emailService.sendRegistrationEmail(userEntity.getEmail(), userEntity.getName());
            model.addAttribute("msg", "User Added Successfully");
            return "success";
        }

        model.addAttribute("msg", "User adding failed, try later...");
        return "failure";
    }
}
