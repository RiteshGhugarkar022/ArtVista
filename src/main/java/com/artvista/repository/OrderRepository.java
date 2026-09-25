package com.artvista.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artvista.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    // Orders of a customer
    List<OrderEntity> findByCustomerId(Integer customerId);

    // Orders by status (admin / artist)
    List<OrderEntity> findByStatus(String status);

    // Orders of a specific artwork
    List<OrderEntity> findByArtid(Integer artid);
}
