package com.example.exam.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produits {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_P;

    private String designation;

    private String description;

    private String categorie;

    private boolean disponibilite;

    private int quantite;

    private double prix;

    @OneToMany(mappedBy = "produits",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Ligne_Commande>ligne_commandes;
}
