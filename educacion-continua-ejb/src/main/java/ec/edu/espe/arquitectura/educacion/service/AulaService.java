/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import ec.edu.espe.arquitectura.educacion.dao.InsAulaFacade;
import ec.edu.espe.arquitectura.educacion.model.InsAula;
import java.util.List;
/**
 *
 * @author Daniel
 */
@Stateless
@LocalBean
public class AulaService {

    @EJB
    private InsAulaFacade aulaFacade;
    public List<InsAula> obtenerTodos() {
        return this.aulaFacade.findAll();
    }

    public InsAula buscar(String cod){
        return this.aulaFacade.find(cod);
    }
}
