/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion;

import ec.edu.espe.arquitectura.educacion.enums.EstadoUsuarioEnum;
import ec.edu.espe.arquitectura.educacion.model.SegRegistroAcceso;
import ec.edu.espe.arquitectura.educacion.model.SegUsuario;
import ec.edu.espe.arquitectura.educacion.service.AutenticacionService;
import ec.edu.espe.arquitectura.educacion.service.SegRegistroAccesoService;
import ec.edu.espe.arquitectura.educacion.service.SegUsuarioService;
import ec.edu.espe.arquitectura.educacion.web.util.FacesUtil;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
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
    private SegRegistroAcceso segRegistroAcceso;

    @Inject
    private AutenticacionService autenticacionService;
    @Inject
    private UsuarioSesionBean usuarioSessionBean;
    @Inject
    private SegUsuarioService segUsuarioService;
    @Inject
    private SegRegistroAccesoService segRegistroAccesoService;

    public String login() {

        String hashtext = "";
        this.segRegistroAcceso = new SegRegistroAcceso();
        Integer intentosErroneos = 0;
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
            if (usuario.getEstado() == EstadoUsuarioEnum.ACT) {
                this.usuarioSessionBean.setUsuario(usuario);
                usuario.setFechaUltimoAcceso(new Date());
                this.segUsuarioService.modificar(usuario);
                this.LogAcceso(usuario, "Correcto");
                return usuario.getSegPerfil().getNombre();
            } else {
                FacesUtil.addMessageError(null, "Su cuenta se encuentra bloqueada, favor comunicarse con el Administrador del sistema");
                this.LogAcceso(usuario, "Incorrecto");
                return "index";
            }

        } else {
            FacesUtil.addMessageError(null, "Los datos ingresados son incorrectos");
            usuario = this.segUsuarioService.obtenerPorCodigo(codigoUsuario);
            if (usuario != null) {
                usuario.setFechaUltimoAcceso(new Date());
                intentosErroneos = usuario.getIntentosErroneos() + 1;
                if (intentosErroneos == 4) {
                    usuario.setIntentosErroneos(0);
                    usuario.setEstado(EstadoUsuarioEnum.BLO);
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            SegUsuario us = segUsuarioService.obtenerPorCodigo(codigoUsuario);
                            us.setEstado(EstadoUsuarioEnum.ACT);
                            segUsuarioService.modificar(us);
                        }
                    }, 300000);
                } else {
                    usuario.setIntentosErroneos(intentosErroneos);
                }
                this.segUsuarioService.modificar(usuario);
            }
            this.LogAcceso(usuario, "Incorrecto");
            return "index";
        }
    }

    public String logout() {
        this.usuarioSessionBean.setUsuario(null);
        return "index";
    }

    public void LogAcceso(SegUsuario usuario, String resultado) {
        String ip = "";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
            this.segRegistroAcceso.setCodUsuario(codigoUsuario);
            this.segRegistroAcceso.setFecha(new Date());
            this.segRegistroAcceso.setIp(ip);
            this.segRegistroAcceso.setResultado(resultado);
            this.segRegistroAcceso.setTipoAcceso(resultado);
            this.segRegistroAcceso.setFuncionalidad(usuario.getSegPerfil().getNombre());
        } catch (Exception e) {
        }
        this.segRegistroAccesoService.crear(segRegistroAcceso);
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

    public SegRegistroAcceso getSegRegistroAcceso() {
        return segRegistroAcceso;
    }

    public void setSegRegistroAcceso(SegRegistroAcceso segRegistroAcceso) {
        this.segRegistroAcceso = segRegistroAcceso;
    }

}
