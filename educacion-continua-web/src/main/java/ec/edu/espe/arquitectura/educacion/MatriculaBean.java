/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion;

import ec.edu.espe.arquitectura.educacion.model.InsArea;
import ec.edu.espe.arquitectura.educacion.model.InsClase;
import ec.edu.espe.arquitectura.educacion.model.InsFactura;
import ec.edu.espe.arquitectura.educacion.model.InsMatricula;
import ec.edu.espe.arquitectura.educacion.model.InsPersona;
import ec.edu.espe.arquitectura.educacion.service.FacturaService;
import ec.edu.espe.arquitectura.educacion.service.InsAreaServ;
import ec.edu.espe.arquitectura.educacion.service.InsClaseService;
import ec.edu.espe.arquitectura.educacion.service.InsPersonaService;
import ec.edu.espe.arquitectura.educacion.service.MatriculaService;
import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Daniel
 */
@Named
@ViewScoped
public class MatriculaBean implements Serializable {

    private List<InsClase> clases;
    private InsPersona alumno;
    private List<InsMatricula> matriculasAlumno;
    private List<InsClase> clasesAgregardas;
    private InsClase clase;
    private InsClase claseAdd;
    private InsMatricula claseMat;

    private List<InsArea> areas;
    private Integer codArea;
    private InsMatricula matricula;
    private Boolean pagos;
    private List<InsFactura> facturasAlumno;
    private InsFactura factura;
    

 

    @Inject
    private UsuarioSesionBean usuario;
    @Inject
    private InsClaseService claseService;
    @Inject
    private MatriculaService matriculaService;
    @Inject
    private InsAreaServ areaService;
    @Inject
    private InsPersonaService personaService;
    @Inject
    private FacturaService facturaService;
    

    @PostConstruct
    public void init() {
        this.areas = this.areaService.obtenerTodos();
        this.clasesAgregardas = new ArrayList<>();
        this.alumno = this.personaService.obtenerPorCodigo(usuario.getUsuario().getCodigo());
        this.matriculasAlumno = this.matriculaService.obtenerPorAlumno(this.alumno.getCodigo());
        this.pagos=false;

    }

    
    public void cargarClases() {
        this.clases = this.claseService.obtenerClasesArea(this.codArea);
        //System.out.println(this.clases.size());

    }

    public void onRowUnselect(UnselectEvent event) {

    }

    public void agregarClase() {
        if (this.clase != null) {
            int asd = this.clasesAgregardas.stream().filter(x -> x.getCodigo().getCodClase().
                    equals(this.clase.getCodigo().getCodClase())).
                    collect(Collectors.toList()).size();
            asd += this.matriculasAlumno.stream().filter(x -> x.getInsClase().getCodigo().getCodClase().
                    equals(this.clase.getCodigo().getCodClase())).
                    collect(Collectors.toList()).size();

            if (asd == 0) {
                this.clasesAgregardas.add(this.clase);
            }
        }

    }

    public void guardar() {
        FacesMessage msg;

        try {
            clasesAgregardas.forEach(x -> {
                this.matricula = new InsMatricula();
                this.matricula.setEstado("M");
                this.matricula.setFechaRealiza(new Date());
                this.matricula.setInsClase(x);
                this.matricula.setInsPersona(this.alumno);
                this.matriculaService.crear(this.matricula);

            });
            this.matriculasAlumno = this.matriculaService.obtenerPorAlumno(this.alumno.getCodigo());
            this.claseAdd = null;
            this.clasesAgregardas = new ArrayList<>();
            this.matricula = null;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Matricula exitosa", "");

        } catch (Exception ex) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear matricula", "");

        }
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public String estadoMatrincula(String estado) {
        String est;
        switch (estado) {
            case "M":
                est = "Matricula por pagar";
                break;
            case "R":
                est = "Curso reprobado";
                break;
            case "A":
                est = "Curso aprobado";
                break;
            case "P":
                est = "Curso Activo";
                break;
            default:
                est = "INDEFINIDO";
                break;

        }
        return est;
    }

    public void cancelar() {
        this.clasesAgregardas = new ArrayList<>();
        this.claseAdd = new InsClase();

    }

    public void quitarClase() {
        this.clasesAgregardas.remove(this.clase);
        System.out.println(clasesAgregardas.size());
    }

    public void quitarMatricula() {
        FacesMessage msg = null;

        if (this.claseMat != null) {
            try {
                if (/*claseMat.getInsClase().getFecIni().before(new Date()) &&/*/"M".equals(claseMat.getEstado())) {
                    this.matriculaService.eliminar(claseMat);
                    this.matriculasAlumno = this.matriculaService.obtenerPorAlumno(this.alumno.getCodigo());
                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado", "");

                }
            } catch (Exception ex) {
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar", "");

            }
            FacesContext.getCurrentInstance().addMessage(null, msg);

        }
    }

    public String formatoFecha(Date date) {
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        String s = formatter.format(date);
        return s;

    }

    public List<InsClase> getClases() {
        return clases;
    }

    public void setClases(List<InsClase> clases) {
        this.clases = clases;
    }

    public InsPersona getAlumno() {
        return alumno;
    }

    public void setAlumno(InsPersona alumno) {
        this.alumno = alumno;
    }

    public List<InsMatricula> getMatriculasAlumno() {
        return matriculasAlumno;
    }

    public void setMatriculasAlumno(List<InsMatricula> matriculasAlumno) {
        this.matriculasAlumno = matriculasAlumno;
    }

    public List<InsClase> getClasesAgregardas() {
        return clasesAgregardas;
    }

    public void setClasesAgregardas(List<InsClase> clasesAgregardas) {
        this.clasesAgregardas = clasesAgregardas;
    }

    public InsClase getClase() {
        return clase;
    }

    public void setClase(InsClase clase) {
        this.clase = clase;
    }

    public List<InsArea> getAreas() {
        return areas;
    }

    public void setAreas(List<InsArea> areas) {
        this.areas = areas;
    }

    public Integer getCodArea() {
        return codArea;
    }

    public void setCodArea(Integer codArea) {
        this.codArea = codArea;
    }

    public UsuarioSesionBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioSesionBean usuario) {
        this.usuario = usuario;
    }

    public InsClaseService getClaseService() {
        return claseService;
    }

    public void setClaseService(InsClaseService claseService) {
        this.claseService = claseService;
    }

    public MatriculaService getMatriculaService() {
        return matriculaService;
    }

    public void setMatriculaService(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    public InsAreaServ getAreaService() {
        return areaService;
    }

    public void setAreaService(InsAreaServ areaService) {
        this.areaService = areaService;
    }

    public InsPersonaService getPersonaService() {
        return personaService;
    }

    public void setPersonaService(InsPersonaService personaService) {
        this.personaService = personaService;
    }

    public InsMatricula getMatricula() {
        return matricula;
    }

    public void setMatricula(InsMatricula matricula) {
        this.matricula = matricula;
    }

    public InsClase getClaseAdd() {
        return claseAdd;
    }

    public void setClaseAdd(InsClase claseAdd) {
        this.claseAdd = claseAdd;
    }

    public InsMatricula getClaseMat() {
        return claseMat;
    }

    public void setClaseMat(InsMatricula claseMat) {
        this.claseMat = claseMat;
    }
   public Boolean getPagos() {
        return pagos;
    }

    public void setPagos(Boolean pagos) {
        this.pagos = pagos;
    }   
    public List<InsFactura> getFacturasAlumno() {
        return facturasAlumno;
    }

    public void setFacturasAlumno(List<InsFactura> facturasAlumno) {
        this.facturasAlumno = facturasAlumno;
    }

    public InsFactura getFactura() {
        return factura;
    }

    public void setFactura(InsFactura factura) {
        this.factura = factura;
    }

    public FacturaService getFacturaService() {
        return facturaService;
    }

    public void setFacturaService(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

}
