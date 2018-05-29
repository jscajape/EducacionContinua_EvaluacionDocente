/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion;

import ec.edu.espe.arquitectura.educacion.BaseBean;
import ec.edu.espe.arquitectura.educacion.model.InsClase;
import ec.edu.espe.arquitectura.educacion.service.InsClaseServ;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ALCI
 */
@Named
@ViewScoped
public class ClaseBean extends BaseBean implements Serializable{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")}
    private List<InsClase> clases;
    private InsClase clase;
    private InsClase claseselect;
    
    @Inject
    private InsClaseServ claseserv;
    
    @PostConstruct
    public void init(){
        this.clases=this.claseserv.obtenerTodos();
        this.clase=new InsClase();
    }
    
}
