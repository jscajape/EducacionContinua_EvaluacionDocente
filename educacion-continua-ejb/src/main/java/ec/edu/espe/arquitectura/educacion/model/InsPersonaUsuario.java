/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "ins_persona_usuario")
public class InsPersonaUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected InsPersonaUsuarioPK codigo;

    public InsPersonaUsuario() {
    }

    public InsPersonaUsuarioPK getCodigo() {
        return codigo;
    }

    public void setCodigo(InsPersonaUsuarioPK codigo) {
        this.codigo = codigo;
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
        if (!(object instanceof InsPersonaUsuario)) {
            return false;
        }
        InsPersonaUsuario other = (InsPersonaUsuario) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsPersonaUsuario[ insPersonaUsuarioPK=" + codigo + " ]";
    }
    
}
