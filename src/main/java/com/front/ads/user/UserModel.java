package com.front.ads.user;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_model")
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String nome;
    private String email;
    private String username;
    private String telefone;
    

}
