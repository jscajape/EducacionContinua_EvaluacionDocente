/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion;

import ec.edu.espe.arquitectura.educacion.enums.EstadoCursoEnum;
import ec.edu.espe.arquitectura.educacion.model.InsCurso;
import ec.edu.espe.arquitectura.educacion.service.InsCursoServ;
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
public class CursoBean extends BaseBean implements Serializable{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")}
    private List<InsCurso> cursos;
    private InsCurso curso;
    private InsCurso cursosel;

    public List<InsCurso> getCursos() {
        return cursos;
    }

    public void setCursos(List<InsCurso> cursos) {
        this.cursos = cursos;
    }

    public InsCurso getCurso() {
        return curso;
    }

    public void setCurso(InsCurso curso) {
        this.curso = curso;
    }

    public InsCurso getCursosel() {
        return cursosel;
    }

    public void setCursosel(InsCurso cursosel) {
        this.cursosel = cursosel;
    }

    public InsCursoServ getCursoserv() {
        return cursoserv;
    }

    public void setCursoserv(InsCursoServ cursoserv) {
        this.cursoserv = cursoserv;
    }
    
    
    
    @Inject
    private InsCursoServ cursoserv;
    
    @PostConstruct
    public void init(){
        this.cursos=this.cursoserv.obtenerTodos();
        this.curso=new InsCurso();
    }

    
     @Override
    public void agregar() {
        this.curso = new InsCurso();
        super.agregar();       
    }

    @Override
    public void modificar() {
        super.modificar();
        this.curso = new InsCurso();
        this.curso.setCosto(this.cursosel.getCosto());
        this.curso.setDescripcion(this.cursosel.getDescripcion());
        this.curso.setEstado(this.cursosel.getEstado());
        this.curso.setHorasDuracion(this.cursosel.getHorasDuracion());
    }

    @Override
    public void detalles() {
        super.detalles();
        this.curso= this.curso;
    }

    public void cancelar() {
        super.reset();
        this.curso= new InsCurso();
    }
   

    public void guardar() {
        try {
            if (this.enAgregar) {
                this.cursoserv.crear(this.curso);
                FacesUtil.addMessageInfo("Se agreg\u00f3 el item al men\u00fa: " + this.curso.getDescripcion());
            } else {
                this.cursoserv.modificar(this.curso);
                FacesUtil.addMessageInfo("Se modific\u00f3 el item del men\u00fa con el nombre: " + this.curso.getDescripcion());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.curso = new InsCurso();
        this.cursos = this.cursoserv.obtenerTodos();
    }
public EstadoCursoEnum[] getTiposCursos(){
        return EstadoCursoEnum.values();
    }
     public void eliminar() {
        try {
            //this.cursoserv.eliminar(this.cursosel.getCodigo());
            this.cursos= this.cursoserv.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro.");
            this.cursosel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }
    
}
