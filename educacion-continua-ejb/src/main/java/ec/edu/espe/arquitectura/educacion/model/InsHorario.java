/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import ec.edu.espe.arquitectura.educacion.enums.EstadoHorarioEnum;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "ins_horario")
public class InsHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected InsHorarioPK codigo;
    
    @Column(name = "DIA", length = 1)
    private String dia;
    
    @Column(name = "ESTADO", length = 3)
    @Enumerated(EnumType.STRING)
    private EstadoHorarioEnum estado;
    
    @JoinColumn(name = "COD_FRANJA", referencedColumnName = "COD_FRANJA", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private InsFranja insFranja;
    
    @JoinColumn(name = "COD_AULA", referencedColumnName = "COD_AULA", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private InsAula insAula;
    
    @JoinColumns({
        @JoinColumn(name = "COD_CLASE", referencedColumnName = "COD_CLASE"),
        @JoinColumn(name = "COD_CURSO", referencedColumnName = "COD_CURSO")})
    @ManyToOne
    private InsClase insClase;

    public InsHorario() {
    }

    public InsHorario(InsHorarioPK codigo) {
        this.codigo = codigo;
    }

    public InsHorarioPK getCodigo() {
        return codigo;
    }

    public void setCodigo(InsHorarioPK codigo) {
        this.codigo = codigo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public EstadoHorarioEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoHorarioEnum estado) {
        this.estado = estado;
    }

    public InsFranja getInsFranja() {
        return insFranja;
    }

    public void setInsFranja(InsFranja insFranja) {
        this.insFranja = insFranja;
    }

    public InsAula getInsAula() {
        return insAula;
    }

    public void setInsAula(InsAula insAula) {
        this.insAula = insAula;
    }

    public InsClase getInsClase() {
        return insClase;
    }

    public void setInsClase(InsClase insClase) {
        this.insClase = insClase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsHorario)) {
            return false;
        }
        InsHorario other = (InsHorario) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsHorario[ insHorarioPK=" + codigo + " ]";
    }
    
}
