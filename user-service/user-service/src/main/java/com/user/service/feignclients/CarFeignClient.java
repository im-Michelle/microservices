package com.user.service.feignclients;

import com.user.service.model.Car;
import com.user.service.model.Motorcycle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "car-service",url = "http://localhost:8082",path = "/car")
public interface CarFeignClient {

    @PostMapping()
    public Car save(@RequestBody Car car);

    @GetMapping("/user/{userId}")
    public List<Car> getCars(@PathVariable("userId") int userId);

}
