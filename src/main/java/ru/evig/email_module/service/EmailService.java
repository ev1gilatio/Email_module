package ru.evig.email_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.evig.email_module.data.EmailDetails;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String from;

    public String sendEmail(EmailDetails details) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(from);
            message.setTo(details.getTo());
            message.setSubject(details.getSubject());
            message.setText(details.getText());

            sender.send(message);

            return "STATUS OK.";
        } catch (Exception e) {
            return "STATUS FAILED.";
        }
    }
}
