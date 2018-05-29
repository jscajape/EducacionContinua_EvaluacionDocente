/*
 * Hades Cruise
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Hades Cruise Corp.
 */
package ec.edu.espe.arquitectura.educacion.web;

import ec.edu.espe.arquitectura.educacion.enums.EstadoUsuarioEnum;
import ec.edu.espe.arquitectura.educacion.model.SegPerfil;
import ec.edu.espe.arquitectura.educacion.model.SegUsuario;
import ec.edu.espe.arquitectura.educacion.service.SegPerfilService;
import ec.edu.espe.arquitectura.educacion.service.SegUsuarioService;
import ec.edu.espe.arquitectura.educacion.web.util.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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
public class SegUsuarioBean extends BaseBean implements Serializable {

    private List<SegUsuario> segUsuarios;

    private List<SegPerfil> segPerfiles;

    private SegUsuario segUsuario;

    private SegUsuario segUsuarioSel;

    private String estado;

    @Inject
    private SegUsuarioService SegUsuarioService;
    @Inject
    private SegPerfilService segPerfilService;

    @PostConstruct
    public void init() {
        this.segUsuarios = this.SegUsuarioService.obtenerTodos();
        this.segPerfiles = this.segPerfilService.obtenerTodos();
        this.segUsuario = new SegUsuario();
    }

    @Override
    public void agregar() {
        this.segUsuario = new SegUsuario();
        this.segUsuario.setEstado(EstadoUsuarioEnum.ACT);
        this.segUsuario.setFechaCreacion(new Date());
        this.segUsuario.setFechaUltimoAcceso(null);
        List<String> stringsAleatorios = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            stringsAleatorios.add(UUID.randomUUID().toString());
        }
        String claveGenerada = "";
        for (int i = 0; i < 10; i++) {
            claveGenerada += stringsAleatorios.get(i);
        }
        this.segUsuario.setClave(claveGenerada);
        this.segUsuario.setIntentosErroneos(0);
        this.estado = this.segUsuario.getEstado().name();
        super.agregar();

    }

    @Override
    public void modificar() {
        super.modificar();
        this.segUsuario = new SegUsuario();
        this.segUsuario.setCodigo(this.segUsuarioSel.getCodigo());
        this.segUsuario.setNombre(this.segUsuarioSel.getNombre());
        this.segUsuario.setSegPerfil(this.segUsuarioSel.getSegPerfil());
        this.segUsuario.setCorreoElectronico(this.segUsuarioSel.getCorreoElectronico());
        this.segUsuario.setEstado(this.segUsuarioSel.getEstado());
        this.segUsuario.setIntentosErroneos(this.segUsuarioSel.getIntentosErroneos());
        this.segUsuario.setClave(this.segUsuarioSel.getClave());
        this.segUsuario.setFechaCreacion(this.segUsuarioSel.getFechaCreacion());
        this.segUsuario.setFechaUltimoAcceso(this.segUsuarioSel.getFechaUltimoAcceso());
    }

    @Override
    public void detalles() {
        super.detalles();
        this.segUsuario = this.segUsuarioSel;
    }

    public void cancelar() {
        super.reset();
        this.segUsuario = new SegUsuario();
    }

    public void guardar() {
        if (this.estado.compareTo("ACT") == 0) {
            this.segUsuario.setEstado(EstadoUsuarioEnum.ACT);
        } else if (this.estado.compareTo("INA") == 0) {
            this.segUsuario.setEstado(EstadoUsuarioEnum.INA);
        } else if (this.estado.compareTo("SUS") == 0) {
            this.segUsuario.setEstado(EstadoUsuarioEnum.SUS);
        } else if (this.estado.compareTo("BLO") == 0) {
            this.segUsuario.setEstado(EstadoUsuarioEnum.BLO);
        } else if (this.estado.compareTo("PEN") == 0) {
            this.segUsuario.setEstado(EstadoUsuarioEnum.PEN);
        }
        try {
            this.SegUsuarioService.crear(this.segUsuario);
            FacesUtil.addMessageInfo("Se creo usuario para: " + this.segUsuario.getNombre());
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.segUsuario = new SegUsuario();
        this.segUsuarios = this.SegUsuarioService.obtenerTodos();
    }

    public List<SegUsuario> getSegUsuarios() {
        return segUsuarios;
    }

    public void setSegUsuarios(List<SegUsuario> segUsuarios) {
        this.segUsuarios = segUsuarios;
    }

    public SegUsuario getSegUsuario() {
        return segUsuario;
    }

    public void setSegUsuario(SegUsuario segUsuario) {
        this.segUsuario = segUsuario;
    }

    public SegUsuario getSegUsuarioSel() {
        return segUsuarioSel;
    }

    public void setSegUsuarioSel(SegUsuario segUsuarioSel) {
        this.segUsuarioSel = segUsuarioSel;
    }

    public List<SegPerfil> getSegPerfiles() {
        return segPerfiles;
    }

    public void setSegPerfiles(List<SegPerfil> segPerfiles) {
        this.segPerfiles = segPerfiles;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
