/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.lend.controller;

import com.example.lend.data.Lend;
import com.example.lend.service.LendService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
public class LendController {
    
    @Autowired
    private LendService lendService;
    
    @CrossOrigin(origins = "*")     
    @GetMapping(path = "/lends")
    public List<Lend> getLends() {
        return lendService.getLends();
    }
    
    
    @GetMapping(path = "/lends/{id}")
    public Lend getLendById(@PathVariable int id){
        
    return lendService.getLendByID(id);
       
    }  
    
      /*
    @PostMapping("/lend")
  public Lend postLend(@RequestBody Lend lend) {
 
    Lend _lend = lendRepository.save(new Lend(lend.getCustomerId(), lend.getBokkId(),lend.getBookName() ,lend.getDateOfIssue(),lend.getDueDate()  ));
    return _lend;
  }
    
    
    */
    
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/lends")
    public Lend createLend(@RequestBody Lend lend) {
        
        return lendService.createLend(lend);
    }


    @PutMapping(path = "/lends")
    public Lend updateLend(@RequestBody Lend lend) {
        return lendService.updateById(lend);
    }
    
    
    
    
    @DeleteMapping("/lends/{id}")
  public ResponseEntity<String> deleteLend(@PathVariable("id") int id) {
    //System.out.println("Delete lend with ID = " + id + "...");
 
    lendService.deleteById(id);
 
    return new ResponseEntity<>("Successfully deleted!", HttpStatus.OK);
  }
    
}
