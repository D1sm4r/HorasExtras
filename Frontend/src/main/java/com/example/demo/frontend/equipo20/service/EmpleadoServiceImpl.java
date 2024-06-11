package com.example.demo.frontend.equipo20.service;

import com.example.demo.frontend.equipo20.dto.CargoDTO;
import com.example.demo.frontend.equipo20.dto.AdminDTO;
import com.example.demo.frontend.equipo20.dto.EmpleadoDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    // Datos de ejemplo - inicio
    private static List<EmpleadoDTO> empleados = new ArrayList<>(Arrays.asList(
            new EmpleadoDTO(1L, "emp1", "123456", new CargoDTO(1L, "Gerente", "5000"), new AdminDTO(1L, "admin1", "adminpass1")),
            new EmpleadoDTO(2L, "emp2", "abcdef", new CargoDTO(2L, "Analista", "3000"), new AdminDTO(2L, "admin2", "adminpass2")),
            new EmpleadoDTO(3L, "emp3", "qwerty", new CargoDTO(3L, "Desarrollador", "4000"), new AdminDTO(3L, "admin3", "adminpass3"))
    ));
    // Datos de ejemplo - fin

    @Override
    public List<EmpleadoDTO> findAllREST() {
        /*try {
			ObjectMapper unMapper = new ObjectMapper();

			List<EmpleadoDTO> empleados = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/empleado/findAll"), EmpleadoDTO[].class));
			return empleados;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}*/
        // Devuelve la lista de empleados
        return empleados;
    }

    @Override
    public EmpleadoDTO findByIdREST(Long id) {
        /*try {
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
		}*/
        // Busca en la lista de empleados de ejemplo por ID
        return empleados.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public EmpleadoDTO saveREST(EmpleadoDTO empleado) {
        /*try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<EmpleadoDTO> requestEntity = new HttpEntity<>(p, headers);

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
		}*/
        // Agrega el nuevo empleado a la lista
        empleados.add(empleado);
        return empleado;
    }

    @Override
    public EmpleadoDTO deleteREST(Long id) {
        /*try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<EmpleadoDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/empleado/findById/"+ "/" + id, EmpleadoDTO.class);

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
		}*/
        // Busca y elimina el empleado de la lista de ejemplo por ID
        EmpleadoDTO empleado = findByIdREST(id);
        if (empleado != null) {
            empleados.remove(empleado);
        }
        return empleado;
    }
}
