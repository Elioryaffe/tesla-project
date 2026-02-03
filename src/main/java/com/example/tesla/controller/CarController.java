package com.example.tesla.controller;

import com.example.tesla.dto.CarIn;
import com.example.tesla.model.Car;
import com.example.tesla.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllCars() {
        return new ResponseEntity<>(carService.all(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneCar(@PathVariable Long id) {
        return new ResponseEntity<>(carService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insertCar(@RequestBody CarIn carIn) {
        Car car = carIn.toCar(carIn);
        car = carService.save(car);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCar(@PathVariable Long id, @RequestBody CarIn car) {
        Optional<Car> dbCar = carService.findById(id);
        car.updateCar(dbCar.get());
        Car updatedCar = carService.save(dbCar.get());
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id) {
        Optional<Car> dbCar = carService.findById(id);
        carService.delete(dbCar.get());
        return new ResponseEntity<>("DELETED", HttpStatus.OK);
    }
}
