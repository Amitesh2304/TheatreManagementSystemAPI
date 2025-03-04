package com.project.Theatre_management_System.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_management_System.Dto.Food;
import com.project.Theatre_management_System.Dto.Ticket;
import com.project.Theatre_management_System.Dto.Viewer;
import com.project.Theatre_management_System.Repo.ViewerRepo;

@Repository
public class ViewerDao {

	@Autowired
	ViewerRepo viewerRepo;
	
	@Autowired
	FoodDao foodDao;
	
	@Autowired
	TicketDao ticketDao;
	
	
	
	//one to many mapping
		
	
	public Viewer addNewTicketToExistingViewer( int viewerId, Ticket newTicket) {
		Viewer viewer = fetchViewerById(viewerId);
		List<Ticket> list = viewer.getTicket();
		list.add(newTicket);
		viewer.setTicket(list);
		return saveViewer(viewer);
	}
	
	public Viewer addExistingTicketToExistingViewer(int ticketId, int viewerId) {
		Ticket ticket = ticketDao.fetchTicketById(ticketId);
		Viewer viewer = fetchViewerById(viewerId);
		List<Ticket> list = viewer.getTicket();
		list.add(ticket);
		viewer.setTicket(list);
		return saveViewer(viewer);
	}
	
	//one to many mapping
	public Viewer addNewFoodToExistingViewer( int viewerId, Food newFood) {
		Viewer viewer = fetchViewerById(viewerId);
		List<Food> list = viewer.getFood();
		list.add(newFood);
		viewer.setFood(list);
		return saveViewer(viewer);
	}
	
	public Viewer addExistingFoodToExistingViewer(int foodId, int viewerId) {
		Food food = foodDao.fetchFoodById(foodId);
		Viewer viewer = fetchViewerById(viewerId);
		List<Food> list = viewer.getFood();
		list.add(food);
		viewer.setFood(list);
		return saveViewer(viewer);
	}
	
	public Viewer saveViewer(Viewer viewer) {
		return viewerRepo.save(viewer);	
	}
	
	public Viewer fetchViewerById(int viewerId) {
		Optional<Viewer> dbViewer = viewerRepo.findById(viewerId);
		if(dbViewer.isPresent()) {
			return dbViewer.get();
		}else {
			return null;
		}
	}
	
	public List<Viewer> fetchAllViewer(){
		return viewerRepo.findAll();
	}
	
	public Viewer updateViewerById(int oldViewerId,Viewer newViewer) {
		newViewer.setViewerId(oldViewerId);
		return viewerRepo.save(newViewer);
	}
	public Viewer deleteViewerById(int viewerId) {
		Viewer viewer = fetchViewerById(viewerId);
		return viewer;
	}
}
