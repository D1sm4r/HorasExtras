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

import com.example.demo.frontend.equipo20.dto.CargoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service
public class CargoServiceImpl implements ICargoService {

    @Override
    public List<CargoDTO> findAllREST() {
        try {
			ObjectMapper unMapper = new ObjectMapper();

			List<CargoDTO> cargos = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/cargo/findAll"), CargoDTO[].class));
			return cargos;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public CargoDTO findByIdREST(Long id) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<CargoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/cargo/findById" + "/" + id, CargoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				CargoDTO dto = responseEntity.getBody();
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
    public CargoDTO saveREST(CargoDTO cargo) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<CargoDTO> requestEntity = new HttpEntity<>(cargo, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<CargoDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/cargo/create",
					requestEntity, CargoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				CargoDTO dto = responseEntity.getBody();
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
    public CargoDTO deleteREST(Long id) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<CargoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/cargo/findById/"+ "/" + id, CargoDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				CargoDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/cargo/delete"+"/" + id);

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
