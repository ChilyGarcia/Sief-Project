package com.siefejemplo.sief.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "auditorias")
public class Auditorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String usuario;
    private String tipoModificacion;
    private String nombrePrograma;
    private LocalDateTime fecha;


    @PrePersist
    public void prePersist() {
        fecha = LocalDateTime.now();
    }
}
