/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion;

import ec.edu.espe.arquitectura.educacion.enums.EstadoClienteEnum;
import ec.edu.espe.arquitectura.educacion.enums.EstadoFacturaEnum;
import ec.edu.espe.arquitectura.educacion.model.InsCliente;
import ec.edu.espe.arquitectura.educacion.model.InsDetalleFactura;
import ec.edu.espe.arquitectura.educacion.model.InsFactura;
import ec.edu.espe.arquitectura.educacion.model.InsMatricula;
import ec.edu.espe.arquitectura.educacion.service.DetalleFacturaService;
import ec.edu.espe.arquitectura.educacion.service.FacturaService;
import ec.edu.espe.arquitectura.educacion.service.InsMatriculaService;
import ec.edu.espe.arquitectura.educacion.service.ClienteService;
import ec.edu.espe.arquitectura.educacion.web.util.FacesUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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

    private String documento;

    private String codigoAlumno;

    private float subtotal;
    
    private float iva;
    
    private float total;
    
    private Date fecha;
    
    private InsFactura insfactura;
    
    private InsDetalleFactura detallefactura;
    
    private List<InsFactura> facturas;
    
    
    
    private String auxiliarMostrar;
    
   // private List<String> secuencial;

    private List<InsMatricula> matriculas;
    private boolean mostrarDatos;

    private InsMatricula insMatricula;

    @Inject
    private ClienteService clienteService;
    @Inject
    private InsMatriculaService matriculaService;
    @Inject
    private FacturaService facturaService;
    @Inject
    private DetalleFacturaService detalleService;

    @PostConstruct
    public void init() {
        this.clientes = this.clienteService.obtenerTodos();
        this.cliente = new InsCliente();
        this.mostrarDatos = false;
        this.codigoAlumno = "";
        this.subtotal = 0;
        this.matriculas = new ArrayList<>(); 
        this.iva=0;
        this.total=0;
        this.fecha=new Date();
        this.insfactura=new InsFactura();
        this.detallefactura=new InsDetalleFactura();
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
        this.cliente.setCodigo(this.clienteSel.getCodigo());
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
            if (this.enAgregar) {
                this.clienteService.crear(this.cliente);
                FacesUtil.addMessageInfo("Se agreg\u00f3 el item al men\u00fa: " + this.cliente.getRazonSocial());
            } else {
                this.clienteService.modificar(this.cliente);
                FacesUtil.addMessageInfo("Se modific\u00f3 el item del men\u00fa con el nombre: " + this.cliente.getRazonSocial());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.cliente = new InsCliente();
        this.clientes = this.clienteService.obtenerTodos();
    }
     
      public void guardarFactura() {
        String codigoaux=this.facturas.get(this.facturas.size()).getCodigo();
        String num=codigoaux.substring(6,codigoaux.length());
        try {
           this.insfactura.setCodigo("FAC00017");
            this.insfactura.setDescuento(BigDecimal.ZERO);
            this.insfactura.setEstado(EstadoFacturaEnum.PAG);
            this.insfactura.setInsCliente(cliente);
            this.insfactura.setFechaEmision(new Date());
            this.insfactura.setIva(BigDecimal.valueOf(this.iva));
            this.insfactura.setObservacion("");
            this.insfactura.setSubtotal(BigDecimal.valueOf(this.subtotal));
            this.insfactura.setTotal(BigDecimal.valueOf(this.total));
            this.facturaService.crear(this.insfactura);
            this.detallefactura.setCantidad(1);
            this.detallefactura.setDescuento(BigDecimal.ZERO);
            this.detallefactura.setInsFactura(insfactura);
            this.detallefactura.setInsMatricula(insMatricula);
            this.detallefactura.setValorTotal(BigDecimal.valueOf(this.total));
            this.detallefactura.setValorUnitario((this.insMatricula.getInsClase().getInsCurso().getCosto()));
            this.detalleService.crear(detallefactura);
            FacesUtil.addMessageInfo("Se agregó la factura: " + this.insfactura.getCodigo());
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la información\u00f3n");
        }
        super.reset();
        this.insfactura = new InsFactura();
        this.facturas = this.facturaService.obtenerTodos();
    }

    public void buscarcliente() {
        this.mostrarDatos = true;
        this.cliente = this.clienteService.buscarCliente(documento);
        this.fecha=new Date();
    
    }

    public void buscaralumno() {
        this.matriculas = this.matriculaService.obtenerPorAlumno(codigoAlumno);
        float aux = 0;
        float aux1;
        float aux2;
        for (InsMatricula p : matriculas) {
            aux += p.getInsClase().getInsCurso().getCosto().floatValue();
        }
        this.subtotal=aux;
        aux1=(float)(aux*0.12);
        this.iva=aux1;
        aux2=aux+aux1;
        this.total=aux2;

    }
    
    public EstadoClienteEnum[] getTiposCliente(){
        return EstadoClienteEnum.values();
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public boolean isMostrarDatos() {
        return mostrarDatos;
    }

    public void setMostrarDatos(boolean mostrarDatos) {
        this.mostrarDatos = mostrarDatos;
    }

    public String getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(String codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public InsMatricula getInsMatricula() {
        return insMatricula;
    }

    public void setInsMatricula(InsMatricula insMatricula) {
        this.insMatricula = insMatricula;
    }

    public List<InsMatricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<InsMatricula> matriculas) {
        this.matriculas = matriculas;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public InsFactura getInsfactura() {
        return insfactura;
    }

    public void setInsfactura(InsFactura insfactura) {
        this.insfactura = insfactura;
    }

    public InsDetalleFactura getDetallefactura() {
        return detallefactura;
    }

    public void setDetallefactura(InsDetalleFactura detallefactura) {
        this.detallefactura = detallefactura;
    }

    public List<InsFactura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<InsFactura> facturas) {
        this.facturas = facturas;
    }

    public String getAuxiliarMostrar() {
        return auxiliarMostrar;
    }

    public void setAuxiliarMostrar(String auxiliarMostrar) {
        this.auxiliarMostrar = auxiliarMostrar;
    }
    
    
    
            
}
