package com.example.demo.frontend.equipo20.dto;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonaDTO {

	//@NotNull
	private Long id;
	
	@NotBlank
	private String nombre;
	
	private String alias;
	
	private String descripcion;
	
	private int orden;

}
