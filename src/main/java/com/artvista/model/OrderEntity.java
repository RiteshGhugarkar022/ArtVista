package com.artvista.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderentity")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderid;

    private Integer customerId;
    private Integer artid;
    private LocalDate orderdate;
    private String status;

    public OrderEntity() {}

    public Integer getOrderid() { return orderid; }
    public void setOrderid(Integer orderid) { this.orderid = orderid; }

    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public Integer getArtid() { return artid; }
    public void setArtid(Integer artid) { this.artid = artid; }

    public LocalDate getOrderdate() { return orderdate; }
    public void setOrderdate(LocalDate orderdate) { this.orderdate = orderdate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
