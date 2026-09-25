package com.artvista.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentid;

    private Integer orderid;
    private Integer customerId;
    private Double amount;
    private String paymentmode;
    private String paymentstatus;

    public Payment() {}

    public Integer getPaymentid() { return paymentid; }
    public void setPaymentid(Integer paymentid) { this.paymentid = paymentid; }

    public Integer getOrderid() { return orderid; }
    public void setOrderid(Integer orderid) { this.orderid = orderid; }

    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getPaymentmode() { return paymentmode; }
    public void setPaymentmode(String paymentmode) { this.paymentmode = paymentmode; }

    public String getPaymentstatus() { return paymentstatus; }
    public void setPaymentstatus(String paymentstatus) { this.paymentstatus = paymentstatus; }
}
