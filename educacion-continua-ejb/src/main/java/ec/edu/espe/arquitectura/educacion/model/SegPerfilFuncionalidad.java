/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import ec.edu.espe.arquitectura.educacion.enums.EstadoPerfilFuncionalidadEnum;
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
@Table(name = "seg_perfil_funcionalidad")
public class SegPerfilFuncionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected SegPerfilFuncionalidadPK codigo;
    
    @Column(name = "ESTADO", nullable = false, length = 3)
    @Enumerated(EnumType.STRING)
    private EstadoPerfilFuncionalidadEnum estado;
    
    @JoinColumns({
        @JoinColumn(name = "COD_MODULO", referencedColumnName = "COD_MODULO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "SEC_FUNCIONALIDAD", referencedColumnName = "SEC_FUNCIONALIDAD", nullable = false, insertable = false, updatable = false)})
    @ManyToOne
    private SegFuncionalidad segFuncionalidad;
    
    @JoinColumn(name = "COD_PERFIL", referencedColumnName = "COD_PERFIL", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private SegPerfil segPerfil;

    public SegPerfilFuncionalidad() {
    }

    public SegPerfilFuncionalidad(SegPerfilFuncionalidadPK codigo) {
        this.codigo = codigo;
    }

    public SegPerfilFuncionalidadPK getCodigo() {
        return codigo;
    }

    public void setCodigo(SegPerfilFuncionalidadPK codigo) {
        this.codigo = codigo;
    }

    public EstadoPerfilFuncionalidadEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoPerfilFuncionalidadEnum estado) {
        this.estado = estado;
    }

    public SegFuncionalidad getSegFuncionalidad() {
        return segFuncionalidad;
    }

    public void setSegFuncionalidad(SegFuncionalidad segFuncionalidad) {
        this.segFuncionalidad = segFuncionalidad;
    }

    public SegPerfil getSegPerfil() {
        return segPerfil;
    }

    public void setSegPerfil(SegPerfil segPerfil) {
        this.segPerfil = segPerfil;
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
        if (!(object instanceof SegPerfilFuncionalidad)) {
            return false;
        }
        SegPerfilFuncionalidad other = (SegPerfilFuncionalidad) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.SegPerfilFuncionalidad[ segPerfilFuncionalidadPK=" + codigo + " ]";
    }
    
}
