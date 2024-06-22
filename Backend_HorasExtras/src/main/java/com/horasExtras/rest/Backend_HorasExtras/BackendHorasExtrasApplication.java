package com.horasExtras.rest.Backend_HorasExtras;

import com.horasExtras.rest.Backend_HorasExtras.entity.*;
import com.horasExtras.rest.Backend_HorasExtras.repository.CargoRepository;
import com.horasExtras.rest.Backend_HorasExtras.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class BackendHorasExtrasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendHorasExtrasApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository, CargoRepository cargoRepository) {
		return args -> {
			//Create permission
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

			PermissionEntity refactorPermission = PermissionEntity.builder()
					.name("REFACTOR")
					.build();

			//create role
			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission)) // le asignamos los permisos a los roles
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.EMPLEADO)
					.permissionList(Set.of(createPermission, readPermission)) // le asignamos los permisos a los roles
					.build();

			RoleEntity roleInvted = RoleEntity.builder()
					.roleEnum(RoleEnum.SUPERVISOR)
					.permissionList(Set.of(readPermission)) // le asignamos los permisos a los roles
					.build();

			RoleEntity roleDeveloper = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission)) // le asignamos los permisos a los roles
					.build();

			//create Users

			UserEntity userJavier = UserEntity.builder()
					.username("javier")
					.password("$2a$10$QtWqYmyxZJYZMr5knDHNoePUqPZ42z6ChipQyhTa4/hF5/FRrqDQG")
					.isEnabled(true)
					.accountNonExpired(true)//la cuenta esta activa osea no esta expirada
					.accountNonLocked(true)//la cuanta no esta bloqueada
					.credentialsNonExpired(true)//las credenciales no esta expirada
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity userDismar = UserEntity.builder()
					.username("dismar")
					.password("$2a$10$QtWqYmyxZJYZMr5knDHNoePUqPZ42z6ChipQyhTa4/hF5/FRrqDQG")
					.isEnabled(true)
					.accountNonExpired(true)//la cuenta esta activa osea no esta expirada
					.accountNonLocked(true)//la cuanta no esta bloqueada
					.credentialsNonExpired(true)//las credenciales no esta expirada
					.roles(Set.of(roleUser))
					.build();

			UserEntity userMati = UserEntity.builder()
					.username("mati")
					.password("$2a$10$QtWqYmyxZJYZMr5knDHNoePUqPZ42z6ChipQyhTa4/hF5/FRrqDQG")
					.isEnabled(true)
					.accountNonExpired(true)//la cuenta esta activa osea no esta expirada
					.accountNonLocked(true)//la cuanta no esta bloqueada
					.credentialsNonExpired(true)//las credenciales no esta expirada
					.roles(Set.of(roleInvted))
					.build();

			UserEntity userDamian = UserEntity.builder()
					.username("damian")
					.password("$2a$10$QtWqYmyxZJYZMr5knDHNoePUqPZ42z6ChipQyhTa4/hF5/FRrqDQG")
					.isEnabled(true)
					.accountNonExpired(true)//la cuenta esta activa osea no esta expirada
					.accountNonLocked(true)//la cuanta no esta bloqueada
					.credentialsNonExpired(true)//las credenciales no esta expirada
					.roles(Set.of(roleDeveloper))
					.build();

			userRepository.saveAll(List.of(userJavier, userDismar, userMati, userDamian));
		};
	}
}
