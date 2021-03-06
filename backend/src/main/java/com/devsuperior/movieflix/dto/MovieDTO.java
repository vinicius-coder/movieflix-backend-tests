package com.devsuperior.movieflix.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;

public class MovieDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@Size(min=2, max=60, message="Gênero deve ter entre 2 a 60 caracteres")
	@NotBlank(message="Campo obrigatório")
	private String title;
	
	@Size(min=5, max=60, message="Subtitulo deve ter entre 5 a 60 caracteres")
	@NotBlank(message="Campo obrigatório")
	private String subTitle;
	
	private Integer year;
	
	@Size(min=5, message="Url da imagem deve ter entre 5 a 120 caracteres")
	@NotBlank(message="Campo obrigatório")
	private String imgUrl;
	
	@Size(min=5, message="Gênero deve ter entre 5 a 60 caracteres")
	@NotBlank(message="Campo obrigatório")
	private String synopsis;
	
	private Long genreId;
	
	private List<ReviewDTO> reviews = new ArrayList<>();
	
	public MovieDTO() {
		
	}

	public MovieDTO(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis) {
		super();
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.year = year;
		this.imgUrl = imgUrl;
		this.synopsis = synopsis;
	}
	
	public MovieDTO(Movie entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.subTitle = entity.getSubTitle();
		this.year = entity.getYear();
		this.imgUrl = entity.getImgUrl();
		this.synopsis = entity.getSynopsis();
		this.genreId = entity.getGenre().getId();
	}
	
	public MovieDTO(Movie entity, Set<Review> reviews, Genre genre) {
		this(entity);
		reviews.forEach(rev -> this.reviews.add(new ReviewDTO(rev)));
		this.genreId = genre.getId();
	}
	
	public MovieDTO(Movie entity, Genre genre) {
		this(entity);
		this.genreId = genre.getId();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public List<ReviewDTO> getReviews() {
		return reviews;
	}
	
	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
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
		MovieDTO other = (MovieDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
