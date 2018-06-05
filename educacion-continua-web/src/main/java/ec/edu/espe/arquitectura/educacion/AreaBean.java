/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion;

import ec.edu.espe.arquitectura.educacion.enums.EstadoAreaEnum;
import ec.edu.espe.arquitectura.educacion.model.InsArea;
import ec.edu.espe.arquitectura.educacion.service.InsAreaServ;
import ec.edu.espe.arquitectura.educacion.web.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ALCI
 */
@Named
@ViewScoped


public class AreaBean extends BaseBean implements Serializable{
    
    private List<InsArea> insareas;
    private InsArea insarea;
    private InsArea insareasel;
    private String codarea;

    public String getCodarea() {
        return codarea;
    }

    public void setCodarea(String codarea) {
        this.codarea = codarea;
    }
    
     @Inject
    private InsAreaServ areaServ;

    @PostConstruct
    public void init() {
       this.insareas = this.areaServ.obtenerTodos();
        this.insarea = new InsArea();
    }

    public List<InsArea> getInsAreas() {
        return insareas;
    }

    public void setInsAreas(List<InsArea> InsAreas) {
        this.insareas = InsAreas;
    }

    public InsArea getInsArea() {
        return insarea;
    }

    public void setInsArea(InsArea InsArea) {
        this.insarea = InsArea;
    }

    public InsArea getInsAreaSel() {
        return insareasel;
    }

    public void setInsAreaSel(InsArea InsAreaSel) {
        this.insareasel = InsAreaSel;
    }

    public InsAreaServ getAreaServ() {
        return areaServ;
    }

    public void setAreaServ(InsAreaServ areaServ) {
        this.areaServ = areaServ;
    }

    public List<InsArea> getclientes() {
        return insareas;
    }

    @Override
    public void agregar() {
        this.insarea = new InsArea();
        super.agregar();       
    }

    @Override
    public void modificar() {
        super.modificar();
        this.insarea = new InsArea();
        this.insarea.setCodigo(this.insareasel.getCodigo());
        this.insarea.setDescripcion(this.insareasel.getDescripcion());
        this.insarea.setEstado(this.insareasel.getEstado());
    }

    @Override
    public void detalles() {
        super.detalles();
        this.insarea = this.insareasel;
    }

    public void cancelar() {
        super.reset();
        this.insarea= new InsArea();
    }
   

    public void guardar() {
        try {
            if (this.enAgregar) {
                this.areaServ.crear(this.insarea);
                FacesUtil.addMessageInfo("Se agreg\u00f3 el item al men\u00fa: " + this.insarea.getDescripcion());
            } else {
                this.areaServ.modificar(this.insarea);
                FacesUtil.addMessageInfo("Se modific\u00f3 el item del men\u00fa con el nombre: " + this.insarea.getDescripcion());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.insarea = new InsArea();
        this.insareas = this.areaServ.obtenerTodos();
    }
public EstadoAreaEnum[] getTiposArea(){
        return EstadoAreaEnum.values();
    }
     public void eliminar() {
        try {
            this.areaServ.eliminar(this.insareasel.getCodigo());
            this.insareas= this.areaServ.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro.");
            this.insareasel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }

       
}
