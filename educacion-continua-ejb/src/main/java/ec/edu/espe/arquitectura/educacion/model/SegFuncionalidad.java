/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import ec.edu.espe.arquitectura.educacion.enums.EstadoFuncionalidadEnum;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "seg_funcionalidad")
public class SegFuncionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected SegFuncionalidadPK codigo;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;
    
    @Column(name = "URL", nullable = false, length = 200)
    private String url;
    
    @Column(name = "ESTADO", nullable = false, length = 3)
    @Enumerated(EnumType.STRING)
    private EstadoFuncionalidadEnum estado;
    
    @JoinColumn(name = "COD_MODULO", referencedColumnName = "COD_MODULO", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private SegModulo segModulo;

    public SegFuncionalidad() {
    }

    public SegFuncionalidad(SegFuncionalidadPK codigo) {
        this.codigo = codigo;
    }

    public SegFuncionalidadPK getCodigo() {
        return codigo;
    }

    public void setCodigo(SegFuncionalidadPK codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public EstadoFuncionalidadEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoFuncionalidadEnum estado) {
        this.estado = estado;
    }

    public SegModulo getSegModulo() {
        return segModulo;
    }

    public void setSegModulo(SegModulo segModulo) {
        this.segModulo = segModulo;
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
        if (!(object instanceof SegFuncionalidad)) {
            return false;
        }
        SegFuncionalidad other = (SegFuncionalidad) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.SegFuncionalidad[ segFuncionalidadPK=" + codigo + " ]";
    }
    
}
