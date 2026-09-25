package com.artvista.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artvista.model.Admin;
import com.artvista.model.Artist;
import com.artvista.model.Customer;
import com.artvista.repository.AdminRepository;
import com.artvista.repository.ArtistRepository;
import com.artvista.repository.CustomerRepository;

@Service
public class AuthService {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private ArtistRepository artistRepo;

    @Autowired
    private CustomerRepository customerRepo;

    public Admin loginAdmin(String loginname, String password) {
        return adminRepo.findByAdminLoginNameAndAdminpassword(loginname, password);
    }

    public Artist loginArtist(String loginname, String password) {
        return artistRepo.findByArtistLoginNameAndArtistpassword(loginname, password);
    }

    public Customer loginCustomer(String loginname, String password) {
        return customerRepo.findByCustomerLoginNameAndCustomerpassword(loginname, password);
    }
}
