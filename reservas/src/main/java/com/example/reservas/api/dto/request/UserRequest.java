package com.example.reservas.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "El nombre es requerido")
    @Size(min = 4, max = 50, message = "El nombre debe contener entre 4 y 50 caracteres")
    private String name;
    @Email
    private String email;
    @NotBlank(message = "El telefono es requerido")
    private String phone;
}
