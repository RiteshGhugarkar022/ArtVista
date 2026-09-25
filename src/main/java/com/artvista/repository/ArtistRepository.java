package com.artvista.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artvista.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {

    Artist findByArtistLoginNameAndArtistpassword(
    String artistLoginName,
    String artistpassword
);

}
