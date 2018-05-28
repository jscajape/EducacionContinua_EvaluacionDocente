/*
 * Hades Cruise
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Hades Cruise Corp.
 */
package ec.edu.espe.arquitectura.educacion.enums;

/**
 *
 * @author Hades Cruise Corp.
 */
public enum EstadoAreaEnum {
    
    ACT	("ACTIVO"),
    INA("INACTIVO"),
    OCU("OCUPADA"),
    DES("DESOCPADA");
    //ABI("ABIERTA");
    private String texto;

    private EstadoAreaEnum(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
