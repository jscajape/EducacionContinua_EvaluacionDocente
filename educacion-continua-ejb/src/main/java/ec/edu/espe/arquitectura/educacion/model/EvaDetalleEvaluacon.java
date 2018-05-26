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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "EVA_DETALLE_EVALUACON")
public class EvaDetalleEvaluacon implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected EvaDetalleEvaluaconPK codigo;
    
    @Column(name = "PONDERACION", precision = 2, scale = 2)
    private BigDecimal ponderacion;
    
    @Column(name = "COD_ROL", nullable = false, length = 10)
    private String codRol;
    
    @JoinColumn(name = "COD_EVALUACION", referencedColumnName = "COD_EVALUACION", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private EvaEvaluacion evaEvaluacion;
    @JoinColumn(name = "COD_CUESTIONARIO", referencedColumnName = "COD_CUESTIONARIO", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private EvaCuestionario evaCuestionario;
    @JoinColumn(name = "COD_ROL", referencedColumnName = "COD_ROL",nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private SegRol segRol;

    public EvaDetalleEvaluacon() {
    }

    public EvaDetalleEvaluacon(EvaDetalleEvaluaconPK codigo) {
        this.codigo = codigo;
    }

    public EvaDetalleEvaluaconPK getCodigo() {
        return codigo;
    }

    public void setCodigo(EvaDetalleEvaluaconPK codigo) {
        this.codigo = codigo;
    }

    public String getCodRol() {
        return codRol;
    }

    public void setCodRol(String codRol) {
        this.codRol = codRol;
    }

    public BigDecimal getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(BigDecimal ponderacion) {
        this.ponderacion = ponderacion;
    }


    public EvaEvaluacion getEvaEvaluacion() {
        return evaEvaluacion;
    }

    public void setEvaEvaluacion(EvaEvaluacion evaEvaluacion) {
        this.evaEvaluacion = evaEvaluacion;
    }

    public EvaCuestionario getEvaCuestionario() {
        return evaCuestionario;
    }

    public void setEvaCuestionario(EvaCuestionario evaCuestionario) {
        this.evaCuestionario = evaCuestionario;
    }

    public SegRol getSegRol() {
        return segRol;
    }

    public void setSegRol(SegRol segRol) {
        this.segRol = segRol;
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
        if (!(object instanceof EvaDetalleEvaluacon)) {
            return false;
        }
        EvaDetalleEvaluacon other = (EvaDetalleEvaluacon) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.EvaDetalleEvaluacon[ evaDetalleEvaluaconPK=" + codigo + " ]";
    }
    
}
