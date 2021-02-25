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
	
	@Size(min=2, max=100, message="Review deve ter entre 2 a 100 caracteres")
	@NotBlank(message = "Campo obrigatório")
	private String text;
	
	private Long movieId;
	private UserDTO user;

	public ReviewDTO() {
		
	}

	public ReviewDTO(Long id, String text) {
		this.id = id;
		this.text = text;
	}
	
	public ReviewDTO(Review entity) {
		id = entity.getId();
		text = entity.getText();
		movieId = entity.getMovie().getId();
		user = new UserDTO(entity.getUser().getId(), entity.getUser().getName(), entity.getUser().getEmail());
	}
	
	public ReviewDTO(Review entity, User user, Movie movie) {
		this(entity);
		this.user = new UserDTO(user.getId(), user.getName(), user.getEmail());
		this.movieId = movie.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	public Long getMovieId() {
		return movieId;
	}
	
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
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
