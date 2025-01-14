package com.demo.payment_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.payment_service.entity.Payments;
import com.demo.payment_service.servie.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    PaymentService service;

    @GetMapping("/{id}")
    public ResponseEntity<Payments> getAPayment(@PathVariable int id){
        return new ResponseEntity<>(service.getAPayment(id), HttpStatus.OK);
    }

    @GetMapping("/lastId")
    public ResponseEntity<Integer> getLatestPaymentId(){
        return new ResponseEntity<>(service.getLatestPaymentId(), HttpStatus.OK);
    }
}
