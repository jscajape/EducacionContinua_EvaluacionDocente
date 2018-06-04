/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "eva_resultado_evaluacion")
public class EvaResultadoEvaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected EvaResultadoEvaluacionPK codigo;
    
    @Column(name = "PROMEDIO_TOTAL", nullable = false, precision = 2, scale = 2)
    private BigDecimal promedioTotal;
    
    @JoinColumn(name = "COD_EVALUACION", referencedColumnName = "COD_EVALUACION", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private EvaEvaluacion evaEvaluacion;
    
    @JoinColumns({
        @JoinColumn(name = "COD_CLASE", referencedColumnName = "COD_CLASE", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CURSO", referencedColumnName = "COD_CURSO")})
    @ManyToOne
    private InsClase insClase;

    public EvaResultadoEvaluacion() {
    }

    public EvaResultadoEvaluacion(EvaResultadoEvaluacionPK codigo) {
        this.codigo = codigo;
    }

    public EvaResultadoEvaluacionPK getCodigo() {
        return codigo;
    }

    public void setCodigo(EvaResultadoEvaluacionPK codigo) {
        this.codigo = codigo;
    }
    
    public BigDecimal getPromedioTotal() {
        return promedioTotal;
    }

    public void setPromedioTotal(BigDecimal promedioTotal) {
        this.promedioTotal = promedioTotal;
    }

    public EvaEvaluacion getEvaEvaluacion() {
        return evaEvaluacion;
    }

    public void setEvaEvaluacion(EvaEvaluacion evaEvaluacion) {
        this.evaEvaluacion = evaEvaluacion;
    }

    public InsClase getInsClase() {
        return insClase;
    }

    public void setInsClase(InsClase insClase) {
        this.insClase = insClase;
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
        if (!(object instanceof EvaResultadoEvaluacion)) {
            return false;
        }
        EvaResultadoEvaluacion other = (EvaResultadoEvaluacion) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.EvaResultadoEvaluacion[ evaResultadoEvaluacionPK=" + codigo + " ]";
    }
    
}
