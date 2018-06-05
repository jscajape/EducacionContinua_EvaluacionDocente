/*
 * Hades Cruise
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Hades Cruise Corp.
 */
package ec.edu.espe.arquitectura.educacion.service;

import ec.edu.espe.arquitectura.educacion.dao.InsClienteFacade;
import ec.edu.espe.arquitectura.educacion.model.InsCliente;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Hades Cruise Corp.
 */
@Stateless
@LocalBean
public class ClienteService {

    @EJB
    private InsClienteFacade clienteFacade;
    
    public List<InsCliente> obtenerTodos() {
        return this.clienteFacade.findAll();
    }
    
    
    public void crear(InsCliente cliente) {
        this.clienteFacade.create(cliente);
    }
    
    public void modificar(InsCliente cliente) {
        this.clienteFacade.edit(cliente);
    }
    
    public void eliminar(String codigo) {
        InsCliente cliente = this.clienteFacade.find(codigo);
        this.clienteFacade.remove(cliente);
    }
    
    public InsCliente buscarCliente (String documento){
        InsCliente cliente = this.clienteFacade.PorCliente(documento).get(0);
        return cliente;
    }
    
   
}