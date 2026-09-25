package com.artvista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.artvista.model.Admin;
import com.artvista.model.Artist;
import com.artvista.model.Customer;
import com.artvista.repository.AdminRepository;
import com.artvista.repository.ArtistRepository;
import com.artvista.repository.CustomerRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private ArtistRepository artistRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @PostMapping("/register")
    public String register(HttpServletRequest request) {

        String role = request.getParameter("role");

        try {
            if ("admin".equals(role)) {

                Admin admin = new Admin();
                admin.setAdminName(request.getParameter("adminName"));
                admin.setAdminLoginName(request.getParameter("adminLoginName"));
                admin.setAdminemail(request.getParameter("adminemail"));
                admin.setAdminpassword(request.getParameter("adminpassword"));
                admin.setAdminphone(request.getParameter("adminphone"));
                admin.setAdminaddress(request.getParameter("adminaddress"));
                admin.setAdmingender(request.getParameter("admingender"));

                adminRepo.save(admin);
            }

            else if ("artist".equals(role)) {

                Artist artist = new Artist();
                artist.setArtistName(request.getParameter("artistName"));
                artist.setArtistLoginName(request.getParameter("artistLoginName"));
                artist.setArtistemail(request.getParameter("artistemail"));
                artist.setArtistpassword(request.getParameter("artistpassword"));
                artist.setArtistphone(request.getParameter("artistphone"));
                artist.setArtistaddress(request.getParameter("artistaddress"));
                artist.setArtistgender(request.getParameter("artistgender"));

                artistRepo.save(artist);
            }

            else if ("customer".equals(role)) {

                Customer customer = new Customer();
                customer.setCustomerName(request.getParameter("customerName"));
                customer.setCustomerLoginName(request.getParameter("customerLoginName"));
                customer.setCustomeremail(request.getParameter("customeremail"));
                customer.setCustomerpassword(request.getParameter("customerpassword"));
                customer.setCustomerphone(request.getParameter("customerphone"));
                customer.setCustomeraddress(request.getParameter("customeraddress"));
                customer.setCustomergender(request.getParameter("customergender"));

                customerRepo.save(customer);
            }

            return "redirect:/login.html";

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/register.html?error=unknown";
        }
    }
}
