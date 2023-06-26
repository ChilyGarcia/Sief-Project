package com.siefejemplo.sief.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProgramaRequest {

    private String codigoPrograma;
    private String nombreDelPrograma;
    private String periodo;
    private String inscritos;
    private String admitidos;
    private String matriculados;
    private String graduados;


}
