/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;
import ec.edu.espe.arquitectura.educacion.dao.InsMatriculaFacade;
import ec.edu.espe.arquitectura.educacion.model.InsMatricula;
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
public class MatriculaService {
    @EJB
    private InsMatriculaFacade facade;
    public List<InsMatricula> obtenerTodos() {
        return this.facade.findAll();
    }

    public InsMatricula buscar(String cod){
        return this.facade.find(cod);
    }
     public List<InsMatricula> obtenerPorAlumno(String codAlumno) {
        return this.facade.PorAlumno(codAlumno);
    }
     public void crear(InsMatricula matricula)
     {
         facade.create(matricula);
     }
     public void eliminar(InsMatricula matricula)
     {
         facade.remove(matricula);
     }
     
      public void modificar(InsMatricula matricula)
     {
         facade.edit(matricula);
     }
      
      public List<InsMatricula> obtenerPorAlumno(String codigo,String estado) {
        return this.facade.PorAlumno(codigo,estado);
    }

}
