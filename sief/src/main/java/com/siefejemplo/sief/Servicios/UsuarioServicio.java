package com.siefejemplo.sief.Servicios;


import com.siefejemplo.sief.dto.request.UsuarioRegisterRequest;
import com.siefejemplo.sief.dto.request.UsuarioRequest;
import com.siefejemplo.sief.dto.response.UsuarioResponse;
import com.siefejemplo.sief.modelos.Rol;

public interface UsuarioServicio {


    public UsuarioResponse registrarUsuario(UsuarioRequest usuarioRequest, Rol rol);
    public UsuarioResponse registrarse(UsuarioRegisterRequest usuarioRegisterRequest, Rol rol);

}
