package com.artvista.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "art")
public class Art {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer artid;

    private String artname;
    private Double price;
    private Integer artistId;
    private Boolean verified=false;
    private String imagepath;
    

    public Art() {}

    public Integer getArtid() { return artid; }
    public void setArtid(Integer artid) { this.artid = artid; }

    public String getArtname() { return artname; }
    public void setArtname(String artname) { this.artname = artname; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getArtistId() { return artistId; }
    public void setArtistId(Integer artistId) { this.artistId = artistId; }

    public Boolean getVerified() { return verified; }
    public void setVerified(Boolean verified) { this.verified = verified; }

    public String getImagepath() { return imagepath; }
    public void setImagepath(String imagepath) { this.imagepath = imagepath; }
}
