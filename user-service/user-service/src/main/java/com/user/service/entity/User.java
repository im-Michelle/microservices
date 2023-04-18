package com.user.service.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "userservice")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;

}
