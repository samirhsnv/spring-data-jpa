/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.data.dao;

import com.samirhasanov.spring.data.domain.Car;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Hasanov (Asus)
 */
public interface ICarDao extends JpaRepository<Car, Long> {
    
    @Query("select c from Car c where c.brand like %?1%")
    public List<Car> findAllByBrand(String brand);
    
    @Query("select c from Car c where c.model like %?1%")
    public List<Car> findAllByModel(String brand);
    
}
