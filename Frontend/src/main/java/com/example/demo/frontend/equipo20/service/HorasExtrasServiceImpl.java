package com.example.demo.frontend.equipo20.service;

import com.example.demo.frontend.equipo20.dto.HorasExtrasDTO;
import com.example.demo.frontend.equipo20.dto.EmpleadoDTO;
import com.example.demo.frontend.equipo20.dto.ProyectoDTO;
import com.example.demo.frontend.equipo20.dto.SupervisorDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
@Service
public class HorasExtrasServiceImpl implements IHorasExtrasService {

    // Datos de ejemplo - inicio
    private static final List<HorasExtrasDTO> horasExtrasList = new ArrayList<>(Arrays.asList(
            new HorasExtrasDTO(1L, 5, new Date(), new Date(), "Trabajo adicional", true,
                    new EmpleadoDTO(1L, "emp1", "123456", null, null),
                    new ProyectoDTO(1L, "Proyecto 1"),
                    new SupervisorDTO()),
            new HorasExtrasDTO(2L, 8, new Date(), new Date(), "Actividad urgente", true,
                    new EmpleadoDTO(2L, "emp2", "abcdef", null, null),
                    new ProyectoDTO(2L, "Proyecto 2"),
                    new SupervisorDTO())
    ));
    // Datos de ejemplo - fin

    @Override
    public List<HorasExtrasDTO> findAllREST() {
        /*try {
			ObjectMapper unMapper = new ObjectMapper();

			List<HorasExtrasDTO> listahoras = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/horaextra/findAll"), HorasExtrasDTO[].class));
			return listahoras;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}*/
        return horasExtrasList;
    }

    @Override
    public HorasExtrasDTO findByIdREST(Long id) {
        /*try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<HorasExtrasDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/horaextra/findById" + "/" + id, HorasExtrasDTO.class);

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
		}*/
        return horasExtrasList.stream()
                .filter(he -> he.getIdHorasExtras() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public HorasExtrasDTO saveREST(HorasExtrasDTO he) {
        /*try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<HorasExtrasDTO> requestEntity = new HttpEntity<>(p, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<HorasExtrasDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/horaextra/create",
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
		}*/
        long newId = System.currentTimeMillis(); // Genera un nuevo ID único
        he.setIdHorasExtras(newId);
        horasExtrasList.add(he); // Agrega las horas extras a la lista
        return he;
    }

    @Override
    public HorasExtrasDTO deleteREST(Long id) {
        /*try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<HorasExtrasDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8080/horaextra/findById/"+ "/" + id, HorasExtrasDTO.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				HorasExtrasDTO dto = responseEntity.getBody();

				restTemplate.delete("http://localhost:8080/horaextra/delete"+"/" + id);

				return dto;
			} else {
				System.out.println("A ocurrido un error");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}*/
        boolean removed = horasExtrasList.removeIf(he -> he.getIdHorasExtras() == id);
        return removed ? new HorasExtrasDTO() : null;
    }
}
