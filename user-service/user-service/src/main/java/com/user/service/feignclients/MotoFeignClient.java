package com.user.service.feignclients;

import com.user.service.model.Car;
import com.user.service.model.Motorcycle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "moto-service",url = "http://localhost:8083",path = "/moto")
public interface MotoFeignClient {
    @PostMapping
    public Motorcycle saveMoto(@RequestBody Motorcycle motorcycle);

    @GetMapping("/user/{userId}")
    public List<Motorcycle> getMotocycles(@PathVariable("userId") int userId);
}
