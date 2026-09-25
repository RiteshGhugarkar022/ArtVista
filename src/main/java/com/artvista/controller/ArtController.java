package com.artvista.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artvista.model.Art;
import com.artvista.repository.ArtRepository;

@RestController
@RequestMapping("/api/arts")
public class ArtController {

    @Autowired
    private ArtRepository repo;


     @GetMapping("/verified-arts")
     public List<Art> verifiedArts() {
         return repo.findByVerified(true);
          }

    // Get arts by artist
    @GetMapping("/artist/{artistId}")
    public List<Art> getArtsByArtist(@PathVariable Integer artistId) {
        return repo.findByArtistId(artistId);
    }

    // Upload new art
  /*   @PostMapping("/add")
    public Art addArt(
            @RequestParam String artname,
            @RequestParam Double price,
            @RequestParam Integer artistId,
            @RequestParam(required = false) String imagepath
    ) {
        Art art = new Art();
        art.setArtname(artname);
        art.setPrice(price);
        art.setArtistId(artistId);
        art.setVerified(false);
        art.setImagepath(imagepath);

        return repo.save(art);
    }*/

    @DeleteMapping("/{id}")
public void delete(@PathVariable Integer id) {
    repo.deleteById(id);
}

@PutMapping("/{id}")
public Art update(@PathVariable Integer id, @RequestBody Art art) {
    Art a = repo.findById(id).orElseThrow();
    a.setArtname(art.getArtname());
    a.setPrice(art.getPrice());
    a.setVerified(false);
    return repo.save(a);
}

/* 
@GetMapping("/api/art/{id}")
public Art getArt(@PathVariable Integer id) {
    return repo.findById(id).orElseThrow();
}*/

@GetMapping("/{id}")
public Art getArt(@PathVariable Integer id) {
    return repo.findById(id).orElseThrow();
}


}
