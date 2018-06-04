/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import ec.edu.espe.arquitectura.educacion.enums.EstadoPersonaEnum;
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
@Table(name = "ins_persona")
public class InsPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_PERSONA", nullable = false, length = 20)
    private String codigo;
    
    @Column(name = "NOMBRE", nullable = false, length = 20)
    private String nombre;
    
    @Column(name = "APELLIDO", length = 20)
    private String apellido;
    
    @Column(name = "DIRECCION", nullable = false, length = 50)
    private String direccion;
    
    @Column(name = "TELEFONO", nullable = false, length = 10)
    private String telefono;
    
    @Column(name = "FEC_NAC")
    @Temporal(TemporalType.DATE)
    private Date fecNac;

    @Column(name = "TIPO", length = 3)
    private String tipo;

    @Column(name = "GENERO", length = 3)
    private String genero;

    @Column(name = "ESTADO", length = 3)
    @Enumerated(EnumType.STRING)
    private EstadoPersonaEnum estado;

    public InsPersona() {
    }

    public InsPersona(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public EstadoPersonaEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoPersonaEnum estado) {
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
        if (!(object instanceof InsPersona)) {
            return false;
        }
        InsPersona other = (InsPersona) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsPersona[ codPersona=" + codigo + " ]";
    }
    
}
