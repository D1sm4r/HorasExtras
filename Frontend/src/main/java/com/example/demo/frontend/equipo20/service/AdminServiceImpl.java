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

import com.example.demo.frontend.equipo20.dto.AdminDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service
public class AdminServiceImpl implements IAdminService {

    @Override
    public List<AdminDTO> findAllREST() {
        try {
			ObjectMapper unMapper = new ObjectMapper();

			List<AdminDTO> admins = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/admin/findall"), AdminDTO[].class));
			return admins;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public AdminDTO findByIdREST(Long id) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<AdminDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/admin/findById" + "/" + id, AdminDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				AdminDTO dto = responseEntity.getBody();
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
    public AdminDTO saveREST(AdminDTO admin) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<AdminDTO> requestEntity = new HttpEntity<>(admin, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<AdminDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/admin/create",
					requestEntity, AdminDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				AdminDTO dto = responseEntity.getBody();
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
    public AdminDTO deleteREST(Long id) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<AdminDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/admin/findById/"+ "/" + id, AdminDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				AdminDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/admin/delete"+"/" + id);

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
