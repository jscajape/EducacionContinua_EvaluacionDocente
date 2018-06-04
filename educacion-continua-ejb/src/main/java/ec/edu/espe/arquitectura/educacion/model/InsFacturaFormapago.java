/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author js_cm
 */
@Entity
@Table(name = "ins_factura_formapago")
public class InsFacturaFormapago implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_INS_FACTURA_FORMAPAGO", nullable = false)
    private Integer codigo;
    
    @Column(name = "FORMA_PAGO", nullable = false, length = 3)
    private String formaPago;
    
    @Column(name = "VALOR", nullable = false, precision = 6, scale = 4)
    private BigDecimal valor;
    
    @JoinColumn(name = "COD_FACTURA", referencedColumnName = "COD_FACTURA", nullable = false)
    @ManyToOne
    private InsFactura insFactura;

    public InsFacturaFormapago() {
    }

    public InsFacturaFormapago(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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
        if (!(object instanceof InsFacturaFormapago)) {
            return false;
        }
        InsFacturaFormapago other = (InsFacturaFormapago) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.educacion.model.InsFacturaFormapago[ codInsFacturaFormapago=" + codigo + " ]";
    }
    
}
