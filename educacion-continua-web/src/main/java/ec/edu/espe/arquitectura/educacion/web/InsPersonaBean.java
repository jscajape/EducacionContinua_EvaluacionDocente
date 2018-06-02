/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.web;

import ec.edu.espe.arquitectura.educacion.enums.EstadoPersonaEnum;
import ec.edu.espe.arquitectura.educacion.enums.EstadoUsuarioEnum;
import ec.edu.espe.arquitectura.educacion.model.InsPersona;
import ec.edu.espe.arquitectura.educacion.model.SegUsuario;
import ec.edu.espe.arquitectura.educacion.service.InsPersonaService;
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
public class InsPersonaBean extends BaseBean implements Serializable {
    private List<InsPersona> insPersonas;

    private InsPersona insPersona;

    private InsPersona insPersonaSel;
    
    private SegUsuario segUsuario;
    
    private SegUsuario segUsuarioSel;
    
    private String Estado;

    @Inject
    private InsPersonaService insPersonaService;
    
    @Inject
    private SegUsuarioService segUsuarioService;

    @PostConstruct
    public void init() {
        this.insPersonas = this.insPersonaService.obtenerTodos();
        this.insPersona = new InsPersona();
        this.segUsuario = new SegUsuario();
    }
    
    @Override
    public void agregar() {
        this.insPersona = new InsPersona();
        this.insPersona.setEstado(EstadoPersonaEnum.ACT);
        this.segUsuario = new SegUsuario();
        this.segUsuario.setFechaCreacion(new Date());
        this.segUsuario.setEstado(EstadoUsuarioEnum.ACT);
        this.segUsuario.setFechaUltimoAcceso(null);
        List<String> stringsAleatorios = new ArrayList<>(10);
        for (int i = 0; i < 10; i++)
            stringsAleatorios.add(UUID.randomUUID().toString());
        String claveGenerada = "";
        for (int i = 0; i < 10; i++)
            claveGenerada += stringsAleatorios.get(i);
        this.segUsuario.setClave(claveGenerada);
        this.segUsuario.setIntentosErroneos(0);
        super.agregar();
        
    }
    
    @Override
    public void modificar() {
        super.modificar();
        this.insPersona = new InsPersona();
        this.insPersona.setCodigo(this.insPersonaSel.getCodigo());
        this.insPersona.setNombre(this.insPersonaSel.getNombre());
        this.insPersona.setApellido(this.insPersonaSel.getApellido());
        this.insPersona.setTipo(this.insPersonaSel.getTipo());
        this.insPersona.setDireccion(this.insPersonaSel.getDireccion());
        this.insPersona.setTelefono(this.insPersonaSel.getTelefono());
        this.insPersona.setGenero(this.insPersonaSel.getGenero());
        this.insPersona.setFecNac(this.insPersonaSel.getFecNac());
        if(Estado.compareTo("ACT") == 0)
            this.insPersona.setEstado(EstadoPersonaEnum.ACT);
        else
            this.insPersona.setEstado(EstadoPersonaEnum.INA);
        
        this.segUsuario = this.segUsuarioService.obtenerPorCodigo(insPersona.getCodigo());

    }

    @Override
    public void detalles() {
        super.detalles();
        this.insPersona = this.insPersonaSel;
    }

    public void cancelar() {
        super.reset();
        this.insPersona = new InsPersona();
    }

    public void guardar() {
        this.segUsuario.setCodigo(this.insPersona.getCodigo());
        this.segUsuario.setNombre(this.insPersona.getNombre());
        try {
            this.insPersonaService.crear(this.insPersona);
            FacesUtil.addMessageInfo("Se agregó el cliente: " + this.insPersona.getNombre() + " " + this.insPersona.getApellido());
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.insPersona = new InsPersona();
        this.insPersonas = this.insPersonaService.obtenerTodos();
    }

    public List<InsPersona> getInsPersonas() {
        return insPersonas;
    }

    public void setInsPersonas(List<InsPersona> insPersonas) {
        this.insPersonas = insPersonas;
    }

    public InsPersona getInsPersona() {
        return insPersona;
    }

    public void setInsPersona(InsPersona insPersona) {
        this.insPersona = insPersona;
    }

    public InsPersona getInsPersonaSel() {
        return insPersonaSel;
    }

    public void setInsPersonaSel(InsPersona insPersonaSel) {
        this.insPersonaSel = insPersonaSel;
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
    
    
    
}
