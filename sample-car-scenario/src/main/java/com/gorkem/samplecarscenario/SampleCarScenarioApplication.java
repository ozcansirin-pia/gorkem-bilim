package com.gorkem.samplecarscenario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SampleCarScenarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleCarScenarioApplication.class, args);
    }

}
