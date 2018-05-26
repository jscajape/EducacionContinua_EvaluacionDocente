/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "ins_calificacion")
public class InsCalificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_CALIFICACION", nullable = false)
    private Integer codigo;

    @Column(name = "VALOR_CALIFICACION", precision = 6, scale = 2)
    private BigDecimal valorCalificacion;
    
    @Column(name = "PORCENTAJE_PESO")
    private Integer porcentajePeso;
    
    @JoinColumn(name = "COD_MATRICULA", referencedColumnName = "COD_MATRICULA")
    @ManyToOne
    private InsMatricula insMatricula;

    public InsCalificacion() {
    }

    public InsCalificacion(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValorCalificacion() {
        return valorCalificacion;
    }

    public void setValorCalificacion(BigDecimal valorCalificacion) {
        this.valorCalificacion = valorCalificacion;
    }

    public Integer getPorcentajePeso() {
        return porcentajePeso;
    }

    public void setPorcentajePeso(Integer porcentajePeso) {
        this.porcentajePeso = porcentajePeso;
    }

    public InsMatricula getInsMatricula() {
        return insMatricula;
    }

    public void setInsMatricula(InsMatricula insMatricula) {
        this.insMatricula = insMatricula;
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
        if (!(object instanceof InsCalificacion)) {
            return false;
        }
        InsCalificacion other = (InsCalificacion) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsCalificacion[ codCalificacion=" + codigo + " ]";
    }
    
}
