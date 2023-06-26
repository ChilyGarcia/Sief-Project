package com.siefejemplo.sief.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "programas")
public class Programas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codigoPrograma;
    private String nombreDelPrograma;
    private String periodo;
    private String inscritos;
    private String admitidos;
    private String matriculados;
    private String graduados;


}


