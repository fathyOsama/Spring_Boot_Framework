package com.luv2code.springboot.thymeleafdemo.dao;

import com.luv2code.springboot.thymeleafdemo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    // that's it ... no need to write any code LOL!

    // add a method to sort by last name
    //public List<Employee> findAllByOderByLastNameAsc();
    public List<Car> findAllByOrderByCarModelAsc();
}
