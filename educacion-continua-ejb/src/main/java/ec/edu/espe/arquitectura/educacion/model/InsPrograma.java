/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "ins_programa")
public class InsPrograma implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_PROGRAMA", nullable = false)
    private Integer codigo;
    
    @Column(name = "TITULO", nullable = false, length = 50)
    private String titulo;
    
    public InsPrograma() {
    }

    public InsPrograma(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
        if (!(object instanceof InsPrograma)) {
            return false;
        }
        InsPrograma other = (InsPrograma) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsPrograma[ codPrograma=" + codigo + " ]";
    }
    
}
