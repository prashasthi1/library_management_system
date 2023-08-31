/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibm.CustomerService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
    
  
    @Modifying
    @Query("DELETE FROM Customer WHERE id = ?1")
    public void deleteById(int id);
    
}
