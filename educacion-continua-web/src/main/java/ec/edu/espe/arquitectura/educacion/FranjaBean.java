/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.web;

import ec.edu.espe.arquitectura.educacion.model.InsFranja;
import ec.edu.espe.arquitectura.educacion.service.FranjaService;
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
public class FranjaBean implements Serializable{

    
    private List<InsFranja> franjas;
    private InsFranja franja;
   
    @Inject
    private FranjaService franjaService;

    @PostConstruct
    public void init()
    {
        this.franjas=this.franjaService.obtenerTodos();
        this.franja = new InsFranja();  
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

    public FranjaService getFranjaService() {
        return franjaService;
    }

    public void setFranjaService(FranjaService franjaService) {
        this.franjaService = franjaService;
    }
     
    
 
}
