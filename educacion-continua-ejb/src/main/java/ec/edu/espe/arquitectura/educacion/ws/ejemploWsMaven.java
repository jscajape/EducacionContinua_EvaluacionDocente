/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.ws;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Andrés
 */
@Stateless
@LocalBean
public class ejemploWsMaven {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public String prueba(String x)
    {
        String resp="";
        resp=x+" Si recibe servicio!";
        return resp;
    }
    
}
