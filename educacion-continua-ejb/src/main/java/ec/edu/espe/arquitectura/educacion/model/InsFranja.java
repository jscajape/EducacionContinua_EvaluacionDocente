/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import ec.edu.espe.arquitectura.educacion.enums.EstadoFranjaEnum;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "ins_franja")
public class InsFranja implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_FRANJA", nullable = false)
    private Integer codigo;
    
    @Column(name = "INCIO", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date incio;
    
    @Column(name = "FIN", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date fin;
    
    @Column(name = "ESTADO", length = 3)
    @Enumerated(EnumType.STRING)
    private EstadoFranjaEnum estado;

    public InsFranja() {
    }

    public InsFranja(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getIncio() {
        return incio;
    }

    public void setIncio(Date incio) {
        this.incio = incio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public EstadoFranjaEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoFranjaEnum estado) {
        this.estado = estado;
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
        if (!(object instanceof InsFranja)) {
            return false;
        }
        InsFranja other = (InsFranja) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsFranja[ codFranja=" + codigo + " ]";
    }
    
}
