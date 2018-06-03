/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion;

import ec.edu.espe.arquitectura.educacion.model.InsAula;
import ec.edu.espe.arquitectura.educacion.model.InsFranja;
import ec.edu.espe.arquitectura.educacion.model.InsHorario;
import ec.edu.espe.arquitectura.educacion.model.InsHorarioPK;
import ec.edu.espe.arquitectura.educacion.service.AulaService;
import ec.edu.espe.arquitectura.educacion.service.FranjaService;
import ec.edu.espe.arquitectura.educacion.service.HorarioService;
import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Daniel
 */
@Named
@ViewScoped
public class HorarioBean implements Serializable {
 
    private List<InsFranja> franjas;
    private InsFranja franja;
    private List<InsAula> aulas;
    private InsAula aula;
    private InsHorario horario;
    private List<InsAula> aulasFilt;
        
   
    private ArrayList<String> aulasTipos;
    private String aulaTipo;
    

    @Inject
    private FranjaService franjaService;
    @Inject
    private AulaService aulaService;
    @Inject
    private HorarioService horarioService;
    
    @PostConstruct
    public void init() {
    
        this.franjas = this.franjaService.obtenerTodos();

        this.aulasTipos = new ArrayList<String>();

        this.franja = new InsFranja();
        this.aulas = this.aulaService.obtenerTodos();
        this.aula = new InsAula();
        this.horario = new InsHorario();
        this.horario.setCodigo(new InsHorarioPK());
        this.aulasTipos.add("Auditorios");
        this.aulasTipos.add("Laboratorios");
        this.aulasTipos.add("Normales");
        

    }
      
    public void cargarAulas() {

        if(aulaTipo !=null && !aulaTipo.equals(""))
            aulasFilt=aulas.stream().filter(x -> x.getTipo().equals(
                    aulaTipo.equals("Auditorios")?"AUD":aulaTipo.equals("Laboratorios")?"LAB":"NOR"        
            )).collect(Collectors.toList());
        else
            aulasFilt = new ArrayList<InsAula>();
    
}

    public void guardarHorario() {

        FacesMessage msg;
        msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String formatoHora(Date date) {
        Format formatter = new SimpleDateFormat("HH:mm");
        String s = formatter.format(date);
        return s;
    }

    public List<InsFranja> getFranjas() {
        return franjas;
    }

    public void setFranjas(List<InsFranja> franjas) {
        this.franjas = franjas;
    }

    public InsFranja getFranja() {
        return franja;
    }

    public void setFranja(InsFranja franja) {
        this.franja = franja;
    }

    public List<InsAula> getAulas() {
        return aulas;
    }

    public void setAulas(List<InsAula> aulas) {
        this.aulas = aulas;
    }

    public InsAula getAula() {
        return aula;
    }

    public void setAula(InsAula aula) {
        this.aula = aula;
    }

    public InsHorario getHorario() {
        return horario;
    }

    public void setHorario(InsHorario horario) {
        this.horario = horario;
    }

    public FranjaService getFranjaService() {
        return franjaService;
    }

    public void setFranjaService(FranjaService franjaService) {
        this.franjaService = franjaService;
    }

    public AulaService getAulaService() {
        return aulaService;
    }

    public void setAulaService(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    public HorarioService getHorarioService() {
        return horarioService;
    }

    public void setHorarioService(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    public ArrayList<String> getAulasTipos() {
        return aulasTipos;
    }

    public void setAulasTipos(ArrayList<String> aulasTipos) {
        this.aulasTipos = aulasTipos;
    }

    public String getAulaTipo() {
        return aulaTipo;
    }

    public void setAulaTipo(String aulaTipo) {
        this.aulaTipo = aulaTipo;
    }
     public List<InsAula> getAulasFilt() {
        return aulasFilt;
    }

    public void setAulasFilt(List<InsAula> aulasFilt) {
        this.aulasFilt = aulasFilt;
    }
}
