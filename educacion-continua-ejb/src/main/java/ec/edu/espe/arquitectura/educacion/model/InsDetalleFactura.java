/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "ins_detalle_factura")
public class InsDetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_DETALLE", nullable = false)
    private Integer codigo;

    @Column(name = "VALOR_UNITARIO", nullable = false, precision = 6, scale = 4)
    private BigDecimal valorUnitario;
    
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    
    @Column(name = "DESCUENTO", nullable = false, precision = 6, scale = 4)
    private BigDecimal descuento;
    
    @Column(name = "VALOR_TOTAL", nullable = false, precision = 6, scale = 4)
    private BigDecimal valorTotal;
    
    @JoinColumn(name = "COD_MATRICULA", referencedColumnName = "COD_MATRICULA")
    @ManyToOne
    private InsMatricula insMatricula;
    
    @JoinColumn(name = "COD_FACTURA", referencedColumnName = "COD_FACTURA")
    @ManyToOne
    private InsFactura insFactura;

    public InsDetalleFactura() {
    }

    public InsDetalleFactura(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public InsMatricula getInsMatricula() {
        return insMatricula;
    }

    public void setInsMatricula(InsMatricula insMatricula) {
        this.insMatricula = insMatricula;
    }

    public InsFactura getInsFactura() {
        return insFactura;
    }

    public void setInsFactura(InsFactura insFactura) {
        this.insFactura = insFactura;
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
        if (!(object instanceof InsDetalleFactura)) {
            return false;
        }
        InsDetalleFactura other = (InsDetalleFactura) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsDetalleFactura[ codDetalle=" + codigo + " ]";
    }
    
}
