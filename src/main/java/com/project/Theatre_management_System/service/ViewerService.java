package com.project.Theatre_management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_management_System.Dao.FoodDao;
import com.project.Theatre_management_System.Dao.TicketDao;
import com.project.Theatre_management_System.Dao.ViewerDao;
import com.project.Theatre_management_System.Dto.Food;
import com.project.Theatre_management_System.Dto.Ticket;
import com.project.Theatre_management_System.Dto.Viewer;
import com.project.Theatre_management_System.exception.FoodIdNotFound;
import com.project.Theatre_management_System.exception.TicketIdNotFound;
import com.project.Theatre_management_System.exception.ViewerIdNotFound;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

@Service
public class ViewerService {

	@Autowired
	ViewerDao viewerDao;

	@Autowired
	FoodDao foodDao;

	@Autowired
	TicketDao ticketDao;

	@Autowired
	ResponseStructure<Viewer> responseStructure;

	@Autowired
	ResponseStructure1<Viewer> responseStructure1;

	public ResponseEntity<ResponseStructure<Viewer>> addNewFoodToExistingViewer(int viewerId, Food newFood) {
		Viewer viewer = viewerDao.fetchViewerById(viewerId);
		if (viewer != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Food Add To Viewer.");
			responseStructure.setData(viewerDao.addNewFoodToExistingViewer(viewerId, newFood));
			return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.OK);
		} else {
			throw new ViewerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Viewer>> addExistingFoodToExistingViewer(int foodId, int viewerId) {
		Food food = foodDao.fetchFoodById(foodId);
		if (food != null) {
			Viewer viewer = viewerDao.fetchViewerById(viewerId);
			if (viewer != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Food Added to Viewer.");
				responseStructure.setData(viewerDao.addExistingFoodToExistingViewer(foodId, viewerId));
				return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.OK);
			} else {
				throw new FoodIdNotFound();
			}
		} else {
			throw new ViewerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Viewer>> addNewTicketToExistingViewer(int viewerId, Ticket newTicket) {
		Viewer viewer = viewerDao.fetchViewerById(viewerId);
		if (viewer != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Ticket Added to Viewer into DB.");
			responseStructure.setData(viewerDao.addNewTicketToExistingViewer(viewerId, newTicket));
			return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.OK);
		} else {
			throw new ViewerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Viewer>> addExistingTicketToExistingViewer(int ticketId, int viewerId) {
		Ticket ticket = ticketDao.fetchTicketById(ticketId);
		if (ticket != null) {
			Viewer viewer = viewerDao.fetchViewerById(viewerId);
			if (viewer != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Ticket to Viewer into DB.");
				responseStructure.setData(viewerDao.addExistingTicketToExistingViewer(ticketId, viewerId));
				return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.OK);
			} else {
				throw new ViewerIdNotFound();
			}
		} else {
			throw new TicketIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Viewer>> saveViewer(Viewer viewer) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Viewer Inserted into DB.");
		responseStructure.setData(viewerDao.saveViewer(viewer));
		return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Viewer>> fetchViewerById(int viewerId) {
		Viewer viewer = viewerDao.fetchViewerById(viewerId);
		if (viewer != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Viewer Fetched From DB.");
			responseStructure.setData(viewerDao.fetchViewerById(viewerId));
			return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new ViewerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Viewer>> fetchAllViewer() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully fetched all the Viewer from DataBase");
		responseStructure1.setData(viewerDao.fetchAllViewer());
		return new ResponseEntity<ResponseStructure1<Viewer>>(responseStructure1,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Viewer>> updateViewerById(int oldViewerId, Viewer newViewer) {
		Viewer viewer = viewerDao.fetchViewerById(oldViewerId);
		if (viewer != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Viewer Updated into DB.");
			responseStructure.setData(viewerDao.updateViewerById(oldViewerId, newViewer));
			return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.OK);
		} else {
			throw new ViewerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Viewer>> deleteViewerById(int viewerId) {
		Viewer viewer = viewerDao.fetchViewerById(viewerId);
		if (viewer != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Viewer Deleted into DB.");
			responseStructure.setData(viewerDao.deleteViewerById(viewerId));
			return new ResponseEntity<ResponseStructure<Viewer>>(responseStructure,HttpStatus.OK);
		} else {
			throw new ViewerIdNotFound();
		}
	}
}
