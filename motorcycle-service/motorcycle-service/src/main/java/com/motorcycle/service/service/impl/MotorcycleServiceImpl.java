package com.motorcycle.service.service.impl;

import com.motorcycle.service.entity.Motorcycle;
import com.motorcycle.service.repository.MotorcycleRepository;
import com.motorcycle.service.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorcycleServiceImpl implements MotorcycleService {
    @Autowired
    MotorcycleRepository motorcycleRepository;

    @Override
    public List<Motorcycle> getAll() {
        return motorcycleRepository.findAll();
    }

    @Override
    public Motorcycle getMotoById(int id) {
        Optional<Motorcycle> optional = motorcycleRepository.findById(id);
        return optional.get();
    }

    @Override
    public Motorcycle save(Motorcycle motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }

    @Override
    public List<Motorcycle> byUserId(int userId) {
        return motorcycleRepository.findByuserId(userId);
    }
}
