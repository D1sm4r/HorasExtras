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

import com.example.demo.frontend.equipo20.dto.EmpleadoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Override
    public List<EmpleadoDTO> findAllREST() {
        try {
			ObjectMapper unMapper = new ObjectMapper();

			List<EmpleadoDTO> empleados = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/empleado/findall"), EmpleadoDTO[].class));
			return empleados;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public EmpleadoDTO findByIdREST(Long id) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<EmpleadoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/empleado/findById" + "/" + id, EmpleadoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				EmpleadoDTO dto = responseEntity.getBody();
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
    public EmpleadoDTO saveREST(EmpleadoDTO empleado) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<EmpleadoDTO> requestEntity = new HttpEntity<>(empleado, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<EmpleadoDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/empleado/create",
					requestEntity, EmpleadoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				EmpleadoDTO dto = responseEntity.getBody();
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
    public EmpleadoDTO deleteREST(Long id) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<EmpleadoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/empleado/findById"+ "/" + id, EmpleadoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				EmpleadoDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/empleado/delete"+"/" + id);

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
