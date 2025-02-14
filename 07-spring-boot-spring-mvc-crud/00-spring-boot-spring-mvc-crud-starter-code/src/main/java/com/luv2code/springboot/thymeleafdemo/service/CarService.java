package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.entity.Car;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface CarService {
    List<Car> findAll();

    Car findById(int theId);

    Car save(Car theCar);

    void deleteById(int theId);
}
