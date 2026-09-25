package com.artvista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.artvista.model.Art;
import com.artvista.model.Artist;
import com.artvista.repository.ArtRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/artist")
public class ArtistDashboardController {

    @Autowired
    private ArtRepository artRepository;

    @PostMapping("/upload-art")
    public String uploadArt(@RequestParam String artname,
                            @RequestParam Double price,
                            @RequestParam("image") MultipartFile image,
                            HttpSession session) {

        Artist artist = (Artist) session.getAttribute("artist");

        if (artist == null) {
            return "redirect:/login.html";
        }

        Art art = new Art();
        art.setArtname(artname);
        art.setPrice(price);
        art.setArtistId(artist.getArtistId());
        art.setVerified(false);
        art.setImagepath(image.getOriginalFilename());

        artRepository.save(art);

        return "redirect:/artist_dashboard.html";
    }
}
