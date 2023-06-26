package com.siefejemplo.sief.Servicios.implementaciones;

import com.siefejemplo.sief.Servicios.UsuarioServicio;
import com.siefejemplo.sief.dto.request.UsuarioRegisterRequest;
import com.siefejemplo.sief.dto.request.UsuarioRequest;
import com.siefejemplo.sief.dto.response.UsuarioResponse;
import com.siefejemplo.sief.modelos.Rol;
import com.siefejemplo.sief.modelos.Usuario;
import com.siefejemplo.sief.repositorios.RolRepository;
import com.siefejemplo.sief.repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class UsuarioServiceImpl implements UsuarioServicio {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;


    @Override
    public UsuarioResponse registrarUsuario(UsuarioRequest usuarioRequest, Rol role) {

        Usuario usuarioMapeado = modelMapper.map(usuarioRequest, Usuario.class);

        usuarioMapeado.setPassword(bCryptPasswordEncoder.encode(usuarioRequest.getPassword()));

        if (usuarioRequest.getRoleUser().equals("ROLE_USER")) {
            role.setId(1L);
            role.setNombre("ROLE_USER");

        }else if(usuarioRequest.getRoleUser().equals("ROLE_ADMIN"))
        {
            role.setId(2L);
            role.setNombre("ROLE_ADMIN");

        }

        usuarioMapeado.getRoles().add(role);

        Usuario usuarioGuardado = userRepository.save(usuarioMapeado);

        UsuarioResponse response = modelMapper.map(usuarioGuardado, UsuarioResponse.class);

        return response;
    }

    @Override
    public UsuarioResponse registrarse(UsuarioRegisterRequest usuarioRegisterRequest, Rol rol) {


        Usuario usuario = modelMapper.map(usuarioRegisterRequest, Usuario.class);
        usuario.setPassword(bCryptPasswordEncoder.encode(usuarioRegisterRequest.getPassword()));

        usuario.getRoles().add(rol);

        Usuario usuarioGuardado = userRepository.save(usuario);

        UsuarioResponse response = modelMapper.map(usuarioGuardado, UsuarioResponse.class);

        return response;
    }


}
