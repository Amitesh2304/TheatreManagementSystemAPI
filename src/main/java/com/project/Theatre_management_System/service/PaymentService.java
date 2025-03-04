package com.project.Theatre_management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_management_System.Dao.PaymentDao;
import com.project.Theatre_management_System.Dto.Payment;
import com.project.Theatre_management_System.exception.PaymentIdNotFound;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

@Service
public class PaymentService {

	@Autowired
	PaymentDao paymentDao;

	@Autowired
	ResponseStructure<Payment> responseStructure;

	@Autowired
	ResponseStructure1<Payment> responseStructure1;

	public ResponseEntity<ResponseStructure<Payment>> savePayment(Payment payment) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Payment Inserted into DB.");
		responseStructure.setData(paymentDao.savePayment(payment));
		return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Payment>> fetchPaymentById(int paymentId) {
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		if (payment != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Payment Fetched From DB.");
			responseStructure.setData(paymentDao.fetchPaymentById(paymentId));
			return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new PaymentIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Payment>> fetchAllPayment() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully fetched all the Payment from DataBase");
		responseStructure1.setData(paymentDao.fetchAllPayment());
		return new ResponseEntity<ResponseStructure1<Payment>>(responseStructure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Payment>> updatePaymentById(int oldPaymentId, Payment newPayment) {
		Payment payment = paymentDao.fetchPaymentById(oldPaymentId);
		if (payment != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Payment Updated into DB.");
			responseStructure.setData(paymentDao.updatePaymentById(oldPaymentId, newPayment));
			return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.OK);
		} else {
			throw new PaymentIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Payment>> deletePaymentById(int paymentId) {
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		if (payment != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Successfully Payment Deleted From DB.");
			responseStructure.setData(paymentDao.deletePaymentById(paymentId));
			return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new PaymentIdNotFound();
		}
	}
}
