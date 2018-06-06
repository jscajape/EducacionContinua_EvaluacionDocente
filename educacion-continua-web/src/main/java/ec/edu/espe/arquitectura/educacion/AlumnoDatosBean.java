/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion;

import ec.edu.espe.arquitectura.educacion.model.InsPersona;
import ec.edu.espe.arquitectura.educacion.model.SegUsuario;
import ec.edu.espe.arquitectura.educacion.service.InsPersonaService;
import ec.edu.espe.arquitectura.educacion.service.SegUsuarioService;
import ec.edu.espe.arquitectura.educacion.web.util.FacesUtil;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author js_cm
 */
@Named
@ViewScoped
public class AlumnoDatosBean  extends BaseBean implements Serializable {
    private SegUsuario segUsuario;

    private InsPersona insPersona;

    private Boolean cambiarBoton;
    
    private String codigoUsuario;


    @Inject
    private SegUsuarioService SegUsuarioService;
    @Inject
    private InsPersonaService insPersonaService;
    @Inject
    private UsuarioSesionBean usuarioSesion;

    @PostConstruct
    public void init() {
        this.codigoUsuario = this.usuarioSesion.getUsuario().getCodigo();
        this.segUsuario = this.usuarioSesion.getUsuario();
        this.insPersona = this.insPersonaService.obtenerPorCodigo(this.codigoUsuario);
        this.cambiarBoton = true;
    }
    
    public void guardar() {
        try {
            this.insPersonaService.modificar(this.insPersona);
            this.segUsuario.setNombre(this.insPersona.getNombre()+" "+this.insPersona.getApellido());
            this.SegUsuarioService.modificar(this.segUsuario);
            FacesUtil.addMessageInfo("Se agregó el persona: " + this.insPersona.getNombre() + " " + this.insPersona.getApellido());
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
    }

    public SegUsuario getSegUsuario() {
        return segUsuario;
    }

    public void setSegUsuario(SegUsuario segUsuario) {
        this.segUsuario = segUsuario;
    }

    public InsPersona getInsPersona() {
        return insPersona;
    }

    public void setInsPersona(InsPersona insPersona) {
        this.insPersona = insPersona;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Boolean getCambiarBoton() {
        return cambiarBoton;
    }

    public void setCambiarBoton(Boolean cambiarBoton) {
        this.cambiarBoton = cambiarBoton;
    }
    
    
    
    
}
