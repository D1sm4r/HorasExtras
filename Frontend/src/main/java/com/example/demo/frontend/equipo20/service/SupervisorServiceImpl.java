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

import com.example.demo.frontend.equipo20.dto.SupervisorDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component
@Service
public class SupervisorServiceImpl implements ISupervisorService {


    @Override
    public List<SupervisorDTO> findAllREST() {
        try {
			ObjectMapper unMapper = new ObjectMapper();

			List<SupervisorDTO> supervisores = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/supervisor/findAll"), SupervisorDTO[].class));
			return supervisores;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public SupervisorDTO findByIdREST(Long id) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<SupervisorDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/supervisor/findById" + "/" + id, SupervisorDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				SupervisorDTO dto = responseEntity.getBody();
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
    public SupervisorDTO saveREST(SupervisorDTO supervisor) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<SupervisorDTO> requestEntity = new HttpEntity<>(supervisor, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<SupervisorDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/supervisor/create",
					requestEntity, SupervisorDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				SupervisorDTO dto = responseEntity.getBody();
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
    public SupervisorDTO deleteREST(Long id) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<SupervisorDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/supervisor/findById/"+ "/" + id, SupervisorDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				SupervisorDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/supervisor/delete"+"/" + id);

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
