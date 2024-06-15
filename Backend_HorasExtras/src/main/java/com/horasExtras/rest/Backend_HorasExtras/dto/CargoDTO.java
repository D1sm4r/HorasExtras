package com.horasExtras.rest.Backend_HorasExtras.dto;


import com.horasExtras.rest.Backend_HorasExtras.entity.Cargo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoDTO {

    private long idCargo;

    private String name;

    private String saldo;

    //------------------------------------------------------------

    public Cargo toEntity(){
        Cargo e = new Cargo(idCargo, name, saldo);
        e.setIdCargo(this.getIdCargo());
        e.setSaldo(this.getSaldo());
        e.setName(this.getName());
        return e;
    }

}
