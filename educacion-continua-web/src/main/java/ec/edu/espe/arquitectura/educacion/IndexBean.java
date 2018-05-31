/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion;

import ec.edu.espe.arquitectura.educacion.dao.SegUsuarioFacade;
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
public class IndexBean implements Serializable {

    private String codigoUsuario;
    private String clave;

    @Inject
    private AutenticacionService autenticacionService;
    @Inject
    private UsuarioSesionBean usuarioSessionBean;
    @Inject
    private SegUsuarioFacade segUsuarioFacade;

    public String login() {

        String hashtext = "";
        
//      ENCRIPTACION CLAVE
//        try {
//            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
//            byte[] array = md.digest(this.clave.getBytes());
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < array.length; ++i) {
//                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
//            }
//            hashtext = sb.toString();
//            FacesUtil.addMessageInfo("La clave generada fue:"+hashtext);
//        } catch (Exception e) {}
        
        
        SegUsuario usuario = this.autenticacionService.login(this.codigoUsuario, this.clave);
        if (usuario != null) {
            this.usuarioSessionBean.setUsuario(usuario);
            return usuario.getSegPerfil().getNombre();
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
