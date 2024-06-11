package com.example.demo.frontend.equipo20.service;

import com.example.demo.frontend.equipo20.dto.CargoDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Service
public class CargoServiceImpl implements ICargoService {

    // Datos de ejemplo - inicio
    private static List<CargoDTO> cargos = new ArrayList<>(Arrays.asList(
            new CargoDTO(1L, "Gerente", "5000"),
            new CargoDTO(2L, "Analista", "3000"),
            new CargoDTO(3L, "Desarrollador", "4000"),
            new CargoDTO(4L, "Diseñador", "3500"),
            new CargoDTO(5L, "Administrativo", "2500")
    ));
    // Datos de ejemplo - fin

    @Override
    public List<CargoDTO> findAllREST() {
        /*try {
			ObjectMapper unMapper = new ObjectMapper();

			List<CargoDTO> cargos = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/cargo/findAll"), CargoDTO[].class));
			return cargos;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}*/
        // Devuelve la lista de cargos
        return cargos;
    }

    @Override
    public CargoDTO findByIdREST(Long id) {
        /*try {
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
		}*/
        // Busca en la lista de cargos de ejemplo por ID
        return cargos.stream()
                .filter(c -> c.getIdCargo() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public CargoDTO saveREST(CargoDTO cargo) {
        /*try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<CargoDTO> requestEntity = new HttpEntity<>(p, headers);

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
		}*/
        // Agrega el nuevo cargo a la lista
        cargos.add(cargo);
        return cargo;
    }

    @Override
    public CargoDTO deleteREST(Long id) {
        /*try {
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
		}*/
        // Busca y elimina el cargo de la lista de ejemplo por ID
        CargoDTO cargo = findByIdREST(id);
        if (cargo != null) {
            cargos.remove(cargo);
        }
        return cargo;
    }
}
