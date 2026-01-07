package com.ajay.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	/* ---------- SELF RELATION ---------- */

	@ManyToOne
	@JsonIgnoreProperties("subGenra")
	private Genre parentGenra;

	@OneToMany(mappedBy = "parentGenra", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("parentGenra")
	private List<Genre> subGenra = new ArrayList<>();

	/* ---------- AUDIT ---------- */

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
