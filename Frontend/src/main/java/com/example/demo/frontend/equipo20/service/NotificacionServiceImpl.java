package com.example.demo.frontend.equipo20.service;

import com.example.demo.frontend.equipo20.dto.NotificacionDTO;
import com.example.demo.frontend.equipo20.dto.EmpleadoDTO;
import com.example.demo.frontend.equipo20.dto.SupervisorDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Service
public class NotificacionServiceImpl implements INotificacionService {

    // Datos de ejemplo - inicio
    private static final List<NotificacionDTO> notificaciones = new ArrayList<>(Arrays.asList(
            new NotificacionDTO(1L, "Mensaje de notificación 1",
                    new EmpleadoDTO(1L, "emp1", "123456", null, null),
                    new SupervisorDTO(1L, "supervisor1", "password1", null)),
            new NotificacionDTO(2L, "Mensaje de notificación 2",
                    new EmpleadoDTO(2L, "emp2", "abcdef", null, null),
                    new SupervisorDTO(2L, "supervisor2", "password2", null))
    ));
    // Datos de ejemplo - fin

    @Override
    public List<NotificacionDTO> findAllREST() {
        /*try {
			ObjectMapper unMapper = new ObjectMapper();

			List<NotificacionDTO> notificaciones = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/notificacion/findAll"), NotificacionDTO[].class));
			return notificaciones;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}*/
        return notificaciones;
    }

    @Override
    public NotificacionDTO findByIdREST(Long id) {
        /*try {
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
		}*/
        return notificaciones.stream()
                .filter(notificacion -> notificacion.getIdNotificacion() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public NotificacionDTO saveREST(NotificacionDTO notificacion) {
        /*try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<NotificacionDTO> requestEntity = new HttpEntity<>(p, headers);

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
		}*/
        notificacion.setIdNotificacion(System.currentTimeMillis()); // Genera un ID único
        notificaciones.add(notificacion); // Agrega la notificación a la lista
        return notificacion;
    }

    @Override
    public NotificacionDTO deleteREST(Long id) {
        /*try {
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
		}*/
        NotificacionDTO notificacionToDelete = findByIdREST(id);
        if (notificacionToDelete != null) {
            notificaciones.remove(notificacionToDelete);
        }
        return notificacionToDelete;
    }
}
