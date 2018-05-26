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
public class EvaRespuestaCuestionarioPK implements Serializable {

    @Column(name = "COD_PERSONA", nullable = false, length = 20)
    private String codPersona;
    
    @Column(name = "COD_EVALUACION", nullable = false, length = 20)
    private String codEvaluacion;
    
    @Column(name = "COD_CUESTIONARIO", nullable = false, length = 30)
    private String codCuestionario;

    @Column(name = "COD_CLASE", nullable = false, length = 10)
    private String codClase;

    public EvaRespuestaCuestionarioPK() {
    }

    public EvaRespuestaCuestionarioPK(String codPersona, String codEvaluacion, String codCuestionario, String codClase) {
        this.codPersona = codPersona;
        this.codEvaluacion = codEvaluacion;
        this.codCuestionario = codCuestionario;
        this.codClase = codClase;
    }

    public String getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(String codPersona) {
        this.codPersona = codPersona;
    }

    public String getCodEvaluacion() {
        return codEvaluacion;
    }

    public void setCodEvaluacion(String codEvaluacion) {
        this.codEvaluacion = codEvaluacion;
    }

    public String getCodCuestionario() {
        return codCuestionario;
    }

    public void setCodCuestionario(String codCuestionario) {
        this.codCuestionario = codCuestionario;
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
        hash += (codPersona != null ? codPersona.hashCode() : 0);
        hash += (codEvaluacion != null ? codEvaluacion.hashCode() : 0);
        hash += (codCuestionario != null ? codCuestionario.hashCode() : 0);
        hash += (codClase != null ? codClase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaRespuestaCuestionarioPK)) {
            return false;
        }
        EvaRespuestaCuestionarioPK other = (EvaRespuestaCuestionarioPK) object;
        if ((this.codPersona == null && other.codPersona != null) || (this.codPersona != null && !this.codPersona.equals(other.codPersona))) {
            return false;
        }
        if ((this.codEvaluacion == null && other.codEvaluacion != null) || (this.codEvaluacion != null && !this.codEvaluacion.equals(other.codEvaluacion))) {
            return false;
        }
        if ((this.codCuestionario == null && other.codCuestionario != null) || (this.codCuestionario != null && !this.codCuestionario.equals(other.codCuestionario))) {
            return false;
        }
        if ((this.codClase == null && other.codClase != null) || (this.codClase != null && !this.codClase.equals(other.codClase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.EvaRespuestaCuestionarioPK[ codPersona=" + codPersona + ", codEvaluacion=" + codEvaluacion + ", codCuestionario=" + codCuestionario + ", codClase=" + codClase + " ]";
    }
    
}
