package com.artvista.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artvista.model.Payment;
import com.artvista.repository.PaymentRepository;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentRepository repo;
    public PaymentController(PaymentRepository repo){ this.repo = repo; }

    @GetMapping
    public List<Payment> all(){ return repo.findAll(); }

    @PostMapping
    public Payment create(@RequestBody Payment p){ return repo.save(p); }
}
