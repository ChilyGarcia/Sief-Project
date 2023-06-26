package com.siefejemplo.sief.Controlador;

import com.siefejemplo.sief.Servicios.implementaciones.UsuarioServiceImpl;
import com.siefejemplo.sief.dto.request.UsuarioRegisterRequest;
import com.siefejemplo.sief.dto.request.UsuarioRequest;
import com.siefejemplo.sief.dto.response.UsuarioResponse;
import com.siefejemplo.sief.modelos.Rol;
import com.siefejemplo.sief.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import org.modelmapper.ModelMapper;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "api")
public class UsuarioControlador {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hola")
    public String holaMundo() {
        return "Hola mundo";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/adios")
    public String adios() {
        return "Adios usuario";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/guardar")
    public ResponseEntity<UsuarioResponse> registrarUsuario(@RequestBody UsuarioRequest usuarioRequest) {

        Rol role = new Rol();

        return new ResponseEntity<>(usuarioService.registrarUsuario(usuarioRequest, role), HttpStatus.CREATED);
    }

    @PostMapping(value = "/registro")
    public ResponseEntity<UsuarioResponse> registroPlataforma(@RequestBody UsuarioRegisterRequest usuarioRegisterRequest)
    {

        Rol role = new Rol();
        role.setId(1L);
        role.setNombre("ROLE_USER");

        return new ResponseEntity<>(usuarioService.registrarse(usuarioRegisterRequest, role), HttpStatus.CREATED);
    }



}
