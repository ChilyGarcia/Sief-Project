package com.siefejemplo.sief.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {

    private Long id;
    private String nombre;
    private String username;
    private String email;
    private String roleUser;
    private String passwordEncriptada;

    private String password;


}
