package com.example.demo.frontend.equipo20.service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.frontend.equipo20.dto.PersonaDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service
public class PersonaServiceImpl implements IPersonaService {

	// Datos de ejemplo - inicio
	private static List<PersonaDTO> personas = new ArrayList<>(Arrays.asList(
			new PersonaDTO(1L, "John Doe", "JD", "Un ejemplo de persona", 1),
			new PersonaDTO(2L, "Jane Doe", "Jane", "Otra persona de ejemplo", 2),
			new PersonaDTO(3L, "Jim Beam", "JB", "Persona de ejemplo tres", 3),
			new PersonaDTO(4L, "Jack Daniels", "JD", "Persona de ejemplo cuatro", 4),
			new PersonaDTO(5L, "Johnny Walker", "JW", "Persona de ejemplo cinco", 5),
			new PersonaDTO(6L, "José Cuervo", "JC", "Persona de ejemplo seis", 6),
			new PersonaDTO(7L, "Jameson Irish", "JI", "Persona de ejemplo siete", 7),
			new PersonaDTO(8L, "Jägermeister", "Jä", "Persona de ejemplo ocho", 8),
			new PersonaDTO(9L, "Jim Halpert", "Jim", "Persona de ejemplo nueve", 9),
			new PersonaDTO(10L, "Pam Beesly", "Pam", "Persona de ejemplo diez", 10)
	));
	// Datos de ejemplo - fin

	@Override
	public List<PersonaDTO> findAllREST() {
		/*try {
			ObjectMapper unMapper = new ObjectMapper();

			List<PersonaDTO> personas = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/api/bff/persona/findAll"), PersonaDTO[].class));
			return personas;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}*/
		return personas;
	}

	@Override
	public PersonaDTO findByIdREST(Long id) {
		/*try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<PersonaDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/api/bff/persona/findById" + "/" + id, PersonaDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				PersonaDTO dto = responseEntity.getBody();
				return dto;
			} else {
				System.out.println("A ocurrido un error");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}*/
		// Busca en la lista de personas de ejemplo por ID
		return personas.stream()
				.filter(p -> p.getId().equals(id))
				.findFirst()
				.orElse(null);
	}

	@Override
	public PersonaDTO saveREST(PersonaDTO p) {
		/*try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<PersonaDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<PersonaDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/api/bff/persona/create",
					requestEntity, PersonaDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				PersonaDTO dto = responseEntity.getBody();
				return dto;
			} else {
				System.out.println("A ocurrido un error");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}*/
		personas.add(p);
		return p;
	}

	@Override
	public PersonaDTO deleteREST(Long id) {
		/*try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<PersonaDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/api/bff/persona/findById/"+ "/" + id, PersonaDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				PersonaDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/api/bff/persona/delete"+"/" + id);

				return dto;
			} else {
				System.out.println("A ocurrido un error");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}*/
		// Busca y elimina la persona de la lista de ejemplo por ID
		PersonaDTO persona = findByIdREST(id);
		if (persona != null) {
			personas.remove(persona);
		}
		return persona;
	}

}