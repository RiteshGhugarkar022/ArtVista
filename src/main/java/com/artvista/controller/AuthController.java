package com.artvista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artvista.model.Admin;
import com.artvista.model.Artist;
import com.artvista.model.Customer;
import com.artvista.repository.AdminRepository;
import com.artvista.repository.ArtistRepository;
import com.artvista.repository.CustomerRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private ArtistRepository artistRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @PostMapping("/doLogin")
    public String login(
            @RequestParam String role,
            @RequestParam String loginname,
            @RequestParam String password,
            HttpSession session
    ) {

        System.out.println("==== LOGIN HIT ====");
        System.out.println("role = " + role);
        System.out.println("loginname = " + loginname);
        System.out.println("password = " + password);

        if ("admin".equals(role)) {
            Admin admin = adminRepo
                    .findByAdminLoginNameAndAdminpassword(loginname, password);

            if (admin != null) {
                session.setAttribute("admin",admin);
                return "redirect:/admin_dashboard.html";
            }
        }

        if ("artist".equals(role)) {
            Artist artist = artistRepo
                    .findByArtistLoginNameAndArtistpassword(loginname, password);

            if (artist != null) {
                session.setAttribute("artist",artist);
                
                return "redirect:/artist_dashboard.html";
            }
        }

        if ("customer".equals(role)) {
            Customer customer = customerRepo
                    .findByCustomerLoginNameAndCustomerpassword(loginname, password);

            if (customer != null) {
                session.setAttribute("customer",customer);
                return "redirect:/customer_dashboard.html";
            }
        }

        return "redirect:/login.html?error=invalid";
    }
}
