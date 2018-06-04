/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import ec.edu.espe.arquitectura.educacion.enums.EstadoModuloEnum;
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
@Table(name = "seg_modulo")
public class SegModulo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_MODULO", nullable = false, length = 20)
    private String codigo;
    
    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;
    
    @Column(name = "ESTADO", nullable = false, length = 3)
    @Enumerated(EnumType.STRING)
    private EstadoModuloEnum estado;

    public SegModulo() {
    }

    public SegModulo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EstadoModuloEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoModuloEnum estado) {
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
        if (!(object instanceof SegModulo)) {
            return false;
        }
        SegModulo other = (SegModulo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.SegModulo[ codModulo=" + codigo + " ]";
    }
    
}
