/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nibm.CustomerService.service;

import com.nibm.CustomerService.Customer;
import com.nibm.CustomerService.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class CustomerService {
    
      @Autowired
    private CustomerRepository customerRepository;
      
        public Customer getCustomerById(int id)
    {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    }
         public List<Customer> getCustomers()
    {
        List<Customer> customer = customerRepository.findAll();
        return customer;
    }
          public Customer createUser(Customer customer)
    {
        return customerRepository.save(customer);
    }
           public Customer updateUser(Customer customer)
    {
        return customerRepository.save(customer);
    }
           public void deleteUser(int id) 
    {
       customerRepository.deleteById(id);
    }
          
    
}
