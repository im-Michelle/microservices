package com.user.service.service;

import com.user.service.entity.User;
import com.user.service.model.Car;
import com.user.service.model.Motorcycle;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface UserService {
    public Map<String, Object> getUserAndVehicles(int userId);
    public Car saveCar(int userId, Car car);
    public Motorcycle saveMoto(int userId, Motorcycle motorcycle);
    public List<Car> getCars(int userId);
    public List<Motorcycle> getMotorcycles(int userId);
    public List<User> getAll();
    public User getUserById(int id);
    public User save(User user);
}
