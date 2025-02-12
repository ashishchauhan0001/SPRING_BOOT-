package app.vercel.ashishchauhan.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    // this will act as the health check for the application
    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }
}
