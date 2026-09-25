package com.artvista.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artvista.model.Art;
import com.artvista.model.Customer;
import com.artvista.model.OrderEntity;
import com.artvista.repository.ArtRepository;
import com.artvista.repository.CustomerRepository;
import com.artvista.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin
public class CustomerController{

    
    private final CustomerRepository customerrepo;

    public CustomerController(CustomerRepository customerrepo) {
        this.customerrepo = customerrepo;
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Integer id) {
        return customerrepo.findById(id).orElseThrow();
    }

    @Autowired
    private ArtRepository artRepository;
    @GetMapping("/api/arts")
public List<Art> verifiedArts() {
    return artRepository.findByVerified(true);
}


    @Autowired
    private CustomerService customerService;

    // ===== PLACE ORDER (after dummy payment) =====
   /*  @PostMapping("/place-order")
    public void placeOrder(@RequestBody Map<String, String> payload) {

        Integer customerId = Integer.parseInt(payload.get("customerId"));
        Integer artid = Integer.parseInt(payload.get("artid"));
        String paymentMode = payload.get("paymentmode");

        customerService.placeOrder();
    }*/

    // ===== CUSTOMER ORDER HISTORY =====
    @GetMapping("/orders/{customerId}")
    public List<OrderEntity> getOrdersByStatus(@PathVariable Integer customerId) {
        return customerService.getOrdersByStatus("ADMIN_VERIFIED");
    }
}
