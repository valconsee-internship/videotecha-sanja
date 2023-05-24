package com.project.videotecha.service.impl;

import com.project.videotecha.dto.EmailDetailDto;
import com.project.videotecha.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(EmailDetailDto detail) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(detail.getUserEmail());
        helper.setText(String.format("Your reservation for the projection of Movie: %s starting at %s has been cancelled because the projection is cancelled",
                detail.getMovieName(), detail.getMovieStartTime()));

        javaMailSender.send(message);
    }

}
