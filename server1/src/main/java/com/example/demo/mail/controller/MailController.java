package com.example.demo.mail.controller;

import com.example.demo.mail.domain.MailDto;
import com.example.demo.mail.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @GetMapping("/mail")
    public String displayMail() {
        return "mail";
    }

    @PostMapping("/mail")
    public void sendMail(MailDto mailDto) {
        mailService.mailSend(mailDto);
    }
}
