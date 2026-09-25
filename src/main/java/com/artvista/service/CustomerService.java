package com.artvista.service;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artvista.model.Art;
import com.artvista.model.OrderEntity;
import com.artvista.repository.ArtRepository;
import com.artvista.repository.OrderRepository;

@Service
public class CustomerService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ArtRepository artRepository;


    public OrderEntity placeOrder(OrderEntity order) {
        
        
        Art art = artRepository.findById(order.getArtid())
                .orElseThrow();

        order.setOrderdate(LocalDate.now());
        order.setStatus("PENDING_ADMIN");
    

        return orderRepository.save(order);
    }

    public List<OrderEntity> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    public OrderEntity updateStatus(Integer id, String status) {
        OrderEntity o = orderRepository.findById(id).orElseThrow();
        o.setStatus(status);
        return orderRepository.save(o);
    }
}


/* 
@Service
public class CustomerService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ArtRepository artRepository;

    // ===== PLACE ORDER + PAYMENT =====

    public void placeOrder(Integer customerId, Integer artid, String paymentMode) {

        // 1️⃣ Create order
        OrderEntity order = new OrderEntity();
        order.setCustomerId(customerId);
        order.setArtid(artid);
        order.setOrderdate(LocalDate.now());
        order.setStatus("ADMIN_PENDING");
        orderRepository.save(order);

        // 2️⃣ Fetch art price
        Art art = artRepository.findById(artid).orElse(null);
        if (art == null) return;

        // 3️⃣ Create payment (dummy)
        Payment payment = new Payment();
        payment.setOrderid(order.getOrderid());
        payment.setCustomerId(customerId);
        payment.setAmount(art.getPrice());
        payment.setPaymentmode(paymentMode); // CARD / UPI
        payment.setPaymentstatus("SUCCESS");
        paymentRepository.save(payment);
    }

    // ===== ORDER HISTORY =====

    public List<OrderEntity> getMyOrders(Integer customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
}*/
