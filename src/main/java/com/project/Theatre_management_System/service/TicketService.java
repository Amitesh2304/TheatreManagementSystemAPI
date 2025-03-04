package com.project.Theatre_management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_management_System.Dao.PaymentDao;
import com.project.Theatre_management_System.Dao.TicketDao;
import com.project.Theatre_management_System.Dto.Payment;
import com.project.Theatre_management_System.Dto.Ticket;
import com.project.Theatre_management_System.exception.PaymentIdNotFound;
import com.project.Theatre_management_System.exception.TicketIdNotFound;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

@Service
public class TicketService {

	@Autowired
	TicketDao ticketDao;

	@Autowired
	PaymentDao paymentDao;

	@Autowired
	ResponseStructure<Ticket> responseStructure;

	@Autowired
	ResponseStructure1<Ticket> responseStructure1;

	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(Ticket ticket) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Ticket Inserted into DB.");
		responseStructure.setData(ticketDao.saveTicket(ticket));
		return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Ticket>> addExistingTicketToExistingPayment(int ticketId, int paymentId) {
		Ticket ticket = ticketDao.fetchTicketById(ticketId);
		if (ticket != null) {
			Payment payment = paymentDao.fetchPaymentById(paymentId);
			if (payment != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Ticket Added into DB.");
				responseStructure.setData(ticketDao.addExistingTicketToExistingPayment(ticketId, paymentId));
				return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.OK);
			} else {
				throw new PaymentIdNotFound();
			}
		} else {
			throw new TicketIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Ticket>> fetchTicketById(int ticketId) {
		Ticket ticket = ticketDao.fetchTicketById(ticketId);
		if (ticket != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Ticket Fetched From DB.");
			responseStructure.setData(ticketDao.fetchTicketById(ticketId));
			return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new TicketIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Ticket>> fetchAllTicket() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully fetched all the Ticket from DataBase");
		responseStructure1.setData(ticketDao.fetchAllTicket());
		return new ResponseEntity<ResponseStructure1<Ticket>>(responseStructure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Ticket>> updateTicketById(int oldTicketId, Ticket newTicket) {
		Ticket ticket = ticketDao.fetchTicketById(oldTicketId);
		if (ticket != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Ticket Updated into DB.");
			responseStructure.setData(ticketDao.updateTicketById(oldTicketId, newTicket));
			return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.OK);
		} else {
			throw new TicketIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Ticket>> deleteTicketById(int ticketId) {
		Ticket ticket = ticketDao.fetchTicketById(ticketId);
		if (ticket != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Ticket Deleted From DB.");
			responseStructure.setData(ticketDao.deleteTicketById(ticketId));
			return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.OK);
		}else
		{
			throw new TicketIdNotFound();
		}
	}

}
