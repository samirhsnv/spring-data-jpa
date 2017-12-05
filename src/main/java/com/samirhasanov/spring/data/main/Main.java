/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.data.main;

import com.samirhasanov.spring.data.config.AppConfig;
import com.samirhasanov.spring.data.config.DbConfig;
import com.samirhasanov.spring.data.domain.Car;
import com.samirhasanov.spring.data.service.ICarService;
import java.util.Arrays;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Hasanov (Asus)
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class, DbConfig.class);
        ICarService service = applicationContext.getBean(ICarService.class);
        
        Arrays.asList(new Car[] {
            new Car("Mercedes Benz", "G400", 2002, 13500D),
            new Car("Mercedes Benz", "S550", 2015, 65000D),
            new Car("Mercedes Benz", "C240", 1998, 4000D),
            new Car("Mercedes Benz", "E400 Coupe", 2018, 49500D),
            new Car("BMW", "M5", 2016, 83000D),
            new Car("BMW", "330", 2010, 8700D),
            new Car("BMW", "X6", 2012, 29500D),
            new Car("Honda", "Accord", 2009, 9000D),
            new Car("Toyota", "Prius", 2013, 8200D),
            new Car("Toyota", "Camry", 2008, 5800D),
            new Car("Nissan", "Altima", 2014, 16000D),
            new Car("Tesla", "Model X", 2017, 98000D),
            new Car("Tesla", "Model S", 2018, 123000D)
        }).forEach((car) -> {
            service.save(car);
        });
        
        List<Car> cars = service.findAll();
        List<Car> mercedesCars = service.findAllByBrand("Mercedes");
        List<Car> carsInPriceRange = service.findAllInPriceRange(1000D, 20000D);
        
        doPrintList("--- All ---", cars, "");
        doPrintList("--- Mercedes Benz brand only ---", mercedesCars, "");
        doPrintList("--- Cars with price range 1k-20k ---", carsInPriceRange, "");
    }
    
    private static void doPrintList(String header, List<? extends Object> list, String footer) {
        System.out.println(header);
        
        list.forEach((t) -> {
            System.out.println(t);
        });
        
        System.out.println(footer);
    }
}
