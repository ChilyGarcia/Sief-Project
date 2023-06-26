package com.siefejemplo.sief.repositorios;

import com.siefejemplo.sief.modelos.Auditorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriasRepository extends JpaRepository<Auditorias, Long> {
}
