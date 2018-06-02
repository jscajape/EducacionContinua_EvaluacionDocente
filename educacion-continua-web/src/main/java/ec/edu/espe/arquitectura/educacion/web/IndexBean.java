/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.web;

import ec.edu.espe.arquitectura.educacion.model.SegUsuario;
import ec.edu.espe.arquitectura.educacion.service.AutenticacionService;
import ec.edu.espe.arquitectura.educacion.web.util.FacesUtil;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Hendrix
 */
@Named
@ViewScoped
public class IndexBean implements Serializable{
    
    private String codigoUsuario;
    private String clave;
    
    @Inject
    private AutenticacionService autenticacionService;
    @Inject 
    private UsuarioSesionBean usuarioSessionBean;
    
    public String login() {
        SegUsuario usuario = this.autenticacionService.login(this.codigoUsuario, this.clave);
        if (usuario!=null) {
            this.usuarioSessionBean.setUsuario(usuario);
            return "persona";
        } else {
            FacesUtil.addMessageError(null, "Los datos ingresados son incorrectos");
            return "index";
        }
    }
    
    public String logout() {
        this.usuarioSessionBean.setUsuario(null);
        return "index";
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    
}
