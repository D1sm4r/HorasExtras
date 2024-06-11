package com.example.demo.frontend.equipo20.service;

import com.example.demo.frontend.equipo20.dto.ProyectoDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Service
public class ProyectoServiceImpl implements IProyectoService {

    // Datos de ejemplo - inicio
    private static final List<ProyectoDTO> proyectos = new ArrayList<>(Arrays.asList(
            new ProyectoDTO(1L, "Proyecto A"),
            new ProyectoDTO(2L, "Proyecto B"),
            new ProyectoDTO(3L, "Proyecto C"),
            new ProyectoDTO(4L, "Proyecto D"),
            new ProyectoDTO(5L, "Proyecto E")
    ));
    // Datos de ejemplo - fin

    @Override
    public List<ProyectoDTO> findAllREST() {
        /*try {
			ObjectMapper unMapper = new ObjectMapper();

			List<ProyectoDTO> proyectos = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/proyecto/findAll"), ProyectoDTO[].class));
			return proyectos;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}*/
        return proyectos;
    }

    @Override
    public ProyectoDTO findByIdREST(Long id) {
        /*try {
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
		}*/
        return proyectos.stream()
                .filter(proyecto -> proyecto.getIdProyecto() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public ProyectoDTO saveREST(ProyectoDTO proyecto) {
        /*try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<ProyectoDTO> requestEntity = new HttpEntity<>(p, headers);

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
		}*/
        proyecto.setIdProyecto(System.currentTimeMillis()); // Genera un ID único
        proyectos.add(proyecto); // Agrega el proyecto a la lista
        return proyecto;
    }

    @Override
    public ProyectoDTO deleteREST(Long id) {
        /*try {
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
		}*/
        ProyectoDTO proyectoToDelete = findByIdREST(id);
        if (proyectoToDelete != null) {
            proyectos.remove(proyectoToDelete);
        }
        return proyectoToDelete;
    }
}
