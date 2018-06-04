/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import ec.edu.espe.arquitectura.educacion.enums.EstadoCuestionarioEnum;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "EVA_CUESTIONARIO")
public class EvaCuestionario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_CUESTIONARIO", nullable = false)
    private String codigo;
    
    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", nullable = false, length = 3)
    private EstadoCuestionarioEnum estado;

    public EvaCuestionario() {
    }

    public EvaCuestionario(String codigo) {
        this.codigo = codigo;
    }


    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public EstadoCuestionarioEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoCuestionarioEnum estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
        if (!(object instanceof EvaCuestionario)) {
            return false;
        }
        EvaCuestionario other = (EvaCuestionario) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.EvaCuestionario[ codCuestionario=" + codigo + " ]";
    }
    
}
