package com.example.final_exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.final_exam.Entity.Product;

public interface ProductRepository extends JpaRepository< Product , Long> {
    
}
