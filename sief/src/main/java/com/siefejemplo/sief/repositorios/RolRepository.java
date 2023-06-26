package com.siefejemplo.sief.repositorios;

import com.siefejemplo.sief.modelos.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {
    public Optional<Rol> findByNombre(String nombre);


}
