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
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
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
        
    @Inject
    private FranjaService franjaService;
    @Inject
    private AulaService aulaService;
    @Inject
    private HorarioService horarioService;
    
    
    @PostConstruct
    public void init()
    {
        this.franjas=this.franjaService.obtenerTodos();
        this.franja = new InsFranja();
        this.aulas=this.aulaService.obtenerTodos();
        this.aula = new InsAula();
        this.horario = new InsHorario();
       // this.horario.setPk(new InsHorarioPK());
        
        for (InsFranja x : franjas) 
            System.out.println("franja: "+ x);
        for (InsAula x : aulas) 
            System.out.println("aula: "+ x);
    }
      

    
}
