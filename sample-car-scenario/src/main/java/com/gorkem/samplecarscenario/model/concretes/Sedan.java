package com.gorkem.samplecarscenario.model.concretes;

import com.gorkem.samplecarscenario.model.abstracts.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sedan implements Car {

    private final String type = "Sedan";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Sedan{" +
                "type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sedan sedan = (Sedan) o;
        return type.equals(sedan.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
