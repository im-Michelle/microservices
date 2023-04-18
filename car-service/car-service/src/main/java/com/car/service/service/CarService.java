package com.car.service.service;

import com.car.service.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();
    Car getCarById(int id);
    Car save(Car car);
    List<Car> byUserId(int userId);
}
