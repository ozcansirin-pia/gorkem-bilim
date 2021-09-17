package com.gorkem.samplecarscenario.controller;

import com.gorkem.samplecarscenario.service.CarService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/produce/{car-type}")
    public String getContent(@PathVariable("car-type") String carType) {
        var result = this.carService.findTheCarType(carType);

        if (result != null) {
            return result.getType() + " Car has produced.";
        } else {
            return "This type can not be produce!";
        }
    }
}
