/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;

import ec.edu.espe.arquitectura.educacion.dao.InsDetalleFacturaFacade;
import ec.edu.espe.arquitectura.educacion.model.InsDetalleFactura;
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
public class DetalleFacturaService {

  @EJB
    private InsDetalleFacturaFacade facturaFacade;

 public List<InsDetalleFactura> obtenerTodos() {
        return this.facturaFacade.findAll();
    }
 
  public void crear(InsDetalleFactura detallefactura) {
        this.facturaFacade.create(detallefactura);
    }
  
  public void modificar(InsDetalleFactura detallefactura) {
        this.facturaFacade.edit(detallefactura);
    }
  
   public InsDetalleFactura buscarDetalleFactura (String numdetallefactura){
        InsDetalleFactura detallefactura = this.facturaFacade.PorCodigo(numdetallefactura).get(0);
        return detallefactura;
    }
}
