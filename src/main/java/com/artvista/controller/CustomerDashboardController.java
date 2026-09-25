package com.artvista.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerDashboardController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "customer_dashboard.html";
    }

    
}
