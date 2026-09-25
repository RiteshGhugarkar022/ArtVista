package com.artvista.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artvista.model.Art;
import com.artvista.model.OrderEntity;
import com.artvista.repository.ArtRepository;
import com.artvista.repository.OrderRepository;

@Service
public class ArtistService {

    @Autowired
    private ArtRepository artRepository;

    @Autowired
    private OrderRepository orderRepository;

    // ===== ART CRUD =====

    public void uploadArt(Art art) {
        art.setVerified(false); // admin must verify
        artRepository.save(art);
    }
    
    public List<Art> getMyArts(Integer artistId) {
        return artRepository.findByArtistId(artistId);
    }

    public void deleteArt(Integer artid) {
        artRepository.deleteById(artid);
    }

    public void updateArt(Integer artid, String artname, Double price) {
        Art art = artRepository.findById(artid).orElse(null);
        if (art != null) {
            art.setArtname(artname);
            art.setPrice(price);
            art.setVerified(false); // re-verification needed
            artRepository.save(art);
      
         }
    }

    // ===== ORDER HANDLING =====

   /* public List<OrderEntity> getOrdersToComplete() {
        return orderRepository.findByStatus("ADMIN_VERIFIED");
    }

    public void completeOrder(Integer orderid) {
        OrderEntity order = orderRepository.findById(orderid).orElse(null);
        if (order != null) {
            order.setStatus("ARTIST_COMPLETED");
            orderRepository.save(order);
        }
    }*/
    public List<OrderEntity> getOrdersToComplete() {
    return orderRepository.findByStatus("ADMIN_VERIFIED");
}

public void completeOrder(Integer id) {
    OrderEntity o = orderRepository.findById(id).orElseThrow();
    o.setStatus("ARTIST_COMPLETED");
    orderRepository.save(o);
}

}
