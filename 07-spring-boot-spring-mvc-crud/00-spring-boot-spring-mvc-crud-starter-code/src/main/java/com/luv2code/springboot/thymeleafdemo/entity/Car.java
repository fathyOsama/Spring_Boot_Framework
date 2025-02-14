package com.luv2code.springboot.thymeleafdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="car_name")
    private String carName;

    @Column(name="car_model")
    private String carModel;

    @Column(name="car_color")
    private String carColor;

    @Column(name = "car_imge")
    private String carImge;


    // define constructors
    public Car() {

    }

    public Car(String carColor, String carModel, String carName,String carImge) {
        this.carColor = carColor;
        this.carModel = carModel;
        this.carName = carName;
        this.carImge = carImge;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarImge() {
        return carImge;
    }

    public void setCarImge(String carImge) {
        this.carImge = carImge;
    }
}
