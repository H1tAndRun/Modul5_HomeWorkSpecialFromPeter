package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {

    private String mark;

    private String model;

    private Integer createdYear;

    private Integer mileage;

    private double price;
}
