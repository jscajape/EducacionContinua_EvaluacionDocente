/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion.web;
import ec.edu.espe.arquitectura.educacion.model.EvaPregunta;
import ec.edu.espe.arquitectura.educacion.model.EvaRespuestaPregunta;
import ec.edu.espe.arquitectura.educacion.model.InsClase;
import ec.edu.espe.arquitectura.educacion.model.InsPersonaUsuario;
import ec.edu.espe.arquitectura.educacion.model.SegRol;
import ec.edu.espe.arquitectura.educacion.service.InsClaseService;
import ec.edu.espe.arquitectura.educacion.service.InsPersonaUsuarioService;
import ec.edu.espe.arquitectura.educacion.service.SegRolService;
import ec.edu.espe.arquitectura.educacion.service.EvaPreguntaService;
import ec.edu.espe.arquitectura.educacion.service.InsPersonaService;
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

    //Roles del Usuario
    private String rolBusqueda;
    private List<InsPersonaUsuario> rolesUsuarioPersona;
    private List<SegRol> rolesLista;
    
    //Clases Del Usuario
    private String codClase;
    private List<InsClase> clasesEvaluacion;
    
    //Cuestionario
    private Boolean cuestionarioBand;
    private List<EvaPregunta> evaPreguntas;
    private List<EvaRespuestaPregunta> evaRespuestas;
    private Integer respPregunta;
    
    
    @Inject
    private UsuarioSesionBean usuario;
    
    @Inject
    private InsPersonaUsuarioService perUsService;
    
    @Inject
    private SegRolService rolServicio;
    
    @Inject
    private InsClaseService claseService;
    
    @Inject
    private EvaPreguntaService preguntaService;
    
    @Inject
    private InsPersonaService personaService;
    
    @PostConstruct
    public void init() {
        
        this.cuestionarioBand=false;
        
        //this.rolesUsuarioPersona = this.perUsService.obtenerPorUsuario("1713627071"); //CAMBIAR POR CODIGO DE USUARIO
        this.rolesUsuarioPersona = this.perUsService.obtenerPorUsuario(usuario.getUsuario().getCodigo()); //CAMBIAR POR CODIGO DE USUARIO"1713627071"
        this.rolesLista=this.rolServicio.listaPorId(this.rolesUsuarioPersona);       
        
       String auxRol=rolesLista.get(0).getCodigo();
       this.actualizarClases(auxRol);
       
       
        
    }
      

    public String getRolBusqueda() {
        return rolBusqueda;
    }

    public void setRolBusqueda(String rolBusqueda) {
        this.rolBusqueda = rolBusqueda;
    }    

    public List<SegRol> getRolesLista() {
        return rolesLista;
    }

    public void setRolesLista(List<SegRol> rolesLista) {
        this.rolesLista = rolesLista;
    }

    public List<InsPersonaUsuario> getRolesUsuarioPersona() {
        return rolesUsuarioPersona;
    }

    public void setRolesUsuarioPersona(List<InsPersonaUsuario> rolesUsuarioPersona) {
        this.rolesUsuarioPersona = rolesUsuarioPersona;
    }

    public String getCodClase() {
        return codClase;
    }

    public void setCodClase(String codClase) {
        this.codClase = codClase;
    }

    public List<InsClase> getClasesEvaluacion() {
        return clasesEvaluacion;
    }

    public void setClasesEvaluacion(List<InsClase> clasesEvaluacion) {
        this.clasesEvaluacion = clasesEvaluacion;
    }

    public Boolean getCuestionarioBand() {
        return cuestionarioBand;
    }

    public void setCuestionarioBand(Boolean cuestionarioBand) {
        this.cuestionarioBand = cuestionarioBand;
    }

    public List<EvaPregunta> getEvaPreguntas() {
        return evaPreguntas;
    }

    public void setEvaPreguntas(List<EvaPregunta> evaPreguntas) {
        this.evaPreguntas = evaPreguntas;
    }

    public List<EvaRespuestaPregunta> getEvaRespuestas() {
        return evaRespuestas;
    }

    public void setEvaRespuestas(List<EvaRespuestaPregunta> evaRespuestas) {
        this.evaRespuestas = evaRespuestas;
    }

    public Integer getRespPregunta() {
        return respPregunta;
    }

    public void setRespPregunta(Integer respPregunta) {
        this.respPregunta = respPregunta;
    }
    
    
    
       
    
    public void actualizarClases(String rol)
    {
        //this.clasesEvaluacion=this.claseService.obtenerTodos();
        
        if(rol.compareTo("R001")==0)
        {
            //Estudiante
            this.clasesEvaluacion=this.claseService.obtenerClasesMatricula(usuario.getUsuario().getCodigo());
        }
        else
        {
            if(rol.compareTo("R002")==0)
            {
                //Docente
                this.clasesEvaluacion=this.claseService.obtenerClasesDocente(usuario.getUsuario().getCodigo());
            }
            else
            {
                if(rol.compareTo("R004")==0)
                {
                    //Directivo
                    this.clasesEvaluacion=this.claseService.obtenerTodos();
                }
                else
                {
                    //Resto de Roles
                    this.clasesEvaluacion=null;
                }
            }
        }
        
        this.cuestionarioBand=false;
        
    }
    
    
    public void cargarCuestionario()
    {
        this.evaPreguntas=preguntaService.cargarCuestionario(this.rolBusqueda, "EVA0001");
        //this.evaPreguntas=preguntaService.todas();
        System.out.println("A ver si trae preguntas!");
        
        
        for(int i=0;i<evaPreguntas.size();i++)
        {
            //System.out.println(evaPreguntas.get(i).getEnunciado());
            //evaRespuestas.add(new EvaRespuestaPregunta());
        }
        
        this.cuestionarioBand=true;
    }
    
    public void guardarEvaluacion()
    {
        
        this.cuestionarioBand=false;        
    }
    
    public void guardarRespuesta(Integer numIndex)
    {
        //this.evaRespuestas.get(numIndex).setRespuesta(respPregunta);
    }
    
    
}
