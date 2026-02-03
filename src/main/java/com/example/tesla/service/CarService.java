package com.example.tesla.service;

import com.example.tesla.model.Car;
import com.example.tesla.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {
    @Autowired
    CarRepository repository;

    public Iterable<Car> all() {
        return repository.findAll();
    }

    public Optional<Car> findById(Long id) {
        return repository.findById(id);
    }

    public Car save(Car car) {
        return repository.save(car);
    }

    public void delete(Car car) {
        repository.delete(car);
    }
}
