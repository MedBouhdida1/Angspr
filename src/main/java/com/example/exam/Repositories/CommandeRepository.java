package com.example.exam.Repositories;

import com.example.exam.Models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

    //2.1
    @Query("SELECT COUNT(c) FROM Client cl JOIN cl.commandes c WHERE cl.id_CL = :clientId")
    int NbrCommandesByClient(Long clientId);

}