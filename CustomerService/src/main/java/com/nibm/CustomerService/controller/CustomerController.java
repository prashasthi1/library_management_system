
package com.nibm.CustomerService;

import com.nibm.CustomerService.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {
    
    @Autowired
    private CustomerService customerservice; 
    
    @CrossOrigin(origins="*")
    @GetMapping(path = "/customers/{id}")
    public Customer getCustomerById(@PathVariable int id){
        return customerservice.getCustomerById(id);
    }  
    
    @CrossOrigin(origins = "*")     
    @GetMapping(path = "/customers")
    public List<Customer> getCustomers() {
        return customerservice.getCustomers();
    }
    
    @CrossOrigin(origins="*")
    @PostMapping(path = "/customers")
    public Customer createUser(@RequestBody Customer customer){
        return customerservice.createUser(customer);
    }
    
    @CrossOrigin(origins="*")
    @PutMapping(path = "/customers/{id}")
    public void updateUser(@PathVariable int id, @RequestBody Customer customer){
        customer.setId(id);
        customerservice.updateUser(customer);
    }
    
    @CrossOrigin(origins = "*")
    @DeleteMapping("customers/{id}")
    public void deleteUser(@PathVariable int id) {
       customerservice.deleteUser(id);
    }
    
 
}
