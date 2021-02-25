package com.devsuperior.movieflix.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.DatabaseException;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	@Autowired
	private GenreRepository genreRepository;

	@Transactional(readOnly = true)
	public Page<MovieDTO> findAllPaged(PageRequest pageRequest, String title, Long genreId) {
		List<Genre> genres = (genreId == 0) ? null : Arrays.asList(genreRepository.getOne(genreId));
		Page<Movie> list = repository.findAllPaged(genres, title, pageRequest);
		return list.map(x -> new MovieDTO(x, x.getGenre()));
	}

	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Optional<Movie> obj = repository.findById(id);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new MovieDTO(entity, entity.getReviews(), entity.getGenre());
	}

	@Transactional
	public MovieDTO insert(MovieDTO dto) {
		Movie entity = new Movie();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new MovieDTO(entity, entity.getGenre());
	}

	// Ajustar metodo
	@Transactional
	public MovieDTO update(Long id, MovieDTO dto) {

		try {
			Movie entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			return new MovieDTO(entity, entity.getGenre());
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}

	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

	private void copyDtoToEntity(MovieDTO dto, Movie entity) {
		entity.setTitle(dto.getTitle());
		entity.setSubTitle(dto.getSubTitle());
		entity.setYear(dto.getYear());
		entity.setImgUrl(dto.getImgUrl());
		entity.setSynopsis(dto.getSynopsis());
		
		Genre genre = genreRepository.getOne(dto.getGenreId());
		entity.setGenre(genre);
	}

}
