/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author js_cm
 */
@Embeddable
public class InsProgramaCursoPK implements Serializable {

    @Column(name = "COD_CURSO", nullable = false)
    private int codCurso;

    @Column(name = "COD_PROGRAMA", nullable = false)
    private int codPrograma;

    public InsProgramaCursoPK() {
    }

    public InsProgramaCursoPK(int codCurso, int codPrograma) {
        this.codCurso = codCurso;
        this.codPrograma = codPrograma;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public int getCodPrograma() {
        return codPrograma;
    }

    public void setCodPrograma(int codPrograma) {
        this.codPrograma = codPrograma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCurso;
        hash += (int) codPrograma;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsProgramaCursoPK)) {
            return false;
        }
        InsProgramaCursoPK other = (InsProgramaCursoPK) object;
        if (this.codCurso != other.codCurso) {
            return false;
        }
        if (this.codPrograma != other.codPrograma) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsProgramaCursoPK[ codCurso=" + codCurso + ", codPrograma=" + codPrograma + " ]";
    }
    
}
