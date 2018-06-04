/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import ec.edu.espe.arquitectura.educacion.enums.EstadoFacturaEnum;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "ins_factura")
public class InsFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_FACTURA", nullable = false, length = 10)
    private String codigo;
    
    @Column(name = "FECHA_EMISION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    
    @Column(name = "SUBTOTAL", nullable = false, precision = 6, scale = 2)
    private BigDecimal subtotal;
    
    @Column(name = "IVA", nullable = false, precision = 6, scale = 2)
    private BigDecimal iva;

    @Column(name = "DESCUENTO", nullable = false, precision = 6, scale = 2)
    private BigDecimal descuento;

    @Column(name = "TOTAL", nullable = false, precision = 6, scale = 2)
    private BigDecimal total;

    @Column(name = "OBSERVACION", length = 120)
    private String observacion;

    @Column(name = "ESTADO", nullable = false, length = 3)
    @Enumerated(EnumType.STRING)
    private EstadoFacturaEnum estado;
    
    @JoinColumn(name = "COD_CLIENTE", referencedColumnName = "COD_CLIENTE")
    @ManyToOne
    private InsCliente insCliente;

    public InsFactura() {
    }

    public InsFactura(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public EstadoFacturaEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoFacturaEnum estado) {
        this.estado = estado;
    }

    public InsCliente getInsCliente() {
        return insCliente;
    }

    public void setInsCliente(InsCliente insCliente) {
        this.insCliente = insCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsFactura)) {
            return false;
        }
        InsFactura other = (InsFactura) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsFactura[ codFactura=" + codigo + " ]";
    }
    
}
