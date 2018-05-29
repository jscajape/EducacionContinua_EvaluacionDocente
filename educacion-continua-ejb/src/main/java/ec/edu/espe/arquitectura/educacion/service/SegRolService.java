/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.service;

import ec.edu.espe.arquitectura.educacion.dao.InsPersonaUsuarioFacade;
import ec.edu.espe.arquitectura.educacion.dao.SegRolFacade;
import ec.edu.espe.arquitectura.educacion.model.InsPersonaUsuario;
import ec.edu.espe.arquitectura.educacion.model.SegRol;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Andrés
 */
@Stateless
@LocalBean
public class SegRolService {
    
    @EJB
    private SegRolFacade segRolFacade;
    
    public SegRol porId(String id) {
        return this.segRolFacade.find(id);
    }
    
    public List<SegRol> todos()
    {
        return this.segRolFacade.findAll();
    }
    
    public List<SegRol> listaPorId(List<InsPersonaUsuario> lista)
    {
        
        List<SegRol> listaReturn=this.todos();
        int band=0;
        for(int i=0;i<listaReturn.size();i++)
        {
            for(int j=0;j<lista.size();j++)
            {
                if(listaReturn.get(i).getCodigo().compareTo(lista.get(j).getCodigo().getCodRol())==0)
                {
                    band=1;
                    break;
                }
            }
            
            if(band==0)
            {
                listaReturn.remove(i);
                i--;
            }
            
            band=0;            
        }
        
        return listaReturn;
    }
    
}
