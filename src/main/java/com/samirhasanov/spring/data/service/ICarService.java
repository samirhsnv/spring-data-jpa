/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.data.service;

import com.samirhasanov.spring.data.domain.Car;
import java.util.List;

/**
 *
 * @author Hasanov (Asus)
 */
public interface ICarService {
    public Car save(Car car);
    public long count();
    public void delete(Car car);
    public void deleteById(Long id);
    public List<Car> findAll();
    public Car findById(Long id);
    public List<Car> findAllByBrand(String brand);
    public List<Car> findAllByModel(String model);
    public Double getPriceById(Long id);
    public List<Car> findAllInPriceRange(Double min, Double max);
}
