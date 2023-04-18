package com.motorcycle.service.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "motoservice")
public class Motorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private String model;
    private Integer userId;

}
