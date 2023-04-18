package com.user.service.service.impl;

import com.user.service.entity.User;
import com.user.service.feignclients.CarFeignClient;
import com.user.service.feignclients.MotoFeignClient;
import com.user.service.model.Car;
import com.user.service.model.Motorcycle;
import com.user.service.repository.UserRepository;
import com.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarFeignClient carFeignClient;

    @Autowired
    private MotoFeignClient motoFeignClient;

    @Override
    public Map<String, Object> getUserAndVehicles(int userId) {
        Map<String,Object> map = new HashMap<>();
        Optional<User> optionalUser = userRepository.findById(userId);
        map.put("User",optionalUser);
        List<Car> cars = carFeignClient.getCars(userId);
        if (cars.isEmpty()) {
            map.put("Cars","User doesn't have cars");
        } else {
            map.put("Cars",cars);
        }
        List<Motorcycle> motorcycles = motoFeignClient.getMotocycles(userId);
        if (motorcycles.isEmpty()) {
            map.put("Motorcycles","User doesn't have motorcyles");
        } else {
            map.put("Motorcycles",motorcycles);
        }
        return map;
    }

    @Override
    public Car saveCar(int userId, Car car) {
        car.setUserId(userId);
        Car newCar = carFeignClient.save(car);
        return newCar;
    }

    @Override
    public Motorcycle saveMoto(int userId, Motorcycle motorcycle) {
        motorcycle.setUserId(userId);
        Motorcycle newMoto = motoFeignClient.saveMoto(motorcycle);
        return newMoto;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        User newUser = userRepository.save(user);
        return newUser;
    }


    // restTemplate
    public List<Car> getCars(int userId){
        List<Car> cars = restTemplate.getForObject("http://localhost:8082/car/user/"+userId,List.class);
        return cars;
    }

    public List<Motorcycle> getMotorcycles(int userId){
        List<Motorcycle> motorcycles = restTemplate.getForObject("http://localhost:8083/moto/user/" + userId,List.class);
        return motorcycles;
    }

}
