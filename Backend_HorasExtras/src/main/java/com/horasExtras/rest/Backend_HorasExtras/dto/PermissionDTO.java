package com.horasExtras.rest.Backend_HorasExtras.dto;

import com.horasExtras.rest.Backend_HorasExtras.entity.PermissionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionDTO {

    private long id;
    private String name;

    public PermissionEntity toEntity(){
        PermissionEntity e = new PermissionEntity(id, name);
        e.setId(this.getId());
        e.setName(this.getName());
        return e;
    }

}
