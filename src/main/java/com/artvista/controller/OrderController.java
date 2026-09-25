package com.artvista.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artvista.model.OrderEntity;
import com.artvista.service.CustomerService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final CustomerService customerService;

    public OrderController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // CUSTOMER places order
    @PostMapping("/place")
    public OrderEntity placeOrder(@RequestBody OrderEntity order) {
        System.out.println("==== CREATE ORDER HIT ====");
        return customerService.placeOrder(order);
    }

    // ADMIN sees pending orders
    @GetMapping("/pending-admin")
    public List<OrderEntity> adminOrders() {
        return customerService.getOrdersByStatus("PENDING_ADMIN");
    }

    // ADMIN verifies
    @PutMapping("/{id}/verify")
    public OrderEntity verify(@PathVariable Integer id) {
        return customerService.updateStatus(id, "ADMIN_VERIFIED");
    }

    // ARTIST sees verified
    @GetMapping("/artist")
    public List<OrderEntity> artistOrders() {
        return customerService.getOrdersByStatus("ADMIN_VERIFIED");
    }
}

/* 
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository repo;

    public OrderController(OrderRepository repo) {
        this.repo = repo;
    }

    // ✅ CUSTOMER PLACES ORDER
    @PostMapping("/place")
    public OrderEntity placeOrder(@RequestBody OrderEntity order) {

    System.out.println("==== ORDER CREATE HIT ====");
    System.out.println("artid = " + order.getArtid());
    System.out.println("customerId = " + order.getCustomerId());

        order.setOrderdate(LocalDate.now());
        order.setStatus("PENDING_ADMIN");
        return repo.save(order); // MUST return saved order
    }

    // ✅ ADMIN – VIEW PENDING ORDERS
    @GetMapping("/pending-admin")
    public List<OrderEntity> adminPendingOrders() {
        return repo.findByStatus("PENDING_ADMIN");
    }

    // ✅ ADMIN – VERIFY
    @PutMapping("/{id}/verify")
    public OrderEntity verify(@PathVariable Integer id) {
        OrderEntity o = repo.findById(id).orElseThrow();
        o.setStatus("ADMIN_VERIFIED");
        return repo.save(o);
    }

    // ✅ ADMIN – REJECT
    @PutMapping("/{id}/reject")
    public OrderEntity reject(@PathVariable Integer id) {
        OrderEntity o = repo.findById(id).orElseThrow();
        o.setStatus("REJECTED");
        return repo.save(o);
    }

    // ✅ ARTIST – VIEW VERIFIED ORDERS
    @GetMapping("/artist")
    public List<OrderEntity> artistOrders() {
        return repo.findByStatus("ADMIN_VERIFIED");
    }

    // ✅ ARTIST – COMPLETE ORDER
    @PutMapping("/{id}/complete")
    public OrderEntity complete(@PathVariable Integer id) {
        OrderEntity o = repo.findById(id).orElseThrow();
        o.setStatus("ARTIST_COMPLETED");
        return repo.save(o);
    }

    // ✅ CUSTOMER – VIEW OWN ORDERS
    @GetMapping("/customer/{customerId}")
    public List<OrderEntity> customerOrders(@PathVariable Integer customerId) {
        return repo.findByCustomerId(customerId);
    }
}

*/

 /* 
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/{artid}")
    public OrderEntity placeOrder(
            @PathVariable Integer artid,
            HttpSession session) {

        Customer customer = (Customer) session.getAttribute("customer");

        OrderEntity order = new OrderEntity();
        order.setArtid(artid);
        order.setCustomerId(customer.getCustomerId());
        order.setOrderdate(LocalDate.now());
        order.setStatus("PENDING");

        return orderRepository.save(order);
    }

    @PutMapping("/{id}/verify")
    public void adminVerify(@PathVariable Integer id) {
        OrderEntity o = orderRepository.findById(id).orElseThrow();
        o.setStatus("ADMIN_VERIFIED");
        orderRepository.save(o);
    }
} */



