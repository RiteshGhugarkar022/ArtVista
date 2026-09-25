package com.artvista.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.artvista.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

   Admin findByAdminLoginNameAndAdminpassword(
    String adminLoginName,
    String adminpassword
);
@Modifying
@Query("update Art a set a.verified = true where a.artid = :artid")
void verifyArt(@Param("artid") Integer artid);

}
