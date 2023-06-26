package com.siefejemplo.sief.Servicios.implementaciones;

import com.siefejemplo.sief.Servicios.AuditoriasServicio;
import com.siefejemplo.sief.modelos.Auditorias;
import com.siefejemplo.sief.repositorios.AuditoriasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriasServiceImpl implements AuditoriasServicio {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuditoriasRepository auditoriasRepository;

    @Override
    public Auditorias registroAuditoria(String usuario, String tipoModificacion, String programa) {
        Auditorias response = new Auditorias();

        response.setUsuario(usuario);
        response.setTipoModificacion(tipoModificacion);
        response.setNombrePrograma(programa);

        return auditoriasRepository.save(response);
    }

    @Override
    public List<Auditorias> listaAuditorias() {

        List<Auditorias> listaAuditoriaTotal = auditoriasRepository.findAll();

        return listaAuditoriaTotal;
    }
}
