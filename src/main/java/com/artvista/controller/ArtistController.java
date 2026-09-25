package com.artvista.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.artvista.model.Art;
import com.artvista.model.Artist;
import com.artvista.model.OrderEntity;
import com.artvista.repository.ArtRepository;
import com.artvista.repository.ArtistRepository;
import com.artvista.service.ArtistService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/artist")
@CrossOrigin
public class ArtistController 
{

    private final ArtistRepository repo;

    public ArtistController(ArtistRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/{id}")
    public Artist getArtist(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow();
    }



    @Autowired
    private ArtRepository artRepository;

    @GetMapping("/my-arts/{artistId}")
    public List<Art> myArts(@PathVariable Integer artistId) {
        return artRepository.findByArtistId(artistId);
    }


@PostMapping("/upload-art")
public ResponseEntity<?> uploadArt(
        @RequestParam("artname") String artname,
        @RequestParam("price") Double price,
        @RequestParam("image") MultipartFile image,
        HttpSession session
) throws IOException {

    Artist artist = (Artist) session.getAttribute("artist");
    if (artist == null) {
        return ResponseEntity.status(401).body("Session expired");
    }

    String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
    String uploadDir = "uploads/";

    Files.createDirectories(Paths.get(uploadDir));
    Files.copy(image.getInputStream(), Paths.get(uploadDir + fileName));

    Art art = new Art();
    art.setArtname(artname);
    art.setPrice(price);
    art.setArtistId(artist.getArtistId());
    art.setImagepath(fileName);
    art.setVerified(false);

    artRepository.save(art);

    return ResponseEntity.ok("Artwork uploaded successfully");
}

@Autowired
//private OrderRepository orderRepository;

    // ===== ORDER APIs =====

    @GetMapping("/api/arts")
public List<Art> verifiedArts() {
    return artRepository.findByVerified(true);
}

 @Autowired
    private ArtistService artistService;
   @GetMapping("/orders")
public List<OrderEntity> artistOrders(HttpSession session) {
    Artist artist = (Artist) session.getAttribute("artist");

    if (artist == null) {
        return List.of();
    }

    return artistService.getOrdersToComplete();
}



  /*  @GetMapping("/orders-to-complete")
public List<OrderEntity> ordersToComplete(HttpSession session) {

    Artist artist = (Artist) session.getAttribute("artist");
    if (artist == null) {
        return List.of();
    }

    return orderRepository.findByStatus("ADMIN_VERIFIED");
}

@PostMapping("/complete-order/{orderId}")
public void completeOrder(@PathVariable Integer orderId) {
    OrderEntity order = orderRepository.findById(orderId).orElse(null);
    if (order != null) {
        order.setStatus("COMPLETED");
        orderRepository.save(order);
    }
}

@GetMapping("/orders")
public List<OrderEntity> artistOrders() {
    return artistService.getOrdersToComplete();
}
*/
@PutMapping("/orders/{id}/complete")
public void complete(@PathVariable Integer id) {
    artistService.completeOrder(id);
}



@GetMapping("/my-arts")
public List<Art> myArts(HttpSession session){
    Artist artist = (Artist) session.getAttribute("artist");
    return artRepository.findByArtistId(artist.getArtistId());
}


@DeleteMapping("/art/{id}")
public void deleteArt(@PathVariable Integer id){
    artRepository.deleteById(id);
}


@PutMapping("/art/{id}")
public void updateArt(@PathVariable Integer id,
                      @RequestBody Art updated){
    Art art = artRepository.findById(id).orElseThrow();
    art.setArtname(updated.getArtname());
    art.setPrice(updated.getPrice());
    art.setVerified(false);
    artRepository.save(art);
}

}
