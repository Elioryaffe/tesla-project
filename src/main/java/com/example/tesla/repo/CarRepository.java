package com.example.tesla.repo;

import com.example.tesla.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {

}