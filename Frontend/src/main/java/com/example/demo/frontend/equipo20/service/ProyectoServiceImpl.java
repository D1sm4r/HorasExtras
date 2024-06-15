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

import com.example.demo.frontend.equipo20.dto.ProyectoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component
@Service
public class ProyectoServiceImpl implements IProyectoService {


    @Override
    public List<ProyectoDTO> findAllREST() {
        try {
			ObjectMapper unMapper = new ObjectMapper();

			List<ProyectoDTO> proyectos = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/proyecto/findAll"), ProyectoDTO[].class));
			return proyectos;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public ProyectoDTO findByIdREST(Long id) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<ProyectoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/proyecto/findById" + "/" + id, ProyectoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				ProyectoDTO dto = responseEntity.getBody();
				return dto;
			} else {
				System.out.println("A ocurrido un error");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public ProyectoDTO saveREST(ProyectoDTO proyecto) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<ProyectoDTO> requestEntity = new HttpEntity<>(proyecto, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<ProyectoDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/proyecto/create",
					requestEntity, ProyectoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				ProyectoDTO dto = responseEntity.getBody();
				return dto;
			} else {
				System.out.println("A ocurrido un error");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public ProyectoDTO deleteREST(Long id) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<ProyectoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/proyecto/findById/"+ "/" + id, ProyectoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				ProyectoDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/proyecto/delete"+"/" + id);

				return dto;
			} else {
				System.out.println("A ocurrido un error");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
}
