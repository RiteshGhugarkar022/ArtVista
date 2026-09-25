package com.artvista.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.artvista.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByCustomerLoginNameAndCustomerpassword(
    String customerLoginName,
    String customerpassword
);


}
