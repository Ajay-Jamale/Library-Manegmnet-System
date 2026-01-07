package com.ajay.payload.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreDTO {
	
	private Long id;
	
	@NotBlank(message = "Genre code is mandatory")
	@Column(unique = true, nullable = false)
	private String code;

	@NotBlank(message = "Genre name is mandatory")
	@Column(nullable = false)
	private String name;

	@Size(max = 500)
	private String description;

	@Min(0)
	private Integer displayOrder = 0;

	@Column(nullable = false)
	private Boolean active = true;
	
	private Long parentGenreId;
	
	private String parentGenreName;
	
	private List<GenreDTO> subGenre;
	
	private Long bookCount;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
}
