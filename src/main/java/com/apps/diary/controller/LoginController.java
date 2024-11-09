package main.java.com.apps.diary.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.com.apps.diary.entity.TaskEntity;
import main.java.com.apps.diary.entity.UserEntity;
import main.java.com.apps.diary.service.TaskService;
import main.java.com.apps.diary.service.UserService;
import main.java.com.apps.diary.service.OTPService; // New OTPService for OTP generation and sending

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private TaskService taskService;

    @Autowired
    private OTPService otpService; // Service for sending OTP
    
    @Autowired
    private HttpSession session;

    @GetMapping("/")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/")
    public String postLogin(@ModelAttribute("user") UserEntity user, Model model) {
        Optional<UserEntity> existingUser = userService.getUserByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            Long userId = (long) existingUser.get().getId();
            session.setAttribute("user", existingUser.get());

            // Generate and send OTP
            String otp = otpService.generateOTP(); // Generate OTP
            session.setAttribute("otp", otp); // Store OTP in session
            otpService.sendOTP(existingUser.get().getEmail(), otp); // Send OTP to user's email

            return "otp-verification"; // Redirect to OTP verification page
        }

        model.addAttribute("errorMsg", "Invalid email or password. Please try again.");
        return "login";
    }

    @PostMapping("/verify-otp")
    public String verifyOTP(@RequestParam("otp") String enteredOtp, Model model) {
        String sessionOtp = (String) session.getAttribute("otp");
        UserEntity user = (UserEntity) session.getAttribute("user");
        
        int id=user.getId();

        if (sessionOtp != null && sessionOtp.equals(enteredOtp)) {
            session.removeAttribute("otp"); // Clear OTP from session

            // Fetch tasks for the user
            List<TaskEntity> tasks = taskService.getTasksByUserId(user.getId());
            model.addAttribute("tasks", tasks);

            return "dashboard"; // Redirect to dashboard
        } else {
            model.addAttribute("errorMsg", "Incorrect OTP. Please try again.");
            return "otp-verification"; // Redirect back to OTP verification page
        }
    }
}
