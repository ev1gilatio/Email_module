package ru.evig.email_module.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.evig.email_module.data.EmailDetails;
import ru.evig.email_module.service.EmailService;

@RestController
@RequestMapping("/api/v1/evigEmail")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService service;

    @GetMapping
    public String emptyPage() {
        return "This page is empty...";
    }

    @PostMapping("/sendInfo")
    public String
    sendMail(@RequestBody EmailDetails details)
    {
        return service.sendEmail(details);
    }
}