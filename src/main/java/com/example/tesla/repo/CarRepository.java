package com.example.tesla.repo;

import com.example.tesla.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {

    Iterable<Car> findByBrand(String brand);

    Iterable<Car> findByYear(int year);

    Iterable<Car> findByColor(String color);

    Iterable<Car> findByBrandAndYear(String brand, int year);

    Iterable<Car> findByYearGreaterThan(int year);

    Iterable<Car> findByPriceBetween(double min, double max);

    Iterable<Car> findByRangeKm(Integer rangeKm);
}