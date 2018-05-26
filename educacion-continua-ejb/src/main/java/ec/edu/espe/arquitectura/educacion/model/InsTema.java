/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import ec.edu.espe.arquitectura.educacion.enums.EstadoTemaEnum;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "ins_tema")
public class InsTema implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_MODULO", nullable = false, length = 10)
    private String codigo;
    
    @Column(name = "TITULO", nullable = false, length = 50)
    private String titulo;
    
    @Column(name = "DESCRIPCION", nullable = false, length = 500)
    private String descripcion;
    
    @Column(name = "ESTADO", nullable = false, length = 3)
    @Enumerated(EnumType.STRING)
    private EstadoTemaEnum estado;
    
    @JoinColumn(name = "COD_CURSO", referencedColumnName = "COD_CURSO")
    @ManyToOne
    private InsCurso insCurso;

    public InsTema() {
    }

    public InsTema(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoTemaEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoTemaEnum estado) {
        this.estado = estado;
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
        if (!(object instanceof InsTema)) {
            return false;
        }
        InsTema other = (InsTema) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsTema[ codModulo=" + codigo + " ]";
    }
    
}
