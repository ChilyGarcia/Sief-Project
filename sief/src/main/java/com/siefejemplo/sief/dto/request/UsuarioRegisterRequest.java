package com.siefejemplo.sief.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UsuarioRegisterRequest {
    private String nombre;
    private String username;
    private String email;
    private String password;

}
