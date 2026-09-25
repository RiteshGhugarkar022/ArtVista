package com.artvista.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"customerId\"")
    private Integer customerId;
   
    @Column(name = "\"customerName\"")
    private String customerName;

    @Column(name = "\"customerLoginName\"")
    private String customerLoginName;

    @Column(name = "\"customeremail\"")
    private String customeremail;

    @Column(name = "\"customerpassword\"")
    private String customerpassword;

    @Column(name = "\"customerphone\"")
    private String customerphone;

    @Column(name = "\"customeraddress\"")
    private String customeraddress;

    @Column(name = "\"customergender\"")
    private String customergender;

    public Customer() {}

    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerLoginName() { return customerLoginName; }
    public void setCustomerLoginName(String customerLoginName) { this.customerLoginName = customerLoginName; }

    public String getCustomeremail() { return customeremail; }
    public void setCustomeremail(String customeremail) { this.customeremail = customeremail; }

    public String getCustomerpassword() { return customerpassword; }
    public void setCustomerpassword(String customerpassword) { this.customerpassword = customerpassword; }

    public String getCustomerphone() { return customerphone; }
    public void setCustomerphone(String customerphone) { this.customerphone = customerphone; }

    public String getCustomeraddress() { return customeraddress; }
    public void setCustomeraddress(String customeraddress) { this.customeraddress = customeraddress; }

    public String getCustomergender() { return customergender; }
    public void setCustomergender(String customergender) { this.customergender = customergender; }
}
