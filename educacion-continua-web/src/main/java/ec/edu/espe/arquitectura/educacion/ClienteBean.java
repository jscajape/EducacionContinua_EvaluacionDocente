/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion;


import ec.edu.espe.arquitectura.educacion.model.InsCliente;
import ec.edu.espe.arquitectura.educacion.service.ClienteService;
import ec.edu.espe.arquitectura.educacion.web.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named
@ViewScoped
public class ClienteBean extends BaseBean implements Serializable {
    
    private List<InsCliente> clientes;

    private InsCliente cliente;

    private InsCliente clienteSel;

    @Inject
    private ClienteService clienteService;

    @PostConstruct
    public void init() {
        this.clientes = this.clienteService.obtenerTodos();
        this.cliente = new InsCliente();
    }

    public List<InsCliente> getclientes() {
        return clientes;
    }

    @Override
    public void agregar() {
        this.cliente = new InsCliente();
        super.agregar();
        
    }

    @Override
    public void modificar() {
        super.modificar();
        this.cliente = new InsCliente();
        this.cliente.setRazonSocial(this.clienteSel.getRazonSocial());
        this.cliente.setCorreo(this.clienteSel.getCorreo());
        this.cliente.setNumDocumento(this.clienteSel.getNumDocumento());
        this.cliente.setDireccion(this.clienteSel.getDireccion());
        this.cliente.setTelefono(this.clienteSel.getTelefono());
        this.cliente.setEstado(this.clienteSel.getEstado());
    }

    @Override
    public void detalles() {
        super.detalles();
        this.cliente = this.clienteSel;
    }

    public void cancelar() {
        super.reset();
        this.cliente = new InsCliente();
    }

    public void guardar() {
        try {
            this.clienteService.crear(this.cliente);
            FacesUtil.addMessageInfo("Se agregó el cliente: " + this.cliente.getRazonSocial() + " " + this.cliente.getNumDocumento());
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.cliente = new InsCliente();
        this.clientes = this.clienteService.obtenerTodos();
    }

    public InsCliente getCliente() {
        return cliente;
    }

    public void setCliente(InsCliente cliente) {
        this.cliente = cliente;
    }

    public InsCliente getClienteSel() {
        return clienteSel;
    }

    public void setClienteSel(InsCliente clienteSel) {
        this.clienteSel = clienteSel;
    }

    public List<InsCliente> getClientes() {
        return clientes;
    }
    
}
