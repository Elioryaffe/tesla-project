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

    @GetMapping("/brand/{brand}")
    public ResponseEntity<?> getByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(carService.findByBrand(brand), HttpStatus.OK);
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<?> getByYear(@PathVariable int year) {
        return new ResponseEntity<>(carService.findByYear(year), HttpStatus.OK);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<?> getByColor(@PathVariable String color) {
        return new ResponseEntity<>(carService.findByColor(color), HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}/year/{year}")
    public ResponseEntity<?> getByBrandAndYear(@PathVariable String brand, @PathVariable int year) {
        return new ResponseEntity<>(carService.findByBrandAndYear(brand, year), HttpStatus.OK);
    }

    @GetMapping("/yearGreaterThan/{year}")
    public ResponseEntity<?> getByYearGreaterThan(@PathVariable int year) {
        return new ResponseEntity<>(carService.findByYearGreaterThan(year), HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<?> getByPriceBetween(@RequestParam double min, @RequestParam double max) {
        return new ResponseEntity<>(carService.findByPriceBetween(min, max), HttpStatus.OK);
    }

    @GetMapping("/rangeKm/{rangeKm}")
    public ResponseEntity<?> getByRangeKm(@PathVariable int rangeKm) {
        return new ResponseEntity<>(carService.findByRangeKm(rangeKm), HttpStatus.OK);
    }
}
