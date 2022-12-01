package org.example.controller;

import org.example.dao.CarDao;
import org.example.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class MyController {

    private CarDao carDao;

    @Autowired
    public MyController(CarDao carDao) {
        this.carDao = carDao;
    }

    @PostMapping("/cars")
    public Integer addCar(@RequestBody Map<String, Object> map) {
        return carDao.addCar(map);
    }

    @GetMapping("/cars/{id}")
    public Map<String, Object> getCarById(@PathVariable Integer id) {
        return carDao.gerCarById(id);
    }

    @GetMapping("/cars")
    public Map<Integer, Car> getAllCar() {
        return carDao.getAllCar();
    }
}
