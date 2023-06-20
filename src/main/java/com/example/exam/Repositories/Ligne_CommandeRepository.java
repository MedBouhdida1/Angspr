package com.example.exam.Repositories;

import com.example.exam.Models.Ligne_Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Ligne_CommandeRepository extends JpaRepository<Ligne_Commande, Long> {
}