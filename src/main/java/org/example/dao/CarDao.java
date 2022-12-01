package org.example.dao;

import org.example.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class CarDao {

    private Map<Integer, Car> carMap = new HashMap<>();

    private Integer countId = 0;

    public Integer addCar(Map<String, Object> map) {
        ++countId;
        carMap.put(countId, createCar(map));
        return countId;
    }

    public Map<Integer, Car> getAllCar() {
        return carMap;
    }

    public Car createCar(Map<String, Object> map) {
        String carName = (String) map.get("mark");
        String carModel = (String) map.get("model");
        Map<String, Object> map1 = (Map<String, Object>) map.get("history");
        Integer createdYear = (Integer) map1.get("createdYear");
        Integer mileage = (Integer) map1.get("mileage");
        Integer countOwner = (Integer) map1.get("countOwner");
        double price = setPrice(carName, mileage, countOwner);

        return new Car(carName, carModel, createdYear, mileage, price);
    }

    private double setPrice(String carName, Integer mileage, Integer countOwner) {
        double price = 0;
        if (carName.equals("bmw")) {
            price = countPercentage(50000, mileage, countOwner);
        } else if (carName.equals("mercedes")) {
            price = countPercentage(70000, mileage, countOwner);
        } else if (carName.equals("kia")) {
            price = countPercentage(35000, mileage, countOwner);
        }
        return price;
    }

    private double countPercentage(double price, Integer mileage, Integer countOwner) {
        double res = price - (mileage * 0.1);
        if (countOwner >= 2) {
            res -= (res / 100 * 20);
        }
        return res;
    }

    public Map<String, Object> gerCarById(Integer id) {
        Map<String, Object> resultMap = new HashMap<>();
        Car car = carMap.get(id);
        resultMap.put("name", car.getMark() + " " + car.getModel());
        resultMap.put("mileage", car.getMileage());
        resultMap.put("age_car", 2022 - car.getCreatedYear());
        resultMap.put("price", car.getPrice());
        return resultMap;
    }
}
