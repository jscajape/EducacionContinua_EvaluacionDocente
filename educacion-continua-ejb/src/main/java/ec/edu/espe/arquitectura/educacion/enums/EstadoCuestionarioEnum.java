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
public enum EstadoCuestionarioEnum {
    
    ACT	("ACTIVO"),
    INA("INACTIVO"),
    SUS("SUSPENDIDO"),
    BLO("BLOQUEADO"),
    PEN("PENDIENTE"),
    REV("EN-REVISION");

    String texto;

    private EstadoCuestionarioEnum(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
