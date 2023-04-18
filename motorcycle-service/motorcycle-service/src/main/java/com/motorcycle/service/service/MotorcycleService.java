package com.motorcycle.service.service;

import com.motorcycle.service.entity.Motorcycle;

import java.util.List;

public interface MotorcycleService {
    List<Motorcycle> getAll();
    Motorcycle getMotoById(int id);
    Motorcycle save(Motorcycle motorcycle);

    List<Motorcycle> byUserId(int userId);
}
