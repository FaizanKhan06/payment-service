package com.demo.payment_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.payment_service.entity.Payments;

@Repository
public interface PaymentRepo extends JpaRepository<Payments, Integer>{

    
}