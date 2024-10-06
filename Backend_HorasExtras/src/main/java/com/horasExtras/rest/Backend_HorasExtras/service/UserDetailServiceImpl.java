package com.horasExtras.rest.Backend_HorasExtras.service;

import com.horasExtras.rest.Backend_HorasExtras.entity.UserEntity;
import com.horasExtras.rest.Backend_HorasExtras.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    //este metodo accede y busca en mi base de datos los usuarios
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity  = userRepository.findUserEntityByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario" + username + "no existe."));

        //segundo SpringSecurity entiende mediante SimpleGrantedAuthority
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        //Primero se agarran los roles del usuario con estos metodos, para convertilos en objetos que entienda SpringSecurity
        userEntity.getRoles()
                .forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));

        //Tercero estamos agarrando los permisos y agregandoselos a SpringSecurity para que los tenga
        userEntity.getRoles().stream()
                .flatMap(role -> role.getPermissionList().stream())
                .forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getName())));

        return new User(userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.isEnabled(),
                userEntity.isAccountNonExpired(),
                userEntity.isCredentialsNonExpired(),
                userEntity.isAccountNonLocked(),
                authorityList);
    }
}
