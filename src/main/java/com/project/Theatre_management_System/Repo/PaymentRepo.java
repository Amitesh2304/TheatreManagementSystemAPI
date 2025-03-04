package com.project.Theatre_management_System.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Theatre_management_System.Dto.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}
