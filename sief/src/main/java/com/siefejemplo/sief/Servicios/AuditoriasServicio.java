package com.siefejemplo.sief.Servicios;

import com.siefejemplo.sief.modelos.Auditorias;

import java.util.List;

public interface AuditoriasServicio {

    public Auditorias registroAuditoria(String usuario, String tipoModificacion, String programa);

    public List<Auditorias> listaAuditorias();
}
