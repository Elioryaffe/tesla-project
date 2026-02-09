package com.example.tesla.service;

import com.example.tesla.model.Car;
import com.example.tesla.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;


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

    public Iterable<Car> findByBrand(String brand) {
        return repository.findByBrand(brand);
    }

    public Iterable<Car> findByYear(int year) {
        return repository.findByYear(year);
    }

    public Iterable<Car> findByColor(String color) {
        return repository.findByColor(color);
    }

    public Iterable<Car> findByBrandAndYear(String brand, int year) {
        return repository.findByBrandAndYear(brand, year);
    }

    public Iterable<Car> findByYearGreaterThan(int year) {
        return repository.findByYearGreaterThan(year);
    }

    public Iterable<Car> findByPriceBetween(double min, double max) {
        return repository.findByPriceBetween(min, max);
    }

    public Iterable<Car> findByRangeKm(Integer rangeKm) {
        return repository.findByRangeKm(rangeKm);
    }
}
