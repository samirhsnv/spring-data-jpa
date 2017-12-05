/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.data.dao;

import com.samirhasanov.spring.data.domain.Car;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Hasanov (Asus)
 */
@RepositoryDefinition(domainClass = Car.class, idClass = Long.class)
public interface ICustomCarDao {
    
    @Query("select t from Car t where t.price between :min and :max")
    public List<Car> findAllInPriceRange(@Param("min") Double min, @Param("max") Double max);
    
    @Query("select c.price from Car c where c.id = :id")
    public Double getPriceById(@Param("id") Long id);
}
