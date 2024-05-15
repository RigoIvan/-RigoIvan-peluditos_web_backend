package com.rigo.apirest.Cliente;



import org.springframework.stereotype.Component;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
public class Cliente {
    @Id
    @GeneratedValue
    private Integer id;
    @Basic
    private String email;
    private String firstName; // Cambiar a minúscula
    private String lastName; // Cambiar a minúscula
    private String petName; // Cambiar a minúscula
    private String service;
    private String favoriteHobby;
}
