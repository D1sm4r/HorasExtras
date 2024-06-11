package com.example.demo.frontend.equipo20.service;

import com.example.demo.frontend.equipo20.dto.AdminDTO;
import com.example.demo.frontend.equipo20.dto.SupervisorDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Service
public class SupervisorServiceImpl implements ISupervisorService {

    // Datos de ejemplo - inicio
    private static final List<SupervisorDTO> supervisores = new ArrayList<>(Arrays.asList(
            new SupervisorDTO(1L, "supervisor1", "123456", new AdminDTO(1L, "admin1", "password1")),
            new SupervisorDTO(2L, "supervisor2", "abcdef", new AdminDTO(2L, "admin2", "password2")),
            new SupervisorDTO(3L, "supervisor3", "password3", new AdminDTO(3L, "admin3", "password3"))
    ));
    // Datos de ejemplo - fin

    @Override
    public List<SupervisorDTO> findAllREST() {
        /*try {
			ObjectMapper unMapper = new ObjectMapper();

			List<SupervisorDTO> supervisores = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/supervisor/findAll"), SupervisorDTO[].class));
			return supervisores;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}*/
        return supervisores;
    }

    @Override
    public SupervisorDTO findByIdREST(Long id) {
        /*try {
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
		}*/
        return supervisores.stream()
                .filter(supervisor -> supervisor.getIdSupervisor() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public SupervisorDTO saveREST(SupervisorDTO supervisor) {
        /*try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<SupervisorDTO> requestEntity = new HttpEntity<>(p, headers);

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
		}*/
        supervisor.setIdSupervisor(System.currentTimeMillis()); // Genera un ID único
        supervisores.add(supervisor); // Agrega el supervisor a la lista
        return supervisor;
    }

    @Override
    public SupervisorDTO deleteREST(Long id) {
        /*try {
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
		}*/
        SupervisorDTO supervisorToDelete = findByIdREST(id);
        if (supervisorToDelete != null) {
            supervisores.remove(supervisorToDelete);
        }
        return supervisorToDelete;
    }
}
