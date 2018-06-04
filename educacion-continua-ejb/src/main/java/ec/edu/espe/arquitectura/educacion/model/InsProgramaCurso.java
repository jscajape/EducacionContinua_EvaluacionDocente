/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "ins_programa_curso")
public class InsProgramaCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected InsProgramaCursoPK codigo;
    
    @JoinColumn(name = "COD_PROGRAMA", referencedColumnName = "COD_PROGRAMA", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private InsPrograma insPrograma;
    
    @JoinColumn(name = "COD_CURSO", referencedColumnName = "COD_CURSO", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private InsCurso insCurso;

    public InsProgramaCurso() {
    }

    public InsProgramaCurso(InsProgramaCursoPK codigo) {
        this.codigo = codigo;
    }

    public InsProgramaCursoPK getCodigo() {
        return codigo;
    }

    public void setCodigo(InsProgramaCursoPK codigo) {
        this.codigo = codigo;
    }
    
    public InsPrograma getInsPrograma() {
        return insPrograma;
    }

    public void setInsPrograma(InsPrograma insPrograma) {
        this.insPrograma = insPrograma;
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
        if (!(object instanceof InsProgramaCurso)) {
            return false;
        }
        InsProgramaCurso other = (InsProgramaCurso) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsProgramaCurso[ insProgramaCursoPK=" + codigo + " ]";
    }
    
}
