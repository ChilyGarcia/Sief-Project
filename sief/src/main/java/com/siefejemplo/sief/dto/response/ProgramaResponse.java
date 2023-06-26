package com.siefejemplo.sief.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ProgramaResponse {

    private String codigoPrograma;
    private String nombreDelPrograma;
    private String periodo;
    private String inscritos;
    private String admitidos;
    private String matriculados;
    private String graduados;


}
