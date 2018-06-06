/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion;

import ec.edu.espe.arquitectura.educacion.enums.EstadoFacturaEnum;
import ec.edu.espe.arquitectura.educacion.model.InsFactura;
import ec.edu.espe.arquitectura.educacion.service.FacturaService;
import ec.edu.espe.arquitectura.educacion.web.util.FacesUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named
@ViewScoped
public class FacturaBean extends BaseBean implements Serializable {

    private List<InsFactura> facturas;

    private InsFactura factura;

    private InsFactura facturaSel;

    private String numfactura;

    @Inject
    private FacturaService facturaService;

    @PostConstruct
    public void init() {
        this.facturas = this.facturaService.obtenerTodos();
        this.factura = new InsFactura();
    }

    public FacturaBean() {
    }

    public List<InsFactura> getfacturas() {
        return facturas;
    }

    @Override
    public void agregar() {
        this.factura = new InsFactura();
        super.agregar();

    }

    @Override
    public void modificar() {
        super.modificar();
       /* this.factura = new InsFactura();
        this.factura.setCodigo(this.facturaSel.getCodigo());
        this.factura.setDescuento(BigDecimal.ZERO);
        this.factura.setFechaEmision(new Date());
        this.factura.setInsCliente(this.facturaSel.getInsCliente());
        this.factura.setIva(this.facturaSel.getIva());
        this.factura.setObservacion("");
        this.factura.setSubtotal(this.facturaSel.getSubtotal());
        this.factura.setTotal(this.facturaSel.getTotal());
        this.factura.setEstado(this.facturaSel.getEstado());*/
       

    }

    public void guardar() {

        try {

            //this.factura.setFechaEmision(new Date());
            this.facturaSel.setEstado(EstadoFacturaEnum.ANU);
            this.facturaService.modificar(this.facturaSel);
            
            FacesUtil.addMessageInfo("Se agregó la factura: " + this.factura.getCodigo());
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la información\u00f3n");
        }
        super.reset();
        this.factura = new InsFactura();
        this.facturas = this.facturaService.obtenerTodos();
    }

    public void buscarfactura() {
        this.factura = this.facturaService.buscarFactura(numfactura);
    }

    public void cancelar() {
        super.reset();
        this.factura = new InsFactura();
    }

    public EstadoFacturaEnum[] getTiposFactura() {
        return EstadoFacturaEnum.values();
    }

    public void guardar1() {
        try {
            if (this.enAgregar) {
                this.facturaService.crear(this.factura);
                FacesUtil.addMessageInfo("Se agreg\u00f3 el item al men\u00fa: " + this.factura.getCodigo());
            } else {
                this.facturaService.modificar(this.factura);
                FacesUtil.addMessageInfo("Se modific\u00f3 el item del men\u00fa con el nombre: " + this.factura.getCodigo());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.factura = new InsFactura();
        this.facturas = this.facturaService.obtenerTodos();
    }

    public List<InsFactura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<InsFactura> facturas) {
        this.facturas = facturas;
    }

    public InsFactura getFacturaSel() {
        return facturaSel;
    }

    public void setFacturaSel(InsFactura facturaSel) {
        this.facturaSel = facturaSel;
    }

    public String getNumfactura() {
        return numfactura;
    }

    public void setNumfactura(String numfactura) {
        this.numfactura = numfactura;
    }

    public InsFactura getFactura() {
        return factura;
    }

    public void setFactura(InsFactura factura) {
        this.factura = factura;
    }

}
