/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;


import ec.edu.espe.arquitectura.educacion.dao.InsFacturaFacade;
import ec.edu.espe.arquitectura.educacion.model.InsFactura;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Cristhian
 */
@Stateless
@LocalBean
public class FacturaService {
    
    @EJB
    private InsFacturaFacade facturaFacade;

 public List<InsFactura> obtenerTodos() {
        return this.facturaFacade.findAll();
    }
 
  public void crear(InsFactura factura) {
        this.facturaFacade.create(factura);
    }
  
  public void modificar(InsFactura factura) {
        this.facturaFacade.edit(factura);
    }
  
   public InsFactura buscarFactura (String numfactura){
        InsFactura factura = this.facturaFacade.PorCodigo(numfactura).get(0);
        return factura;
    }
}
