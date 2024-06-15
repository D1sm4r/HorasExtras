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

import com.example.demo.frontend.equipo20.dto.HorasExtrasDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service
public class HorasExtrasServiceImpl implements IHorasExtrasService {

    @Override
    public List<HorasExtrasDTO> findAllREST() {
        try {
			ObjectMapper unMapper = new ObjectMapper();

			List<HorasExtrasDTO> listahoras = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/horasextras/findall"), HorasExtrasDTO[].class));
			return listahoras;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public HorasExtrasDTO findByIdREST(Long id) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<HorasExtrasDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/horasextras/findById" + "/" + id, HorasExtrasDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				HorasExtrasDTO dto = responseEntity.getBody();
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
    public HorasExtrasDTO saveREST(HorasExtrasDTO he) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<HorasExtrasDTO> requestEntity = new HttpEntity<>(he, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<HorasExtrasDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/horasextras/create",
					requestEntity, HorasExtrasDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				HorasExtrasDTO dto = responseEntity.getBody();
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
    public HorasExtrasDTO deleteREST(Long id) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<HorasExtrasDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/horasextras/findById/"+ "/" + id, HorasExtrasDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				HorasExtrasDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/horasextras/delete"+"/" + id);

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
