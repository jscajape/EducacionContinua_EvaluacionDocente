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
public class EvaResultadoEvaluacionPK implements Serializable {

    @Column(name = "COD_EVALUACION", nullable = false, length = 20)
    private String codEvaluacion;
    
    @Column(name = "COD_CLASE", nullable = false, length = 10)
    private String codClase;

    public EvaResultadoEvaluacionPK() {
    }

    public EvaResultadoEvaluacionPK(String codEvaluacion, String codClase) {
        this.codEvaluacion = codEvaluacion;
        this.codClase = codClase;
    }

    public String getCodEvaluacion() {
        return codEvaluacion;
    }

    public void setCodEvaluacion(String codEvaluacion) {
        this.codEvaluacion = codEvaluacion;
    }

    public String getCodClase() {
        return codClase;
    }

    public void setCodClase(String codClase) {
        this.codClase = codClase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEvaluacion != null ? codEvaluacion.hashCode() : 0);
        hash += (codClase != null ? codClase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaResultadoEvaluacionPK)) {
            return false;
        }
        EvaResultadoEvaluacionPK other = (EvaResultadoEvaluacionPK) object;
        if ((this.codEvaluacion == null && other.codEvaluacion != null) || (this.codEvaluacion != null && !this.codEvaluacion.equals(other.codEvaluacion))) {
            return false;
        }
        if ((this.codClase == null && other.codClase != null) || (this.codClase != null && !this.codClase.equals(other.codClase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.EvaResultadoEvaluacionPK[ codEvaluacion=" + codEvaluacion + ", codClase=" + codClase + " ]";
    }
    
}
