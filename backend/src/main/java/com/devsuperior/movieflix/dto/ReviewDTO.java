package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;

public class ReviewDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=5, max=60, message="Review deve ter entre 5 a 60 caracteres")
	@NotBlank(message = "Campo obrigatório")
	private String name;
	
	private MovieDTO movie;
	private UserDTO user;

	public ReviewDTO() {
		
	}

	public ReviewDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public ReviewDTO(Review entity) {
		id = entity.getId();
		name = entity.getName();
	}
	
	public ReviewDTO(Review entity, User user, Movie movie) {
		this(entity);
		this.user = new UserDTO(user.getId(), user.getName(), user.getEmail());
		this.movie = new MovieDTO(movie);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	public MovieDTO getMovie() {
		return movie;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewDTO other = (ReviewDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
