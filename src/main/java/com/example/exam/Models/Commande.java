package com.example.exam.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_c;

    private String date_c;

    @ManyToOne
    @JoinColumn(name = "id_cl")
    private Client client;

    @OneToMany(mappedBy = "commande",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Ligne_Commande>ligne_commandes;
}
