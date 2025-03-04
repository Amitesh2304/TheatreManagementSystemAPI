package com.project.Theatre_management_System.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_management_System.Dto.Payment;
import com.project.Theatre_management_System.Repo.PaymentRepo;

@Repository
public class PaymentDao {

	@Autowired
	PaymentRepo paymentRepo;
	
	public Payment savePayment(Payment payment) {
		return paymentRepo.save(payment);	
	}
	
	public Payment fetchPaymentById(int paymentId) {
		Optional<Payment> dbPayment = paymentRepo.findById(paymentId);
		if(dbPayment.isPresent()) {
			return dbPayment.get();
		}else {
			return null;
		}
	}
	
	public List<Payment> fetchAllPayment(){
		return paymentRepo.findAll();
	}
	
	public Payment updatePaymentById(int oldPaymentId,Payment newPayment) {
		newPayment.setPaymentId(oldPaymentId);
		return paymentRepo.save(newPayment);
	}
	public Payment deletePaymentById(int paymentId) {
		Payment Payment = fetchPaymentById(paymentId);
		return Payment;
	}
}
