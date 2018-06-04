/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "eva_respuesta_cuestionario")
public class EvaRespuestaCuestionario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected EvaRespuestaCuestionarioPK codigo;
    
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Column(name = "CALIFICACION_PROMEDIO", nullable = false, precision = 2, scale = 2)
    private BigDecimal calificacionPromedio;
    
    @JoinColumns({
        @JoinColumn(name = "COD_CLASE", referencedColumnName = "COD_CLASE", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CURSO", referencedColumnName = "COD_CURSO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne
    private InsClase insClase;
    
    @JoinColumns({
        @JoinColumn(name = "COD_EVALUACION", referencedColumnName = "COD_EVALUACION", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_CUESTIONARIO", referencedColumnName = "COD_CUESTIONARIO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne
    private EvaDetalleEvaluacon evaDetalleEvaluacon;
    
    @JoinColumn(name = "COD_PERSONA", referencedColumnName = "COD_PERSONA", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private InsPersona insPersona;

    public EvaRespuestaCuestionario() {
    }

    public EvaRespuestaCuestionario(EvaRespuestaCuestionarioPK codigo) {
        this.codigo = codigo;
    }

    public EvaRespuestaCuestionarioPK getCodigo() {
        return codigo;
    }

    public void setCodigo(EvaRespuestaCuestionarioPK codigo) {
        this.codigo = codigo;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(BigDecimal calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }

    public InsClase getInsClase() {
        return insClase;
    }

    public void setInsClase(InsClase insClase) {
        this.insClase = insClase;
    }

    public EvaDetalleEvaluacon getEvaDetalleEvaluacon() {
        return evaDetalleEvaluacon;
    }

    public void setEvaDetalleEvaluacon(EvaDetalleEvaluacon evaDetalleEvaluacon) {
        this.evaDetalleEvaluacon = evaDetalleEvaluacon;
    }

    public InsPersona getInsPersona() {
        return insPersona;
    }

    public void setInsPersona(InsPersona insPersona) {
        this.insPersona = insPersona;
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
        if (!(object instanceof EvaRespuestaCuestionario)) {
            return false;
        }
        EvaRespuestaCuestionario other = (EvaRespuestaCuestionario) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.EvaRespuestaCuestionario[ evaRespuestaCuestionarioPK=" + codigo + " ]";
    }
    
}
