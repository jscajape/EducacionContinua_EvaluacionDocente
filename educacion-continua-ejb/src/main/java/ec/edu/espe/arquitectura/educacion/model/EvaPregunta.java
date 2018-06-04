/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "eva_pregunta")
public class EvaPregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "COD_PREGUNTA", nullable = false)
    private Integer codigo;
    
    @Column(name = "ENUNCIADO", nullable = false, length = 200)
    private String enunciado;
    
    @JoinColumn(name = "COD_CUESTIONARIO", referencedColumnName = "COD_CUESTIONARIO", insertable = false, updatable = false)
    @ManyToOne
    private EvaCuestionario evaCuestionario;
    

    public EvaPregunta() {
    }

    public EvaPregunta(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public EvaCuestionario getEvaCuestionario() {
        return evaCuestionario;
    }

    public void setEvaCuestionario(EvaCuestionario evaCuestionario) {
        this.evaCuestionario = evaCuestionario;
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
        if (!(object instanceof EvaPregunta)) {
            return false;
        }
        EvaPregunta other = (EvaPregunta) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.EvaPregunta[ codPregunta=" + codigo + " ]";
    }
    
}
