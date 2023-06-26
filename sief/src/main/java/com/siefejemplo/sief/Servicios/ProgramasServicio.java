package com.siefejemplo.sief.Servicios;

import com.siefejemplo.sief.dto.request.ProgramaRequest;
import com.siefejemplo.sief.dto.response.ProgramaResponse;
import com.siefejemplo.sief.modelos.Programas;

import java.util.List;

public interface ProgramasServicio {


    public ProgramaResponse agregarServicio(ProgramaRequest programaRequest);
    public List<Programas> listaDeProgramas();
    public List<Programas> listaProgramasCodigo(String codigo);

}
