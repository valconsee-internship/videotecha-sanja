package com.project.videotecha.service;

import com.project.videotecha.dto.EmailDetailDto;
import jakarta.mail.MessagingException;

public interface EmailService {

    public void sendEmail(EmailDetailDto emailDetailDto) throws MessagingException;

}
