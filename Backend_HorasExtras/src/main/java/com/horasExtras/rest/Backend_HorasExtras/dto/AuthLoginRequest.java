package com.horasExtras.rest.Backend_HorasExtras.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(@NotBlank String username,
                               @NotBlank String password) {

}
