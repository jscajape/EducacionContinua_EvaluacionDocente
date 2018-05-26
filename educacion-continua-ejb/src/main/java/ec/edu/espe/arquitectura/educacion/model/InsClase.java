/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import ec.edu.espe.arquitectura.educacion.enums.EstadoClaseEnum;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "ins_clase")
public class InsClase implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected InsClasePK codigo;

    @Column(name = "FEC_INI", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIni;
    
    @Column(name = "FEC_FIN", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFin;
    
    @Column(name = "MODALIDAD", length = 3)
    private String modalidad;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", length = 3)
    private EstadoClaseEnum estado;
    
    @JoinColumn(name = "COD_DOCENTE", referencedColumnName = "COD_PERSONA")
    @ManyToOne
    private InsPersona insPersona;
    
    @JoinColumn(name = "COD_CURSO", referencedColumnName = "COD_CURSO", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private InsCurso insCurso;

    public InsClase() {
    }

    public InsClase(InsClasePK codigo) {
        this.codigo = codigo;
    }

    public InsClasePK getCodigo() {
        return codigo;
    }

    public void setCodigo(InsClasePK codigo) {
        this.codigo = codigo;
    }
    
    public Date getFecIni() {
        return fecIni;
    }

    public void setFecIni(Date fecIni) {
        this.fecIni = fecIni;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public EstadoClaseEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoClaseEnum estado) {
        this.estado = estado;
    }

    public InsPersona getInsPersona() {
        return insPersona;
    }

    public void setInsPersona(InsPersona insPersona) {
        this.insPersona = insPersona;
    }

    public InsCurso getInsCurso() {
        return insCurso;
    }

    public void setInsCurso(InsCurso insCurso) {
        this.insCurso = insCurso;
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
        if (!(object instanceof InsClase)) {
            return false;
        }
        InsClase other = (InsClase) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsClase[ insClasePK=" + codigo + " ]";
    }
    
}
