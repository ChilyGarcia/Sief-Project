package com.siefejemplo.sief.Controlador;

import com.siefejemplo.sief.Servicios.UsuarioServicio;
import com.siefejemplo.sief.Servicios.implementaciones.ProgramasServiceImpl;
import com.siefejemplo.sief.dto.LoginDTO;
import com.siefejemplo.sief.dto.request.ProgramaRequest;
import com.siefejemplo.sief.dto.request.UsuarioRegisterRequest;
import com.siefejemplo.sief.dto.response.ProgramaResponse;
import com.siefejemplo.sief.dto.response.UsuarioResponse;
import com.siefejemplo.sief.modelos.Rol;
import com.siefejemplo.sief.repositorios.ProgramasRepository;
import com.siefejemplo.sief.repositorios.RolRepository;
import com.siefejemplo.sief.repositorios.UserRepository;
import com.siefejemplo.sief.security.JWTAuthResponseDTO;
import com.siefejemplo.sief.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthControlador {

    @Autowired
    private UsuarioServicio usuarioService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository usuarioRepositorio;

    @Autowired
    private RolRepository rolRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private ProgramasServiceImpl programasService;

    @Autowired
    private ProgramasRepository programasRepository;


    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/iniciarSesion")
    public ResponseEntity<JWTAuthResponseDTO> authenticateUser(@RequestBody LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        //obtenemos el token del jwtTokenProvider
        String token = jwtTokenProvider.generarToken(authentication);


        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        System.out.println("Roles del usuario autenticado: " + roles);

        // Crear objeto JWTAuthResponseDTO con el token y los roles
        JWTAuthResponseDTO response = new JWTAuthResponseDTO();
        response.setTokenDeAcceso(token);
        response.setRoles(roles);

        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping(value = "/registro")
    public ResponseEntity<UsuarioResponse> registroPlataforma(@RequestBody UsuarioRegisterRequest usuarioRegisterRequest)
    {

        Rol role = new Rol();
        role.setId(1L);
        role.setNombre("ROLE_USER");

        return new ResponseEntity<>(usuarioService.registrarse(usuarioRegisterRequest, role), HttpStatus.CREATED);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/guardarPrograma")
    public ResponseEntity<ProgramaResponse> guardarPrograma(@RequestBody ProgramaRequest programaRequest)
    {

        return new ResponseEntity<>(programasService.agregarServicio(programaRequest), HttpStatus.CREATED);
    }

}
