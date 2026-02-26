package com.example.InheritanceMapping.repository;

import com.example.InheritanceMapping.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}