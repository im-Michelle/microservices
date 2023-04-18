package com.car.service.service.impl;

import com.car.service.entity.Car;
import com.car.service.repository.CarRepository;
import com.car.service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(int id) {
        Optional<Car> optional = carRepository.findById(id);
        return optional.get();
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> byUserId(int userId) {
        return carRepository.findByuserId(userId);
    }
}
