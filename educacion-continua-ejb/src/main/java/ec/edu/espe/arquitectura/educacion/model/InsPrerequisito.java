/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import ec.edu.espe.arquitectura.educacion.enums.EstadoPrerequisitoEnum;
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
@Table(name = "ins_prerequisito")
public class InsPrerequisito implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected InsPrerequisitoPK codigo;
    
    @Column(name = "ESTADO", nullable = false, length = 3)
    @Enumerated(EnumType.STRING)
    private EstadoPrerequisitoEnum estado;
    
    @JoinColumns({
        @JoinColumn(name = "COD_CURSO_PREV", referencedColumnName = "COD_CURSO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PROGRAMA_PREV", referencedColumnName = "COD_PROGRAMA", nullable = false, insertable = false, updatable = false)})
    @ManyToOne
    private InsProgramaCurso insProgramaCurso;
    
    @JoinColumns({
        @JoinColumn(name = "COD_CURSO", referencedColumnName = "COD_CURSO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_PROGRAMA", referencedColumnName = "COD_PROGRAMA", nullable = false, insertable = false, updatable = false)})
    @ManyToOne
    private InsProgramaCurso insProgramaCurso1;

    public InsPrerequisito() {
    }

    public InsPrerequisito(InsPrerequisitoPK codigo) {
        this.codigo = codigo;
    }

    public InsPrerequisitoPK getCodigo() {
        return codigo;
    }

    public void setCodigo(InsPrerequisitoPK codigo) {
        this.codigo = codigo;
    }

    public EstadoPrerequisitoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoPrerequisitoEnum estado) {
        this.estado = estado;
    }

    public InsProgramaCurso getInsProgramaCurso() {
        return insProgramaCurso;
    }

    public void setInsProgramaCurso(InsProgramaCurso insProgramaCurso) {
        this.insProgramaCurso = insProgramaCurso;
    }

    public InsProgramaCurso getInsProgramaCurso1() {
        return insProgramaCurso1;
    }

    public void setInsProgramaCurso1(InsProgramaCurso insProgramaCurso1) {
        this.insProgramaCurso1 = insProgramaCurso1;
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
        if (!(object instanceof InsPrerequisito)) {
            return false;
        }
        InsPrerequisito other = (InsPrerequisito) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsPrerequisito[ insPrerequisitoPK=" + codigo + " ]";
    }
    
}
