package com.demo.payment_service.servie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.payment_service.entity.Payments;
import com.demo.payment_service.repo.PaymentRepo;

@Service
public class PaymentService {

    @Autowired
    PaymentRepo repo;

    static int payment_id_count = 1;

    public Payments getAPayment(int id){
        return repo.findById(id).orElse(null);
    }

    public int getLatestPaymentId(){
        return payment_id_count-1;
    }

    public static Payments deserializePayment(String paymentString) {
        // Remove the class name and parentheses
        paymentString = paymentString.replace("Payments(", "").replace(")", "");

        // Split the string by comma to separate fields
        String[] fields = paymentString.split(", ");

        // Extract id and paymentType
        // int id = Integer.parseInt(fields[0].split("=")[1]);
        int orderId = Integer.parseInt(fields[1].split("=")[1]);
        int cardNumber = Integer.parseInt(fields[2].split("=")[1]);

        // Create a Payments object and return
        return new Payments(payment_id_count++, orderId, cardNumber);
    }

    @KafkaListener(topics = "order-topic", groupId = "user-group")
    public Payments addAPayment(String payment_details){
        System.out.println(payment_details);
        Payments payments = deserializePayment(payment_details);
        System.out.println(payments);
        return repo.saveAndFlush(payments);
    }
    

}
