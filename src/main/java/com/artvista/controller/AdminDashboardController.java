/*package com.artvista.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.artvista.model.Art;
import com.artvista.service.AdminService;

@Controller
public class AdminDashboardController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {

        List<Art> pendingArts = adminService.getPendingArts();
        model.addAttribute("pendingArts", pendingArts);

        return "admin_dashboard"; // if using templates
        // OR return "redirect:/admin_dashboard.html"; if static
    }
}

*/