/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;

import ec.edu.espe.arquitectura.educacion.dao.InsHorarioFacade;
import ec.edu.espe.arquitectura.educacion.model.InsClase;
import ec.edu.espe.arquitectura.educacion.model.InsHorario;
import ec.edu.espe.arquitectura.educacion.model.InsHorarioPK;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Daniel
 */
@Stateless
@LocalBean
public class HorarioService {
 @EJB
    private InsHorarioFacade horarioFacade;
    public List<InsHorario> obtenerTodos() {
        return this.horarioFacade.findAll();
    }
    public List<InsHorario> buscarPorClase(InsClase clase)
    {
        return this.horarioFacade.buscarPorClase(clase);
      
    }
    public void crear(InsHorario horario) {
        
        this.horarioFacade.create(horario);
        
    }
    public InsHorario buscar(InsHorarioPK pk)
    {
        return this.horarioFacade.find(pk);
    }
    
    public void modificar(InsHorario horario) {
        this.horarioFacade.edit(horario);
    }
    
    public void Eliminar(InsHorario horario) {
        this.horarioFacade.remove(horario);
    }
    

}
