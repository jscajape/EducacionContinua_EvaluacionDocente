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
public class InsClasePK implements Serializable {

    @Column(name = "COD_CLASE", nullable = false, length = 10)
    private String codClase;

    @Column(name = "COD_CURSO", nullable = false)
    private int codCurso;

    public InsClasePK() {
    }

    public InsClasePK(String codClase, int codCurso) {
        this.codClase = codClase;
        this.codCurso = codCurso;
    }

    public String getCodClase() {
        return codClase;
    }

    public void setCodClase(String codClase) {
        this.codClase = codClase;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codClase != null ? codClase.hashCode() : 0);
        hash += (int) codCurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsClasePK)) {
            return false;
        }
        InsClasePK other = (InsClasePK) object;
        if ((this.codClase == null && other.codClase != null) || (this.codClase != null && !this.codClase.equals(other.codClase))) {
            return false;
        }
        if (this.codCurso != other.codCurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsClasePK[ codClase=" + codClase + ", codCurso=" + codCurso + " ]";
    }
    
}
