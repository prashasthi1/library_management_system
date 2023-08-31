/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibm.BookService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sahan
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
    
  
    @Transactional
    @Query("update Book b set b.available = ?2 where b.id = ?1")
    public void setAvailabilityByUserReferenceId(int id,String available);
    
    @Modifying
    @Query("DELETE FROM Book WHERE id = ?1")
    public void deleteById(int id);
    
}
