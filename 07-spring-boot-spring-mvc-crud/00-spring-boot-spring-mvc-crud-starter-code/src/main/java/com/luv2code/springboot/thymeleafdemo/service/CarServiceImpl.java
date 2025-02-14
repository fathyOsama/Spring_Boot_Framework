package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.dao.CarRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Car;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    CarRepository carRepository;
    @Autowired
    public CarServiceImpl(CarRepository carRepository){
        this.carRepository = carRepository;
    }
    @Override
    public List<Car> findAll() {
        return carRepository.findAllByOrderByCarModelAsc();
    }

    @Override
    public Car findById(int theId) {
        Optional<Car> result = carRepository.findById(theId);

        Car theCar = null;

        if (result.isPresent()) {
            theCar = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theCar;
    }

    @Override
    public Car save(Car theCar) {
        return carRepository.save(theCar);
    }

    @Override
    public void deleteById(int theId) {
        carRepository.deleteById(theId);
    }
}
