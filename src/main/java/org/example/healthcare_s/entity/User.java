package org.example.healthcare_s.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

     private Long id;
     private String Username;
     private String password;


}
