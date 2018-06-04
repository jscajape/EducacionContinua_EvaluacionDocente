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
public enum EstadoPrerequisitoEnum {
    
    ACT	("ACTIVO"),
    INA("INACTIVO"),
    OCU("OCUPADA"),
    DES("DESOCPADA");

    String texto;

    private EstadoPrerequisitoEnum(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
