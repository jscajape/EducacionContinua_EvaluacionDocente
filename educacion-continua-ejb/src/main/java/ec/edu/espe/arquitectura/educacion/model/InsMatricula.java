/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "ins_matricula")
public class InsMatricula implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_MATRICULA", nullable = false)
    private Integer codigo;
    
    @Column(name = "FECHA_REALIZA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRealiza;
    
    @Column(name = "ESTADO", nullable = false, length = 3)
    private String estado;
    
    @JoinColumns({
        @JoinColumn(name = "COD_CLASE", referencedColumnName = "COD_CLASE"),
        @JoinColumn(name = "COD_CURSO", referencedColumnName = "COD_CURSO")})
    @ManyToOne
    private InsClase insClase;
    
    @JoinColumn(name = "COD_ALUMNO", referencedColumnName = "COD_PERSONA")
    @ManyToOne
    private InsPersona insPersona;

    public InsMatricula() {
    }

    public InsMatricula(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    public Date getFechaRealiza() {
        return fechaRealiza;
    }

    public void setFechaRealiza(Date fechaRealiza) {
        this.fechaRealiza = fechaRealiza;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public InsClase getInsClase() {
        return insClase;
    }

    public void setInsClase(InsClase insClase) {
        this.insClase = insClase;
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
        if (!(object instanceof InsMatricula)) {
            return false;
        }
        InsMatricula other = (InsMatricula) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsMatricula[ codMatricula=" + codigo + " ]";
    }
    
}
