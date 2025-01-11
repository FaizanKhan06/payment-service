package com.demo.payment_service.servie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.payment_service.entity.Payments;
import com.demo.payment_service.repo.PaymentRepo;

@Service
public class PaymentService {

    @Autowired
    PaymentRepo repo;

    public Payments getAPayment(int id){
        return repo.findById(id).orElse(null);
    }


    public Payments addAPayment(Payments payments){
        return repo.saveAndFlush(payments);
    }
    

}
