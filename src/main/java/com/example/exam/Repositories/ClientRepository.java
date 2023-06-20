package com.example.exam.Repositories;

import com.example.exam.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {


    //2.3
    @Query("SELECT c FROM Client c WHERE size(c.commandes) = (SELECT MAX(size(cl.commandes)) FROM Client cl)")
    Client clientLepLusFidele();


    //2.4
    @Query("SELECT c FROM Client c WHERE c.commandes IS EMPTY")
    List<Client> ClientWithNoCommands();
}