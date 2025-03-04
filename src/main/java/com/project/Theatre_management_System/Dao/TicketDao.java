package com.project.Theatre_management_System.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_management_System.Dto.Branch;
import com.project.Theatre_management_System.Dto.Manager;
import com.project.Theatre_management_System.Dto.Payment;
import com.project.Theatre_management_System.Dto.Theatre;
import com.project.Theatre_management_System.Dto.Ticket;
import com.project.Theatre_management_System.Repo.TicketRepo;

@Repository
public class TicketDao {

	@Autowired
	TicketRepo ticketRepo;
	
	@Autowired
	PaymentDao paymentDao;
	
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}
	
	public Ticket addExistingTicketToExistingPayment(int ticketId, int paymentId) {
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		Ticket ticket = fetchTicketById(ticketId);
		ticket.setPayment(payment);
		return saveTicket(ticket);
	}
	
	
	
	public Ticket fetchTicketById(int ticketId) {
		Optional<Ticket> dbTicket = ticketRepo.findById(ticketId);
		if(dbTicket.isPresent()) {
			return dbTicket.get();
		}else {
			return null;
		}
	}
	
	public List<Ticket> fetchAllTicket(){
		return ticketRepo.findAll();
	}
	
	public Ticket updateTicketById(int oldTicketId,Ticket newTicket) {
		newTicket.setTicketId(oldTicketId);
		return ticketRepo.save(newTicket);
	}
	public Ticket deleteTicketById(int ticketId) {
		Ticket ticket = fetchTicketById(ticketId);
		return ticket;
	}
}
