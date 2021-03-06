/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion;

import ec.edu.espe.arquitectura.educacion.enums.EstadoHorarioEnum;
import ec.edu.espe.arquitectura.educacion.model.InsAula;
import ec.edu.espe.arquitectura.educacion.model.InsFranja;
import ec.edu.espe.arquitectura.educacion.model.InsClase;
import ec.edu.espe.arquitectura.educacion.model.InsHorario;
import ec.edu.espe.arquitectura.educacion.model.InsHorarioPK;
import ec.edu.espe.arquitectura.educacion.service.AulaService;
import ec.edu.espe.arquitectura.educacion.service.FranjaService;
import ec.edu.espe.arquitectura.educacion.service.HorarioService;
import ec.edu.espe.arquitectura.educacion.service.InsClaseService;
import ec.edu.espe.arquitectura.educacion.web.util.FacesUtil;
import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
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
public class HorarioBean extends BaseBean implements Serializable {

    private List<InsFranja> franjas;
    private List<InsAula> aulas;
    private InsHorario horario;
    private List<InsAula> aulasFilt;
    private List<InsHorario> horarios;

    private Integer codigoAula;
    private Integer coigoFranja;

    private List<InsClase> clases;
    private InsClase clase;
    private Boolean isHorario;
    private Boolean isHorarioDet;

    private ArrayList<String> aulasTipos;
    private HashMap<String, String> dias;

    private String aulaTipo;
    private String dia;

    @Inject
    private FranjaService franjaService;

    @Inject
    private HorarioService horarioService;
    @Inject
    private InsClaseService claseService;
    @Inject
    private AulaService aulaService;

    @PostConstruct
    public void init() {
        this.franjas = this.franjaService.obtenerTodos();
        this.clases = this.claseService.obtenerTodos();
        this.aulasTipos = new ArrayList<>();
        this.clase = new InsClase();
        this.aulas = this.aulaService.obtenerTodos();
        this.horario = new InsHorario();
        this.horario.setCodigo(new InsHorarioPK());
        this.dias = new HashMap<>();
        this.dias.put("L", "Lunes");
        this.dias.put("M", "Martes");
        this.dias.put("X", "Miercoles");
        this.dias.put("J", "Jueves");
        this.dias.put("V", "Viernes");
        this.dias.put("S", "Sabado");
        this.dias.put("D", "Domingo");

        this.aulasTipos.add("Auditorios");
        this.aulasTipos.add("Laboratorios");
        this.aulasTipos.add("Normales");
        this.isHorario = false;
        this.isHorarioDet = false;
        this.aulaTipo = "";
    }

    public void cargarAulas() {

        if (this.aulaTipo != null && !this.aulaTipo.equals("")) {
            aulasFilt = aulas.stream().filter(x -> x.getTipo().equals(
                    this.aulaTipo.equals("Auditorios") ? "AUD" : this.aulaTipo.equals("Laboratorios") ? "LAB" : "NOR"
            )).collect(Collectors.toList());
        } else {
            aulasFilt = new ArrayList<InsAula>();
        }

    }

    public void guardarHorario() {

        FacesMessage msg;
        /*  if (this.franja == null || this.aula == null || this.dia.equals("Seleccionar")) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Datos incorrectos.");
        } else {

            String diaTemp = this.dias.entrySet().stream()
                    .filter(e -> e.getKey().equals(this.dia))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse("L");
            this.horario.setDia(diaTemp);
            this.horario.setInsAula(this.aula);
            this.horario.setInsFranja(this.franja);
            this.horario.setInsClase(this.clase);
            this.horario.setEstado(EstadoHorarioEnum.ACT);
            InsHorarioPK pk = new InsHorarioPK();
            pk.setCodAula(this.aula.getCodigo());
            pk.setCodFranja(this.franja.getCodigo());
            this.horario.setCodigo(pk);
            this.horarioService.crear(horario);

            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Horario guardado");

        }
        FacesContext.getCurrentInstance().addMessage(null, msg);**/
    }

    public void verHorario() {
        this.isHorario = true;
        this.isHorarioDet = false;
        System.out.println(this.isHorario);
        if (this.clase != null) {
            this.horarios = this.horarioService.buscarPorClase(this.clase);
        }

    }

    public void verHorarioDet() {
        this.isHorarioDet = true;
        //this.horario.setInsClase(this.clase);
        this.horario = new InsHorario();
        //if (this.clase != null) {
        // this.horario = this.horarioService.buscar(new InsHorarioPK(
        //        this.horario.getInsFranja().getCodigo(), this.horario.getInsAula().getCodigo()));
        //}

    }

    public String horarioDescripcion() {
        return "Seleccionar";
        // return this.horario == null ? "Seleccione" : this.horario.getInsAula().getDescripcion();
    }

    public String horarioFranja() {
        return "Seleccionar";
        //return this.horario == null ? "Seleccione" : (this.formatoHora(this.horario.getInsFranja()));
    }

    public String horarioDia(InsHorario horario) {

        return horario != null ? this.dias.entrySet().stream()
                .filter(e -> e.getKey().equals(horario.getDia()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse("Seleccionar") : "Seleccionar";
    }

    public String formatoHora(InsFranja franja) {
        Format formatter = new SimpleDateFormat("HH:mm");
        String s = formatter.format(franja.getIncio()) + " - " + formatter.format(franja.getFin());
        return s;
    }

    public String formatoFecha(Date date) {
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        String s = formatter.format(date);
        return s;

    }

    public ArrayList<String> diasList() {

        Collection<String> diasValues = this.dias.values();
        return new ArrayList<>(diasValues);

    }

    public void eliminar() {
        FacesMessage msg;
        try {
            this.horarioService.Eliminar(this.horario);
            this.verHorario();
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado Correctamente", "");
            FacesUtil.addMessageInfo("Se elimino el registro.");
            this.horario = null;
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar", "");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void guardar() {
                FacesMessage msg;

        try {

            if (this.codigoAula.equals(null) || this.coigoFranja.equals(null) || this.dia.equals(null)) {
                throw new Exception("Seleccione el aula");
            } else {
                //InsAula tempAul=this.aulaService.buscar(this.codigoAula);
                ;

                this.horario = new InsHorario();
                this.horario.setCodigo(new InsHorarioPK(this.coigoFranja, this.codigoAula));
                this.horario.setInsClase(this.clase);
                this.horario.setDia(this.dias.entrySet().stream()
                        .filter(e -> e.getValue().equals(this.dia))
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .orElse("M"));
                this.horario.setInsAula(this.aulas.stream().
                        filter(x -> x.getCodigo()
                        .equals(this.codigoAula))
                        .findFirst()
                        .get());
                this.horario.setInsFranja(
                        this.franjas.stream().
                                filter(x -> x.getCodigo()
                                .equals(this.coigoFranja))
                                .findFirst()
                                .get());
                this.horario.setEstado(EstadoHorarioEnum.ACT);
                this.horarioService.crear(horario);
                this.horario = null;
                            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Creado Correctamente", "");

            }
        } catch (Exception ex) {
            this.horario = null;
             msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear", "");

        }
        super.reset();
        this.horario = null;
        this.verHorario();
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void onRowSelect(SelectEvent event) {
       
    }

    public void onRowUnselect(UnselectEvent event) {
        
    }

    public List<InsFranja> getFranjas() {
        return franjas;
    }

    public void setFranjas(List<InsFranja> franjas) {
        this.franjas = franjas;
    }

    public List<InsAula> getAulas() {
        return aulas;
    }

    public void setAulas(List<InsAula> aulas) {
        this.aulas = aulas;
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

    public InsClaseService getClaseService() {
        return claseService;
    }

    public void setClaseService(InsClaseService claseService) {
        this.claseService = claseService;
    }

    public Boolean getIsHorario() {
        return isHorario;
    }

    public void setIsHorario(Boolean isHorario) {
        this.isHorario = isHorario;
    }

    public HashMap<String, String> getDias() {
        return dias;
    }

    public void setDias(HashMap<String, String> dias) {
        this.dias = dias;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public List<InsHorario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<InsHorario> horarios) {
        this.horarios = horarios;
    }

    public Boolean getIsHorarioDet() {
        return isHorarioDet;
    }

    public void setIsHorarioDet(Boolean isHorarioDet) {
        this.isHorarioDet = isHorarioDet;
    }
    
    public Integer getCodigoAula() {
        return codigoAula;
    }

    public void setCodigoAula(Integer codigoAula) {
        this.codigoAula = codigoAula;
    }

    public Integer getCoigoFranja() {
        return coigoFranja;
    }

    public void setCoigoFranja(Integer coigoFranja) {
        this.coigoFranja = coigoFranja;
    }
}
