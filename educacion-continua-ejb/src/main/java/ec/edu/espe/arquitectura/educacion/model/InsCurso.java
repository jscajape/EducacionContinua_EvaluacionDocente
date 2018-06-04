/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import ec.edu.espe.arquitectura.educacion.enums.EstadoCursoEnum;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ins_curso")
public class InsCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_CURSO", nullable = false)
    private Integer codigo;
    
    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    private String descripcion;
    
    @Column(name = "COSTO", precision = 6, scale = 4)
    private BigDecimal costo;
    
    @Column(name = "HORAS_DURACION")
    private Integer horasDuracion;
    
    @Column(name = "ESTADO", length = 3)
    @Enumerated(EnumType.STRING)
    private EstadoCursoEnum estado;
    
    @JoinColumn(name = "COD_AREA", referencedColumnName = "COD_AREA", nullable = false)
    @ManyToOne
    private InsArea insArea;
    
    public InsCurso() {
    }

    public InsCurso(Integer codigo) {
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

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Integer getHorasDuracion() {
        return horasDuracion;
    }

    public void setHorasDuracion(Integer horasDuracion) {
        this.horasDuracion = horasDuracion;
    }

    public EstadoCursoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoCursoEnum estado) {
        this.estado = estado;
    }

    public InsArea getInsArea() {
        return insArea;
    }

    public void setInsArea(InsArea insArea) {
        this.insArea = insArea;
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
        if (!(object instanceof InsCurso)) {
            return false;
        }
        InsCurso other = (InsCurso) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsCurso[ codCurso=" + codigo + " ]";
    }
    
}
