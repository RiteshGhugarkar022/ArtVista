package com.artvista.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artvista.model.Art;
import com.artvista.model.OrderEntity;
import com.artvista.repository.ArtRepository;
import com.artvista.repository.OrderRepository;

@Service
public class AdminService {

    @Autowired
    private ArtRepository artRepository;

    @Autowired
    private OrderRepository orderRepository;

    // -------- ART VERIFICATION --------

    public List<Art> getPendingArts() {
    return artRepository.findByVerified(false);
}


    public void verifyArt(Integer artId) {
    Art art = artRepository.findById(artId).orElse(null);
    if (art != null) {
        art.setVerified(true);
        artRepository.save(art);
    }
}

    // -------- ORDER VERIFICATION --------

    public List<OrderEntity> getPendingOrders() {
        return orderRepository.findByStatus("PENDING");
    }

    public void verifyOrder(Integer orderId) {
        OrderEntity order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus("VERIFIED");
            orderRepository.save(order);
        }
    }
}
