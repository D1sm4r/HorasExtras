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

import com.example.demo.frontend.equipo20.dto.NotificacionDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service
public class NotificacionServiceImpl implements INotificacionService {


    @Override
    public List<NotificacionDTO> findAllREST() {
        try {
			ObjectMapper unMapper = new ObjectMapper();

			List<NotificacionDTO> notificaciones = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/notificacion/findAll"), NotificacionDTO[].class));
			return notificaciones;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public NotificacionDTO findByIdREST(Long id) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<NotificacionDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/notificacion/findById" + "/" + id, NotificacionDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				NotificacionDTO dto = responseEntity.getBody();
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
    public NotificacionDTO saveREST(NotificacionDTO notificacion) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<NotificacionDTO> requestEntity = new HttpEntity<>(notificacion, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<NotificacionDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/notificacion/create",
					requestEntity, NotificacionDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				NotificacionDTO dto = responseEntity.getBody();
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
    public NotificacionDTO deleteREST(Long id) {
        try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<NotificacionDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/notificacion/findById/"+ "/" + id, NotificacionDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				NotificacionDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/notificacion/delete"+"/" + id);

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
