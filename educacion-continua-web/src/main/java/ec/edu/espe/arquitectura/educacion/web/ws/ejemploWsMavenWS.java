/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.web.ws;

import ec.edu.espe.arquitectura.educacion.ws.ejemploWsMaven;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Andrés
 */
@WebService(serviceName = "ejemploWsMavenWS")
public class ejemploWsMavenWS {

    @EJB
    private ejemploWsMaven ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "prueba")
    public String prueba(@WebParam(name = "x") String x) {
        return ejbRef.prueba(x);
    }
    
}
