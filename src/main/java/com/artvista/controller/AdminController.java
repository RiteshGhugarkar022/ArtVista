package com.artvista.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artvista.model.Art;
import com.artvista.model.OrderEntity;
import com.artvista.repository.ArtRepository;
import com.artvista.repository.OrderRepository;
//import com.artvista.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

    //@Autowired
   // private AdminService adminService;

    // ===== ART APIs =====

    @Autowired
    private ArtRepository artRepo;

    @GetMapping("/pending-arts")
    public List<Art> pendingArts() {
        return artRepo.findByVerified(false);
    }

    @PostMapping("/verify-art/{id}")
    public void verifyArt(@PathVariable Integer id) {
        Art art = artRepo.findById(id).orElseThrow();
        art.setVerified(true);
        artRepo.save(art);
    }


@PostMapping("/reject-art/{id}")
public void rejectArt(@PathVariable Integer id) {
    artRepo.deleteById(id);
}


    // ===== ORDER APIs ====

    @PostMapping("/verify-order/{orderId}")
public void verifyOrder(@PathVariable Integer orderId) {
    OrderEntity order = orderRepository.findById(orderId).orElse(null);
    if (order != null) {
        order.setStatus("ADMIN_VERIFIED");
        orderRepository.save(order);
    }
}



    @Autowired
private OrderRepository orderRepository;

@GetMapping("/pending-orders")
public List<OrderEntity> pendingOrders() {
    return orderRepository.findByStatus("PENDING_ADMIN");
}

}
