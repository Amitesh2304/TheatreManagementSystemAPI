package com.project.Theatre_management_System.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_management_System.Dto.Review;
import com.project.Theatre_management_System.Repo.ReviewRepo;

@Repository
public class ReviewDao {

	@Autowired
	ReviewRepo reviewRepo;
	
	public Review saveReview(Review review) {
		return reviewRepo.save(review);	
	}
	
	public Review fetchReviewById(int reviewId) {
		Optional<Review> dbReview =  reviewRepo.findById(reviewId);
		if(dbReview.isPresent()) {
			return dbReview.get();
		}else {
			return null;
		}
	}
	
	public List<Review> fetchAllReview(){
		return reviewRepo.findAll();
	}
	
	public Review updateReviewById(int oldReviewId,Review newReview) {
		newReview.setReviewId(oldReviewId);
		return reviewRepo.save(newReview);
	}
	public Review deleteReviewById(int reviewId) {
		Review review = fetchReviewById(reviewId);
		return review;
	}
}
