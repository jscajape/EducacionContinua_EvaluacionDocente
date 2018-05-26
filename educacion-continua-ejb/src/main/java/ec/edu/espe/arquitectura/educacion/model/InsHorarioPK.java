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
public class InsHorarioPK implements Serializable {

    @Column(name = "COD_FRANJA", nullable = false)
    private int codFranja;

    @Column(name = "COD_AULA", nullable = false)
    private int codAula;

    public InsHorarioPK() {
    }

    public InsHorarioPK(int codFranja, int codAula) {
        this.codFranja = codFranja;
        this.codAula = codAula;
    }

    public int getCodFranja() {
        return codFranja;
    }

    public void setCodFranja(int codFranja) {
        this.codFranja = codFranja;
    }

    public int getCodAula() {
        return codAula;
    }

    public void setCodAula(int codAula) {
        this.codAula = codAula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codFranja;
        hash += (int) codAula;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsHorarioPK)) {
            return false;
        }
        InsHorarioPK other = (InsHorarioPK) object;
        if (this.codFranja != other.codFranja) {
            return false;
        }
        if (this.codAula != other.codAula) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsHorarioPK[ codFranja=" + codFranja + ", codAula=" + codAula + " ]";
    }
    
}
