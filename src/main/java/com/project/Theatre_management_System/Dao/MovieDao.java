package com.project.Theatre_management_System.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_management_System.Dto.Movie;
import com.project.Theatre_management_System.Dto.Review;
import com.project.Theatre_management_System.Dto.Viewer;
import com.project.Theatre_management_System.Repo.MovieRepo;

@Repository
public class MovieDao {

	@Autowired
	ReviewDao reviewDao;
	
	@Autowired
	MovieRepo movieRepo;
	
	@Autowired
	ViewerDao viewerDao;
	
	//one to many mapping
		public Movie addNewReviewToExistingMovie( int movieId, Review newReview) {
			Movie movie = fetchMovieById(movieId);
			List<Review> list = movie.getReview();
			list.add(newReview);
			movie.setReview(list);
			return saveMovie(movie);
		}
		
		public Movie addExistingReviewToExistingMovie(int reviewId, int movieId) {
			Review review = reviewDao.fetchReviewById(reviewId);
			Movie movie = fetchMovieById(movieId);
			List<Review> list = movie.getReview();
			list.add(review);
			movie.setReview(list);;
			return saveMovie(movie);
		}
		
		public Movie addNewViewerToExistingMovie( int movieId, Viewer newViewer) {
			Movie movie = fetchMovieById(movieId);
			List<Viewer> list = movie.getViewer();
			list.add(newViewer);
			movie.setViewer(list);
			return saveMovie(movie);
		}
		
		public Movie AddExistingViewerToExistingMovie( int MovieId, int viewerId) {
			Viewer viewer = viewerDao.fetchViewerById(viewerId); 
			Movie movie = fetchMovieById(MovieId);
			List<Viewer> list = movie.getViewer();
			list.add(viewer);
			movie.setViewer(list);
			return saveMovie(movie);
		}
	
	public Movie saveMovie(Movie movie) {
		return movieRepo.save(movie);	
	}
	
	public Movie fetchMovieById(int movieId) {
		Optional<Movie> dbMovie = movieRepo.findById(movieId);
		if(dbMovie.isPresent()) {
			return dbMovie.get();
		}else {
			return null;
		}
	}
	
	public List<Movie> fetchAllMovie(){
		return movieRepo.findAll();
	}
	
	public Movie updateMovieById(int oldMovieId,Movie newMovie) {
		newMovie.setMovieId(oldMovieId);
		return movieRepo.save(newMovie);
	}
	public Movie deleteMovieById(int movieId) {
		Movie movie = fetchMovieById(movieId);
		return movie;
	}
}
