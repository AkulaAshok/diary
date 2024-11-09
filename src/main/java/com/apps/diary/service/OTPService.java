package main.java.com.apps.diary.service;

import org.springframework.stereotype.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class OTPService {
    
    private final JavaMailSender mailSender;

    public OTPService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public String generateOTP() {
        // Simple OTP generation logic (6-digit)
        int otp = (int) (Math.random() * 900000) + 100000;
        return String.valueOf(otp);
    }

    public void sendOTP(String email, String otp) {
        // Sending OTP via email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your OTP Code");
        message.setText("Your OTP code is: " + otp);
        mailSender.send(message);
    }
}
