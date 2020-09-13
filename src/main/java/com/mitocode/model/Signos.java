/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author cesar
 */
@Entity
@Table(name = "signos")
public class Signos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSigno;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Schema(description = "Temperaruta del signo")
    @Size(min = 3, message = "Nombre debe tener minimo 3 caracteres")
    @Column(name = "temperatura", nullable = false, length = 10)
    private String temperatura;

    @Schema(description = "pulso del signo")
    @Size(min = 3, message = "Pulso debe tener minimo 3 caracteres")
    @Column(name = "pulso", nullable = false, length = 30)
    private String pulso;

    @Schema(description = "Ritmo Respiratorio del signo")
    @Size(min = 10, message = "Ritmo Respiratorio debe tener minimo 10 caracteres")
    @Column(name = "ritmo_respiratorio", nullable = false, length = 30)
    private String ritmoRespiratorio;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_signos_paciente"))
    private Paciente paciente;

    public Signos() {
    }

    public Integer getIdSigno() {
        return idSigno;
    }

    public void setIdSigno(Integer idSigno) {
        this.idSigno = idSigno;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getPulso() {
        return pulso;
    }

    public void setPulso(String pulso) {
        this.pulso = pulso;
    }

    public String getRitmoRespiratorio() {
        return ritmoRespiratorio;
    }

    public void setRitmoRespiratorio(String ritmoRespiratorio) {
        this.ritmoRespiratorio = ritmoRespiratorio;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

}
