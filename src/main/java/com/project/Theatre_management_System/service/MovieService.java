package com.project.Theatre_management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_management_System.Dao.MovieDao;
import com.project.Theatre_management_System.Dao.ReviewDao;
import com.project.Theatre_management_System.Dao.ViewerDao;
import com.project.Theatre_management_System.Dto.Movie;
import com.project.Theatre_management_System.Dto.Review;
import com.project.Theatre_management_System.Dto.Viewer;
import com.project.Theatre_management_System.exception.MovieIdNotFound;
import com.project.Theatre_management_System.exception.ReviewIdNotFound;
import com.project.Theatre_management_System.exception.ViewerIdNotFound;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

@Service
public class MovieService {

	@Autowired
	MovieDao movieDao;

	@Autowired
	ReviewDao reviewDao;

	@Autowired
	ViewerDao viewerDao;

	@Autowired
	ResponseStructure<Movie> responseStructure;

	@Autowired
	ResponseStructure1<Movie> responseStructure1;

	public ResponseEntity<ResponseStructure<Movie>> addNewReviewToExistingMovie(int movieId, Review newReview) {
		Movie movie = movieDao.fetchMovieById(movieId);
		if (movie != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Movie Added from DB.");
			responseStructure.setData(movieDao.addNewReviewToExistingMovie(movieId, newReview));
			return new ResponseEntity<ResponseStructure<Movie>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new MovieIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Movie>> addExistingReviewToExistingMovie(int reviewId, int movieId) {
		Review review = reviewDao.fetchReviewById(reviewId);
		if (review != null) {
			Movie movie = movieDao.fetchMovieById(movieId);
			if (movie != null) {
				responseStructure.setStatusCode(HttpStatus.FOUND.value());
				responseStructure.setMessage("Successfully Movie Added from DB.");
				responseStructure.setData(movieDao.addExistingReviewToExistingMovie(reviewId, movieId));
				return new ResponseEntity<ResponseStructure<Movie>>(responseStructure, HttpStatus.FOUND);
			} else {
				throw new MovieIdNotFound();
			}
		} else {
			throw new ReviewIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Movie>> saveMovie(Movie movie) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Movie Inserted into DB.");
		responseStructure.setData(movieDao.saveMovie(movie));
		return new ResponseEntity<ResponseStructure<Movie>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Movie>> fetchMovieById(int movieId) {
		Movie movie = movieDao.fetchMovieById(movieId);
		if (movie != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Successfully Movie Fetched From DB.");
			responseStructure.setData(movieDao.fetchMovieById(movieId));
			return new ResponseEntity<ResponseStructure<Movie>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new MovieIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Movie>> fetchAllMovie() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully fetched all the Movie from DataBase");
		responseStructure1.setData(movieDao.fetchAllMovie());
		return new ResponseEntity<ResponseStructure1<Movie>>(responseStructure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Movie>> updateMovieById(int oldMovieId, Movie newMovie) {
		Movie movie = movieDao.fetchMovieById(oldMovieId);
		if (movie != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Movie Updated into DB.");
			responseStructure.setData(movieDao.updateMovieById(oldMovieId, newMovie));
			return new ResponseEntity<ResponseStructure<Movie>>(responseStructure, HttpStatus.OK);
		} else {
			throw new MovieIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Movie>> deleteMovieById(int movieId) {
		Movie movie = movieDao.fetchMovieById(movieId);
		if (movie != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Movie Deleted From DB.");
			responseStructure.setData(movieDao.deleteMovieById(movieId));
			return new ResponseEntity<ResponseStructure<Movie>>(responseStructure, HttpStatus.OK);
		} else {
			throw new MovieIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Movie>> addExistingViewerToExistingMovie(int viewerId, int movieId) {
		Viewer viewer = viewerDao.fetchViewerById(viewerId);
		if (viewer != null) {
			Movie movie = movieDao.fetchMovieById(movieId);
			if (movie != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Viewer Added to Movie in database.");
				responseStructure.setData(movieDao.AddExistingViewerToExistingMovie(viewerId, movieId));
				return new ResponseEntity<ResponseStructure<Movie>>(responseStructure, HttpStatus.OK);
			} else {
				throw new MovieIdNotFound();
			}
		} else {
			throw new ViewerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Movie>> addNewViewerToExistingMovie(int movieId, Viewer newViewer) {
		Movie movie = movieDao.fetchMovieById(movieId);
		if (movie != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully New Viewer Added to Movie in database.");
			responseStructure.setData(movieDao.addNewViewerToExistingMovie(movieId, newViewer));
			return new ResponseEntity<ResponseStructure<Movie>>(responseStructure, HttpStatus.OK);
		} else {
			throw new MovieIdNotFound();
		}
	}
}
