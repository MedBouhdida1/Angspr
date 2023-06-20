    package com.example.exam.Models;


    import com.fasterxml.jackson.annotation.JsonIgnore;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public class Ligne_Commande {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)


        private Long id_L;

        private int quantite;


        @ManyToOne
        @JoinColumn(name = "id_P")
        private Produits produits;

        @ManyToOne
        @JoinColumn(name = "id_c")
        private Commande commande;

    }
