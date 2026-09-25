package com.artvista.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "\"adminId\"")
    private Integer adminId;

    @Column(name = "\"adminName\"")
    private String adminName;

    @Column(name = "\"adminLoginName\"")
    private String adminLoginName;

    @Column(name = "\"adminemail\"")
    private String adminemail;

    @Column(name = "\"adminpassword\"")
    private String adminpassword;

    @Column(name = "\"adminphone\"")
    private String adminphone;

    @Column(name = "\"adminaddress\"")
    private String adminaddress;

    @Column(name = "\"admingender\"")
    private String admingender;

    // getters & setters



    public Admin() {}

    public Integer getAdminId() { return adminId; }
    public void setAdminId(Integer adminId) { this.adminId = adminId; }

    public String getAdminName() { return adminName; }
    public void setAdminName(String adminName) { this.adminName = adminName; }

    public String getAdminLoginName() { return adminLoginName; }
    public void setAdminLoginName(String adminLoginName) { this.adminLoginName = adminLoginName; }

    public String getAdminemail() { return adminemail; }
    public void setAdminemail(String adminemail) { this.adminemail = adminemail; }

    public String getAdminpassword() { return adminpassword; }
    public void setAdminpassword(String adminpassword) { this.adminpassword = adminpassword; }

    public String getAdminphone() { return adminphone; }
    public void setAdminphone(String adminphone) { this.adminphone = adminphone; }

    public String getAdminaddress() { return adminaddress; }
    public void setAdminaddress(String adminaddress) { this.adminaddress = adminaddress; }

    public String getAdmingender() { return admingender; }
    public void setAdmingender(String admingender) { this.admingender = admingender; }
}
