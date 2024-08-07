package com.horasExtras.rest.Backend_HorasExtras.dto;

import com.horasExtras.rest.Backend_HorasExtras.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    //-----------------------------------------------------------
    private boolean isEnabled;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;
    private Set<RoleDTO> roles;
    private CargoDTO cargo;

    public UserEntity toEntity(){
        UserEntity e = new UserEntity();
        e.setId(this.getId());
        e.setUsername(this.getUsername());
        e.setPassword(this.getPassword());
        e.setEnabled(this.isEnabled);
        e.setAccountNonExpired(this.accountNonExpired);
        e.setCredentialsNonExpired(this.credentialsNonExpired);
        e.setAccountNonLocked(this.accountNonLocked);

        if(this.roles != null) {
            e.setRoles(this.roles.stream()
                    .map(RoleDTO::toEntity)
                    .collect(Collectors.toSet()));
        }

        if(this.cargo != null) {
            e.setCargo(this.cargo.toEntity());
        }

        return e;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isEnabled=" + isEnabled +
                ", accountNonExpired=" + accountNonExpired +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", roles=" + roles +
                ", cargo=" + cargo +
                '}';
    }
}
