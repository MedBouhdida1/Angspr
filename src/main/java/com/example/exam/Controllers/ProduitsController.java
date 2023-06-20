package com.example.exam.Controllers;


import com.example.exam.Models.Produits;
import com.example.exam.Repositories.ProduitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produits")
public class ProduitsController {

    @Autowired
    private ProduitsRepository produitsRepository;






    @PostMapping
    public Produits addProducts(@RequestBody Produits produits){

        return produitsRepository.save(produits);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") String id){
        produitsRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") String id, @RequestBody Produits produits){
        if(!produitsRepository.existsById(id)){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        produits.setId_P(id);
        produitsRepository.save(produits);
        return ResponseEntity.status(HttpStatus.OK).body(produits);
    }

    @GetMapping("/{designation}")
    public List<Produits> rechercheProduit(@PathVariable("designation") String designation) {
        return produitsRepository.findByDesignationContaining(designation);
    }

    @GetMapping
    public List<Produits> getAllProduits(){
        return produitsRepository.findAll();
    }



}
