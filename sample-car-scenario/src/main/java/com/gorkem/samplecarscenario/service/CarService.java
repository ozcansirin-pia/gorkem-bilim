package com.gorkem.samplecarscenario.service;

import com.gorkem.samplecarscenario.model.abstracts.Car;
import com.gorkem.samplecarscenario.model.concretes.Cabrio;
import com.gorkem.samplecarscenario.model.concretes.Hatchback;
import com.gorkem.samplecarscenario.model.concretes.Sedan;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    public Car findTheCarType(String carType) {
        switch (carType) {
            case "cabrio":
                return new Cabrio();
            case "sedan":
                return new Sedan();
            case "hatchback":
                return new Hatchback();
        }
        return null;
    }
}
