/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.data.service;

import com.samirhasanov.spring.data.dao.ICarDao;
import com.samirhasanov.spring.data.dao.ICustomCarDao;
import com.samirhasanov.spring.data.domain.Car;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hasanov (Asus)
 */
@Service
public class CarService implements ICarService {
    private final ICarDao carDao;
    private final ICustomCarDao customCarDao;
    
    @Autowired
    public CarService(ICarDao carDao, ICustomCarDao customCarDao) {
        this.carDao = carDao;
        this.customCarDao = customCarDao;
    }
    
    @Override
    public Car save(Car car) {
        return this.carDao.save(car);
    }

    @Override
    public long count() {
        return this.carDao.count();
    }

    @Override
    public void delete(Car car) {
        this.carDao.delete(car);
    }

    @Override
    public void deleteById(Long id) {
        this.carDao.deleteById(id);
    }

    @Override
    public List<Car> findAll() {
        return this.carDao.findAll();
    }

    @Override
    public Car findById(Long id) {
        return this.carDao.getOne(id);
    }

    @Override
    public List<Car> findAllByBrand(String brand) {
        return this.carDao.findAllByBrand(brand);
    }

    @Override
    public List<Car> findAllByModel(String model) {
        return this.carDao.findAllByModel(model);
    }

    @Override
    public Double getPriceById(Long id) {
        return this.customCarDao.getPriceById(id);
    }

    @Override
    public List<Car> findAllInPriceRange(Double min, Double max) {
        return this.customCarDao.findAllInPriceRange(min, max);
    }
    
}
