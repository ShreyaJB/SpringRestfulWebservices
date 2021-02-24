package com.cognizant.moviecuriser.service;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.moviecuriser.MoviecuriserApplication;
import com.cognizant.moviecuriser.model.Favorities;
import com.cognizant.moviecuriser.model.Movie;
import com.cognizant.moviecuriser.repository.FaviorateRepository;
import com.cognizant.moviecuriser.repository.MovieRepository;
import com.cognizant.moviecuriser.repository.UserRepository;
import com.cognizant.moviecuriser.service.exception.MovieNotFoundException;


import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Danish
 *
 */
@Service
@Slf4j
public class MovieService {

	/**
	 * log
	 */
	//private static final log log = logFactory.getlog(MoviecuriserApplication.class);
	
	
	/**
	 * All repositories autowired
	 */
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FaviorateRepository faviorateRepository;
	
	
	/**
	 * Gets the list of movies for admin
	 * @return
	 */
	public List<Movie> getMoviesListAdmin(){
		log.info("Start");
		return movieRepository.findAll();
	}
	
	public Movie getByMovieId(int id) {
		log.info("Start");
		return movieRepository.getOne(id);
	}
	
	@Transactional
	public boolean saveToFaviorate(Movie movie)
	{
		
		log.info("Start");
		Favorities favorities = new Favorities();
		favorities.setMovie(movie);
		favorities.setUser(userRepository.getOne(1));
		log.info("End");
		if(faviorateRepository.save(favorities)==null)
			return false;
		return true;
	}
	public List<Movie> getMoviesListCustomer() {
		
		// TODO Auto-generated method stub
		log.info("Start");
		return movieRepository.findCustomerMovies();
	}
	
	public List<Movie> getFaviorateMovies(int userId) throws MovieNotFoundException {
		log.info("Start");
		List<Movie> movies = new ArrayList<>();
		faviorateRepository.getFaviorateMovies(userId).stream().forEach(id -> movies.add(movieRepository.getOne(id)));
		log.info("End");
		if(movies.isEmpty())
			throw new MovieNotFoundException();
		return movies;
	}
	
	@Transactional
	public void deleteFaviorate(Integer movie_id)
	{
		
		faviorateRepository.deleteFromFaviorate(1, movie_id);
		
	}
	@Transactional
	public void editMenuItem(Movie menuItem) {
		log.info("Start");
		Movie menu=movieRepository.getOne(menuItem.getId());
		menu.setId(menuItem.getId());
		menu.setTitle(menuItem.getTitle());
		menu.setBoxOffice(menuItem.getBoxOffice());
		menu.setActive(menuItem.isActive());
		menu.setDateOfLaunch(menuItem.getDateOfLaunch());
		menu.setHasTeaser(menuItem.isHasTeaser());
		menu.setGenre(menuItem.getGenre());
		movieRepository.save(menu);
		log.info("End");

	}
	
}
