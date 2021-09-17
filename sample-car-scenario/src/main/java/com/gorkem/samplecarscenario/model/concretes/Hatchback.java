package com.gorkem.samplecarscenario.model.concretes;

import com.gorkem.samplecarscenario.model.abstracts.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hatchback implements Car {

    private final String type = "Hatchback";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Hatchback{" +
                "type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hatchback hatchback = (Hatchback) o;
        return type.equals(hatchback.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
