package com.artvista.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artvista.model.Art;

public interface ArtRepository extends JpaRepository<Art, Integer> {

    List<Art> findByVerified(Boolean verified);

    List<Art> findByArtistId(Integer artistId);
}
