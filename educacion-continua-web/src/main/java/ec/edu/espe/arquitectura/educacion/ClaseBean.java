/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion;

import ec.edu.espe.arquitectura.educacion.enums.EstadoClaseEnum;
import ec.edu.espe.arquitectura.educacion.model.InsArea;
import ec.edu.espe.arquitectura.educacion.model.InsClase;
import ec.edu.espe.arquitectura.educacion.model.InsClasePK;
import ec.edu.espe.arquitectura.educacion.model.InsCurso;
import ec.edu.espe.arquitectura.educacion.model.InsPersona;
import ec.edu.espe.arquitectura.educacion.model.InsPersonaUsuario;
import ec.edu.espe.arquitectura.educacion.service.InsAreaServ;
import ec.edu.espe.arquitectura.educacion.service.InsClaseServ;
import ec.edu.espe.arquitectura.educacion.service.InsCursoServ;
import ec.edu.espe.arquitectura.educacion.service.InsPersonaService;
import ec.edu.espe.arquitectura.educacion.service.InsPersonaUsuarioService;
import ec.edu.espe.arquitectura.educacion.web.util.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class ClaseBean extends BaseBean implements Serializable {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")}
    private List<InsClase> clases;
    private InsClase clase;
    private InsClase claseselect;
    private InsArea area;
    private List<InsArea> areas;
    private Integer codarea;
    private Integer codcurso;
    private boolean mostrar;
    private InsCurso curso;
    private List<InsCurso> cursos;
    private String estado;
    private String modalidad;
    private List<InsPersona> personas;
    private InsPersona persona;
    private String codigoProf;
    private Date date3;
    private List<InsClase> maximo;
    private List<InsPersonaUsuario> personUsuario;

    private InsClasePK clasepk;
    @Inject
    private InsClaseServ claseserv;
    @Inject
    private InsAreaServ areaserv;
    @Inject
    private InsCursoServ cursoserv;
    @Inject
    private InsPersonaService personaserv;
    @Inject
    private InsPersonaUsuarioService personausuarioserv;

    @PostConstruct
    public void init() {
        /*  */
        this.areas = this.areaserv.obtenerTodos();
        this.clase = new InsClase();
        this.clases = new ArrayList<>();
        this.area = new InsArea();
        this.curso = new InsCurso();
        this.persona = new InsPersona();
        this.mostrar = false;
        this.codarea = 1;
        this.estado = " ";
        this.modalidad = " ";
        this.clasepk = new InsClasePK();
        this.maximo=new ArrayList<InsClase>();

    }

    public boolean isMostrar() {
        return mostrar;
    }

    public InsClasePK getClasepk() {
        return clasepk;
    }

    public void setClasepk(InsClasePK clasepk) {
        this.clasepk = clasepk;
    }

    public List<InsPersona> Profesores() {
        this.personUsuario = this.personausuarioserv.obtenerPorRol("R002");

        List<InsPersona> p = new ArrayList<InsPersona>();

        for (int i = 0; i < this.personUsuario.size(); i++) {
            System.out.println(this.personUsuario.get(i).getCodigo().getCodPersona());
            InsPersona temp = this.personaserv.obtenerPorCodigo(this.personUsuario.get(i).getCodigo().getCodPersona());
            p.add(temp);
        }

        return p;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    public Integer getCodcurso() {
        return codcurso;
    }

    public String convertir(String codmax) {

        String sSubCadena = codmax.substring(0, 3);
        String nSubCadena = codmax.substring(4, 8);
        int num = Integer.parseInt(nSubCadena);
        num++;
        nSubCadena = String.valueOf(num);
        String cadtotal = sSubCadena + nSubCadena;
       
        return cadtotal;
    }

    public void IngresaDatos() {
      //  String newCod=convertir(maximo.get(0).getCodigo().getCodClase());
        this.maximo = this.claseserv.buscarMaximo();
        clasepk.setCodCurso(codcurso);
        clasepk.setCodClase(maximo.get(0).getCodigo().getCodClase());
        this.persona.setCodigo(codigoProf);
        this.clase.setInsPersona(persona);
        this.clase.setCodigo(this.clasepk);
    }

    public void setCodcurso(Integer codcurso) {
        this.codcurso = codcurso;
    }

    public List<InsPersonaUsuario> getPersonUsuario() {
        return personUsuario;
    }

    public void setPersonUsuario(List<InsPersonaUsuario> personUsuario) {
        this.personUsuario = personUsuario;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public List<InsPersona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<InsPersona> personas) {
        this.personas = personas;
    }

    public InsPersona getPersona() {
        return persona;
    }

    public void setPersona(InsPersona persona) {
        this.persona = persona;
    }

    public String getCodigoProf() {
        return codigoProf;
    }

    public void setCodigoProf(String codigoProf) {
        this.codigoProf = codigoProf;
    }

    public Boolean getMostrar() {
        return mostrar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMostrar(Boolean mostrar) {
        this.mostrar = mostrar;
    }

    public List<InsArea> getAreas() {
        return areas;
    }

    public void setAreas(List<InsArea> areas) {
        this.areas = areas;
    }

    public InsArea getArea() {
        return area;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }

    public void setArea(InsArea area) {
        this.area = area;
    }

    public Integer getCodarea() {
        return codarea;
    }

    public void setCodarea(Integer codarea) {
        this.codarea = codarea;
    }

    public InsCurso getCurso() {
        return curso;
    }

    public void setCurso(InsCurso curso) {
        this.curso = curso;
    }

    public List<InsCurso> getCursos() {
        return cursos;
    }

    public void setCursos(List<InsCurso> cursos) {
        this.cursos = cursos;
    }

    public List<InsClase> getClases() {
        return clases;
    }

    public void setClases(List<InsClase> clases) {
        this.clases = clases;
    }

    public InsClase getClase() {
        return clase;
    }

    public void setClase(InsClase clase) {
        this.clase = clase;
    }

    public InsClase getClaseselect() {
        return claseselect;
    }

    public void setClaseselect(InsClase claseselect) {
        this.claseselect = claseselect;
    }

    public Date getDate3() {
        return date3;
    }

    public void filtro() {
        this.cursos = this.cursoserv.buscarporArea(codarea);
        mostrar = true;

    }

    @Override
    public void agregar() {
        this.clase = new InsClase();
        super.agregar();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.clase = new InsClase();
        this.clase.setFecIni(this.claseselect.getFecIni());
        this.clase.setFecFin(this.claseselect.getFecFin());
        this.clase.setCodigo(new InsClasePK());
        this.clase.setModalidad(this.claseselect.getModalidad());
    }

    @Override
    public void detalles() {
        super.detalles();
        this.clase = this.clase;
    }

    public void cancelar() {
        super.reset();

        this.clase = new InsClase();
    }

    public void guardar() {

        IngresaDatos();
        try {
            if (this.enAgregar) {
                this.claseserv.crear(this.clase);
                FacesUtil.addMessageInfo("Se agreg\u00f3 el item al men\u00fa: " + this.clase.getModalidad());

            } else {
                this.claseserv.modificar(this.clase);
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.clase.setCodigo(new InsClasePK());
        this.clase = new InsClase();
        this.clases = this.claseserv.obtenerTodos();
    }

    public EstadoClaseEnum[] getTiposClases() {
        return EstadoClaseEnum.values();
    }

}
