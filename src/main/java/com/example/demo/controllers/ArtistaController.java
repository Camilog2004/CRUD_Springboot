package com.example.demo.controllers;

import com.example.demo.models.Artista;
import com.example.demo.repositories.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArtistaController {
    @Autowired

    private ArtistaRepository artistaRepository;

    @GetMapping("/artista")
    public List<Artista> artista(){
        return artistaRepository.findAll();
    }

    @PostMapping("/artista")
    public void createArtista(@RequestBody Artista artista){
        artistaRepository.save(artista);
    }

    @PutMapping("/artista")
    public void updateArtista(@RequestBody Artista artista){
        Optional<Artista> artistaOptional = artistaRepository.findById(artista.getId());
        if(artistaOptional.isPresent()){
            artistaRepository.save(artista);
        }
    }

    @DeleteMapping("/artista")
    public void deleteArtista(@RequestParam(value = "id")Long id){
        artistaRepository.deleteById(id);
    }

}
