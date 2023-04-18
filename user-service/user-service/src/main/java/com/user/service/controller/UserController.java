package com.user.service.controller;

import com.user.service.entity.User;
import com.user.service.model.Car;
import com.user.service.model.Motorcycle;
import com.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findUsers(){
        List<User> users = userService.getAll();
        if (users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id")int id){
        User user = userService.getUserById(id);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User newUser = userService.save(user);
        return ResponseEntity.ok(newUser);
    }


    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<Car>> getCars(@PathVariable("userId") int userId){
        User user = userService.getUserById(userId);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        List<Car> cars = userService.getCars(userId);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/motos/{userId}")
    public ResponseEntity<List<Motorcycle>> getMotorcycles(@PathVariable("userId") int userId){
        User user = userService.getUserById(userId);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        List<Motorcycle> motorcycles = userService.getMotorcycles(userId);
        return ResponseEntity.ok(motorcycles);
    }

    @PostMapping("/car/{userId}")
    public ResponseEntity<Car> saveCar(@PathVariable("userId") int userId,@RequestBody Car car){
        Car newCar = userService.saveCar(userId,car);
        return ResponseEntity.ok(newCar);
    }

    @PostMapping("/moto/{userId}")
    public ResponseEntity<Motorcycle> saveMoto(@PathVariable("userId") int userId,@RequestBody Motorcycle motorcycle){
        Motorcycle newMoto = userService.saveMoto(userId,motorcycle);
        return ResponseEntity.ok(newMoto);
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<Map<String,Object>> getVehicles(@PathVariable("userId") int userId){
        Map<String,Object> objectMap = userService.getUserAndVehicles(userId);
        return ResponseEntity.ok(objectMap);
    }
}
