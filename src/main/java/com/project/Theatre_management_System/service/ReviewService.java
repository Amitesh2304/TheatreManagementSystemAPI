package com.project.Theatre_management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_management_System.Dao.ReviewDao;
import com.project.Theatre_management_System.Dto.Review;
import com.project.Theatre_management_System.exception.ReviewIdNotFound;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

@Service
public class ReviewService {

	@Autowired
	ReviewDao reviewDao;

	@Autowired
	ResponseStructure<Review> responseStructure;

	@Autowired
	ResponseStructure1<Review> responseStructure1;

	public ResponseEntity<ResponseStructure<Review>> saveReview(Review review) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Review Inserted into DB.");
		responseStructure.setData(reviewDao.saveReview(review));
		return new ResponseEntity<ResponseStructure<Review>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Review>> fetchReviewById(int reviewId) {
		Review review = reviewDao.fetchReviewById(reviewId);
		if (review != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Review Fetched From DB.");
			responseStructure.setData(reviewDao.fetchReviewById(reviewId));
			return new ResponseEntity<ResponseStructure<Review>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new ReviewIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Review>> fetchAllReview() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully fetched all the Review from DataBase");
		responseStructure1.setData(reviewDao.fetchAllReview());
		return new ResponseEntity<ResponseStructure1<Review>>(responseStructure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Review>> updateReviewById(int oldReviewId, Review newReview) {
		Review review = reviewDao.fetchReviewById(oldReviewId);
		if (review != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Review Updated into DB.");
			responseStructure.setData(reviewDao.updateReviewById(oldReviewId, newReview));
			return new ResponseEntity<ResponseStructure<Review>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ReviewIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Review>> deleteReviewById(int reviewId) {
		Review review = reviewDao.fetchReviewById(reviewId);
		if (review != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Review Deleted From DB.");
			responseStructure.setData(reviewDao.deleteReviewById(reviewId));
			return new ResponseEntity<ResponseStructure<Review>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ReviewIdNotFound();
		}
	}
}
