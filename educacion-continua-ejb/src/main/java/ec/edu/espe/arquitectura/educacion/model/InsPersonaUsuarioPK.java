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
public class InsPersonaUsuarioPK implements Serializable {

    @Column(name = "COD_PERSONA", nullable = false, length = 20)
    private String codPersona;

    @Column(name = "COD_USUARIO", nullable = false, length = 20)
    private String codUsuario;

    @Column(name = "COD_ROL", nullable = false, length = 10)
    private String codRol;

    public InsPersonaUsuarioPK() {
    }

    public InsPersonaUsuarioPK(String codPersona, String codUsuario, String codRol) {
        this.codPersona = codPersona;
        this.codUsuario = codUsuario;
        this.codRol = codRol;
    }

    public String getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(String codPersona) {
        this.codPersona = codPersona;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getCodRol() {
        return codRol;
    }

    public void setCodRol(String codRol) {
        this.codRol = codRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPersona != null ? codPersona.hashCode() : 0);
        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
        hash += (codRol != null ? codRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsPersonaUsuarioPK)) {
            return false;
        }
        InsPersonaUsuarioPK other = (InsPersonaUsuarioPK) object;
        if ((this.codPersona == null && other.codPersona != null) || (this.codPersona != null && !this.codPersona.equals(other.codPersona))) {
            return false;
        }
        if ((this.codUsuario == null && other.codUsuario != null) || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario))) {
            return false;
        }
        if ((this.codRol == null && other.codRol != null) || (this.codRol != null && !this.codRol.equals(other.codRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsPersonaUsuarioPK[ codPersona=" + codPersona + ", codUsuario=" + codUsuario + ", codRol=" + codRol + " ]";
    }
    
}
