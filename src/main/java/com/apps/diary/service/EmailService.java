package main.java.com.apps.diary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendRegistrationEmail(String toEmail, String userName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Registration Successful");
        message.setText(String.format("""
        	    Dear %s,

        	    Congratulations on successfully registering for the Digital Secured Diary!

        	    The Digital Secured Diary is designed to help you keep your notes organized and secure. Here are some of its key features:

        	    - **Secure Access**: Your diary is protected with top-notch security measures to ensure your notes are safe.
        	    - **Easy Note Management**: Effortlessly add, edit, and delete notes at any time, making it simple to keep your thoughts organized.
        	    - **Search Functionality**: Quickly find any note with our efficient search feature.
        	    - **User-Friendly Interface**: Navigate through your diary with ease, thanks to our intuitive design.
        	    - **Regular Backups**: Your notes are automatically backed up to prevent data loss.

        	    We are excited to have you onboard and look forward to helping you manage your thoughts and ideas more effectively.

        	    Best Regards,
        	    Your Team
        	    """, userName));
        mailSender.send(message);
    }
}
