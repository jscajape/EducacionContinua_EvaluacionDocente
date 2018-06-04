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
public class InsPrerequisitoPK implements Serializable {

    @Column(name = "COD_CURSO", nullable = false)
    private int codCurso;

    @Column(name = "COD_PROGRAMA", nullable = false)
    private int codPrograma;

    @Column(name = "COD_CURSO_PREV", nullable = false)
    private int codCursoPrev;

    @Column(name = "COD_PROGRAMA_PREV", nullable = false)
    private int codProgramaPrev;

    public InsPrerequisitoPK() {
    }

    public InsPrerequisitoPK(int codCurso, int codPrograma, int codCursoPrev, int codProgramaPrev) {
        this.codCurso = codCurso;
        this.codPrograma = codPrograma;
        this.codCursoPrev = codCursoPrev;
        this.codProgramaPrev = codProgramaPrev;
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

    public int getCodCursoPrev() {
        return codCursoPrev;
    }

    public void setCodCursoPrev(int codCursoPrev) {
        this.codCursoPrev = codCursoPrev;
    }

    public int getCodProgramaPrev() {
        return codProgramaPrev;
    }

    public void setCodProgramaPrev(int codProgramaPrev) {
        this.codProgramaPrev = codProgramaPrev;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCurso;
        hash += (int) codPrograma;
        hash += (int) codCursoPrev;
        hash += (int) codProgramaPrev;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsPrerequisitoPK)) {
            return false;
        }
        InsPrerequisitoPK other = (InsPrerequisitoPK) object;
        if (this.codCurso != other.codCurso) {
            return false;
        }
        if (this.codPrograma != other.codPrograma) {
            return false;
        }
        if (this.codCursoPrev != other.codCursoPrev) {
            return false;
        }
        if (this.codProgramaPrev != other.codProgramaPrev) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsPrerequisitoPK[ codCurso=" + codCurso + ", codPrograma=" + codPrograma + ", codCursoPrev=" + codCursoPrev + ", codProgramaPrev=" + codProgramaPrev + " ]";
    }
    
}
