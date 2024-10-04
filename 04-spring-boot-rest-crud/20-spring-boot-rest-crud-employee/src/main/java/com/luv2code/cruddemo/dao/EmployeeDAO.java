package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {

    List<Employee> findAll();

    List<Employee> findEmployeeWithALetter();
}
