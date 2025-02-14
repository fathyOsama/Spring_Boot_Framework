package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Car;
import com.luv2code.springboot.thymeleafdemo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService= carService;
    }

    @GetMapping("/list")
    public String listCars(Model theModel) {

        // get the cars from db
        List<Car> theCars = carService.findAll();

        // add to the spring model
        theModel.addAttribute("cars", theCars);

        return "cars/list-cars";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        // Create model attribute to bind form data
        Car theCar = new Car();
        theModel.addAttribute("car",theCar);
        return "cars/car-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("carId") int theId, Model theModel){

        // get the car from the service
        Car theCar = carService.findById(theId);

        // set car in the model to prepopulate the form
        theModel.addAttribute("car",theCar);

        // send over to our form

        return "cars/car-form";
    }

    @PostMapping("/save")
    public String saveCar(@ModelAttribute("car") Car theCar){
        // Save the car
        carService.save(theCar);

        // use a redirect to prevent duplicate submissions
        return "redirect:/cars/list";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("carId") int theId){

        // delete the car
        carService.deleteById(theId);

        // redirect to the /car/list
        return "redirect:/cars/list";

    }
}
