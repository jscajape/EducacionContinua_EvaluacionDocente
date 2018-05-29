/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.web;
import ec.edu.espe.arquitectura.educacion.model.InsPersonaUsuario;
import ec.edu.espe.arquitectura.educacion.service.InsPersonaUsuarioService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Andrés
 */
@Named
@ViewScoped
public class evaluacionAdminBean implements Serializable {

    private String rolBusqueda;
    private List<InsPersonaUsuario> rolesUsuario;
    
    //private String codClase;
    //private List<InsClase> clasesEvaluacion;
    
    
    @Inject
    private InsPersonaUsuarioService perUsService;
    
    //@Inject
    //private InsClaseService claseService;
    
    @PostConstruct
    public void init() {
        //DESCOMENTAR ESTO:
        this.rolesUsuario = this.perUsService.obtenerPorUsuario("0100967652"); //CAMBIAR POR CODIGO DE USUARIO
        
        //COMENTAR ESTO:
        /*
        SegRol s1=new SegRol();
        s1.setCodigo("EST");
        s1.setNombre("ESTUDIANTE");
        s1.setEstado(EstadoRolEnum.ACT);
        
        SegRol s2=new SegRol();
        s2.setCodigo("EST");
        s2.setNombre("ESTUDIANTE");
        s2.setEstado(EstadoRolEnum.ACT);
        
        this.rolesUsuario.add(s1);
        this.rolesUsuario.add(s1);
        */
    }
    
    

    public String getRolBusqueda() {
        return rolBusqueda;
    }

    public void setRolBusqueda(String rolBusqueda) {
        this.rolBusqueda = rolBusqueda;
    }

    public List<InsPersonaUsuario> getRolesUsuario() {
        return rolesUsuario;
    }

    public void setRolesUsuario(List<InsPersonaUsuario> rolesUsuario) {
        this.rolesUsuario = rolesUsuario;
    }
       
    
    
    
    
}
