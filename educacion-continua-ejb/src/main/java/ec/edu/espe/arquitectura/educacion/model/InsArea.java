/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import ec.edu.espe.arquitectura.educacion.enums.EstadoAreaEnum;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author js_cm
 */

@Entity
@Table(name = "ins_area")
public class InsArea implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_AREA", nullable = false)
    private Integer codigo;
    
    @Column(name = "DESCRIPCION", nullable = false, length = 20)
    private String descripcion;
    
    @Column(name = "ESTADO", length = 3)
    @Enumerated(EnumType.STRING)
    
    private EstadoAreaEnum estado;

    public InsArea() {
    }

    public InsArea(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoAreaEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoAreaEnum estado) {
        this.estado = estado;
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
        if (!(object instanceof InsArea)) {
            return false;
        }
        InsArea other = (InsArea) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsArea[ codArea=" + codigo + " ]";
    }
    
}
