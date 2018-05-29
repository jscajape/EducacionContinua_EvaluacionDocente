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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "eva_respuesta_pregunta", catalog = "educacion_continua", schema = "")
public class EvaRespuestaPregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_REGISTRO_RESPUESTAS", nullable = false)
    private Integer codigo;
    
    @Column(name = "RESPUESTA", nullable = false)
    private int respuesta;
    
    @JoinColumn(name = "COD_PERSONA", referencedColumnName = "COD_PERSONA")
    @ManyToOne
    private InsPersona insPersona;
    
    @JoinColumn(name = "COD_PREGUNTA", referencedColumnName = "COD_PREGUNTA", nullable = false)
    @ManyToOne
    private EvaPregunta evaPregunta;

    public EvaRespuestaPregunta() {
    }
    
    public EvaRespuestaPregunta(Integer cod, int resp, InsPersona per, EvaPregunta evaPre ) {
        
        this.codigo=cod;
        this.respuesta=resp;
        this.insPersona=per;
        this.evaPregunta=evaPre;
        
    }

    public EvaRespuestaPregunta(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public InsPersona getInsPersona() {
        return insPersona;
    }

    public void setInsPersona(InsPersona insPersona) {
        this.insPersona = insPersona;
    }

    public EvaPregunta getEvaPregunta() {
        return evaPregunta;
    }

    public void setEvaPregunta(EvaPregunta evaPregunta) {
        this.evaPregunta = evaPregunta;
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
        if (!(object instanceof EvaRespuestaPregunta)) {
            return false;
        }
        EvaRespuestaPregunta other = (EvaRespuestaPregunta) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.EvaRespuestaPregunta[ codRegistroRespuestas=" + codigo + " ]";
    }
    
}
