package com.example.exam.Repositories;

import com.example.exam.Models.Produits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProduitsRepository extends JpaRepository<Produits, String> {


    List<Produits> findByDesignationContaining(String designation);


    //2.2
    @Query("SELECT COUNT(lc) FROM Commande c JOIN c.ligne_commandes lc WHERE c.id_c = :commandeId")
    int getProductCountByCommandeId(Long commandeId);


    //2.5
    @Query("SELECT p FROM Produits p JOIN p.ligne_commandes lc GROUP BY p.id_P ORDER BY SUM(lc.quantite) DESC")
    Produits ProduitsLePlusDemande();

}