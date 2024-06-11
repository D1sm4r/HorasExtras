package com.example.demo.frontend.equipo20.service;

import com.example.demo.frontend.equipo20.dto.AdminDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Service
public class AdminServiceImpl implements IAdminService {

    // Datos de ejemplo - inicio
    private static List<AdminDTO> admins = new ArrayList<>(Arrays.asList(
            new AdminDTO(1L, "admin1", "contraseña1"),
            new AdminDTO(2L, "admin2", "contraseña2"),
            new AdminDTO(3L, "admin3", "contraseña3"),
            new AdminDTO(4L, "admin4", "contraseña4"),
            new AdminDTO(5L, "admin5", "contraseña5")
    ));
    // Datos de ejemplo - fin

    @Override
    public List<AdminDTO> findAllREST() {
        /*try {
			ObjectMapper unMapper = new ObjectMapper();

			List<AdminDTO> admins = Arrays
					.asList(unMapper.readValue(new URL("http://localhost:8080/admin/findAll"), AdminDTO[].class));
			return admins;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}*/
        // Devuelve la lista de admins
        return admins;
    }

    @Override
    public AdminDTO findByIdREST(Long id) {
        /*try {
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
		}*/
        // Busca en la lista de admins de ejemplo por ID
        return admins.stream()
                .filter(a -> a.getIdAdmin() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public AdminDTO saveREST(AdminDTO admin) {
        /*try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<AdminDTO> requestEntity = new HttpEntity<>(p, headers);

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
		}*/
        // Agrega el nuevo admin a la lista
        admins.add(admin);
        return admin;
    }

    @Override
    public AdminDTO deleteREST(Long id) {
        /*try {
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
		}*/
        // Busca y elimina el admin de la lista de ejemplo por ID
        AdminDTO admin = findByIdREST(id);
        if (admin != null) {
            admins.remove(admin);
        }
        return admin;
    }
}
