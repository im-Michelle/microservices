package com.motorcycle.service.controller;

import com.motorcycle.service.entity.Motorcycle;
import com.motorcycle.service.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotorcycleController {
    @Autowired
    MotorcycleService motorcycleService;

    @GetMapping
    public ResponseEntity<List<Motorcycle>> getMotorcycles(){
        List<Motorcycle> motorcycles = motorcycleService.getAll();
        if (motorcycles.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(motorcycles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motorcycle> getMotorcycleById(@RequestParam("id") int motoId){
        Motorcycle motorcycle = motorcycleService.getMotoById(motoId);
        if (motorcycle == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(motorcycle);
    }

    @PostMapping
    public ResponseEntity<Motorcycle> saveMotorcycle(@RequestBody Motorcycle motorcycle){
        Motorcycle newMotorcycle = motorcycleService.save(motorcycle);
        return ResponseEntity.ok(newMotorcycle);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Motorcycle>> getMotorcyclesByUserId(@PathVariable("userId") int userId){
        List<Motorcycle> motorcycles = motorcycleService.byUserId(userId);
        if (motorcycles.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(motorcycles);
    }

}
