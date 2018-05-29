/*
 * Hades Cruise
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Hades Cruise Corp.
 */
package ec.edu.espe.arquitectura.educacion.web;

import ec.edu.espe.arquitectura.educacion.model.SegUsuario;
import ec.edu.espe.arquitectura.educacion.service.SegUsuarioService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author js_cm
 */
@Named
@ViewScoped
public class SegUsuarioBean extends BaseBean implements Serializable {
    
    private List<SegUsuario> segUsuarios;

    private SegUsuario segUsuario;

    private SegUsuario segUsuarioSel;

    @Inject
    private SegUsuarioService SegUsuarioService;

    @PostConstruct
    public void init() {
        this.segUsuarios = this.SegUsuarioService.obtenerTodos();
        this.segUsuario = new SegUsuario();
    }

//    public List<Cliente> getclientes() {
//        return clientes;
//    }
//
//    @Override
//    public void agregar() {
//        this.cliente = new Cliente();
//        this.cliente.setClientePK(new ClientePK());
//        super.agregar();
//        
//    }
//
//    @Override
//    public void modificar() {
//        super.modificar();
//        this.cliente = new Cliente();
//        this.cliente.setClientePK(this.clienteSel.getClientePK());
//        this.cliente.setNombre(this.clienteSel.getNombre());
//        this.cliente.setApellido(this.clienteSel.getApellido());
//        this.cliente.setPais(this.clienteSel.getPais());
//        this.cliente.setDireccion(this.clienteSel.getDireccion());
//        this.cliente.setTelefono(this.clienteSel.getTelefono());
//        this.cliente.setCorreoElectronico(this.clienteSel.getCorreoElectronico());
//    }
//
//    @Override
//    public void detalles() {
//        super.detalles();
//        this.cliente = this.clienteSel;
//    }
//
//    public void cancelar() {
//        super.reset();
//        this.cliente.setClientePK(new ClientePK());
//        this.cliente = new Cliente();
//    }
//
//    public void guardar() {
//        try {
//            this.clienteService.crear(this.cliente);
//            FacesUtil.addMessageInfo("Se agregó el cliente: " + this.cliente.getNombre() + " " + this.cliente.getApellido());
//        } catch (Exception ex) {
//            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
//        }
//        super.reset();
//        this.cliente.setClientePK(new ClientePK());
//        this.cliente = new Cliente();
//        this.clientes = this.clienteService.obtenerTodos();
//    }
//
//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
//
//    public Cliente getClienteSel() {
//        return clienteSel;
//    }
//
//    public void setClienteSel(Cliente clienteSel) {
//        this.clienteSel = clienteSel;
//    }
//
//    public List<Cliente> getClientes() {
//        return clientes;
//    }

    public List<SegUsuario> getSegUsuarios() {
        return segUsuarios;
    }

    public void setSegUsuarios(List<SegUsuario> segUsuarios) {
        this.segUsuarios = segUsuarios;
    }

    public SegUsuario getSegUsuario() {
        return segUsuario;
    }

    public void setSegUsuario(SegUsuario segUsuario) {
        this.segUsuario = segUsuario;
    }

    public SegUsuario getSegUsuarioSel() {
        return segUsuarioSel;
    }

    public void setSegUsuarioSel(SegUsuario segUsuarioSel) {
        this.segUsuarioSel = segUsuarioSel;
    }
    
    
}
