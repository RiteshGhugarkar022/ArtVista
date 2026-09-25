package com.artvista.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "\"artistId\"")
    private Integer artistId;

    @Column(name = "\"artistName\"")
    private String artistName;

    @Column(name = "\"artistLoginName\"")
    private String artistLoginName;

    @Column(name = "\"artistemail\"")
    private String artistemail;

    @Column(name = "\"artistpassword\"")
    private String artistpassword;

    @Column(name = "\"artistphone\"")
    private String artistphone;

    @Column(name = "\"artistaddress\"")
    private String artistaddress;

    @Column(name = "\"artistgender\"")
    private String artistgender;



    public Artist() {}

    public Integer getArtistId() { return artistId; }
    public void setArtistId(Integer artistId) { this.artistId = artistId; }

    public String getArtistName() { return artistName; }
    public void setArtistName(String artistName) { this.artistName = artistName; }

    public String getArtistLoginName() { return artistLoginName; }
    public void setArtistLoginName(String artistLoginName) { this.artistLoginName = artistLoginName; }

    public String getArtistemail() { return artistemail; }
    public void setArtistemail(String artistemail) { this.artistemail = artistemail; }

    public String getArtistpassword() { return artistpassword; }
    public void setArtistpassword(String artistpassword) { this.artistpassword = artistpassword; }

    public String getArtistphone() { return artistphone; }
    public void setArtistphone(String artistphone) { this.artistphone = artistphone; }

    public String getArtistaddress() { return artistaddress; }
    public void setArtistaddress(String artistaddress) { this.artistaddress = artistaddress; }

    public String getArtistgender() { return artistgender; }
    public void setArtistgender(String artistgender) { this.artistgender = artistgender; }
}
