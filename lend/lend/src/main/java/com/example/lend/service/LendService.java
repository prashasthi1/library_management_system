/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.lend.service;

import com.example.lend.data.Lend;
import com.example.lend.data.LendRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class LendService {
 
     @Autowired
     private LendRepository lendRepository;
     
    public List<Lend> getLends()
    {
        List<Lend> lend =  lendRepository.findAll();
        return lend;
    }
      public Lend getLendByID(int id)
    {
        Optional<Lend> lend =lendRepository.findById(id);
        return lend.get();
    }

       public Lend createLend(Lend lend)
    {
        return lendRepository.save(lend);
    }
        public void deleteById(int id)
    {
       lendRepository.deleteById(id);
    }
         public Lend updateById(Lend order)
    {
         return  lendRepository.save(order);
    }
    
}
