/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.educacion;
import ec.edu.espe.arquitectura.educacion.model.EvaCuestionario;
import ec.edu.espe.arquitectura.educacion.model.EvaEvaluacion;
import ec.edu.espe.arquitectura.educacion.model.EvaPregunta;
import ec.edu.espe.arquitectura.educacion.model.EvaRespuestaCuestionario;
import ec.edu.espe.arquitectura.educacion.model.EvaRespuestaPregunta;
import ec.edu.espe.arquitectura.educacion.model.InsClase;
import ec.edu.espe.arquitectura.educacion.model.InsCurso;
import ec.edu.espe.arquitectura.educacion.model.InsPersona;
import ec.edu.espe.arquitectura.educacion.model.InsPersonaUsuario;
import ec.edu.espe.arquitectura.educacion.model.SegRol;
import ec.edu.espe.arquitectura.educacion.service.EvaDetalleEvaluacionService;
import ec.edu.espe.arquitectura.educacion.service.EvaEvaluacionService;
import ec.edu.espe.arquitectura.educacion.service.InsClaseService;
import ec.edu.espe.arquitectura.educacion.service.InsPersonaUsuarioService;
import ec.edu.espe.arquitectura.educacion.service.SegRolService;
import ec.edu.espe.arquitectura.educacion.service.EvaPreguntaService;
import ec.edu.espe.arquitectura.educacion.service.EvaRespuestaCuestionarioService;
import ec.edu.espe.arquitectura.educacion.service.InsPersonaService;
import java.io.Serializable;
import java.util.ArrayList;
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

    private InsPersona persona;
//Roles del Usuario
    private String rolBusqueda;
    private List<InsPersonaUsuario> rolesUsuarioPersona;
    private List<SegRol> rolesLista;
    
    //Clases Del Usuario
    private String codClase;
    private List<InsClase> clasesEvaluacion;
    private InsClase claseSeleccionada;
    private InsCurso cursoDeClaseSeleccionada;
    private EvaCuestionario evaCuestionario;
    
    //Cuestionario
    private Boolean cuestionarioBand;
    private List<EvaPregunta> evaPreguntas;
    private List<EvaRespuestaPregunta> evaRespuestas =new ArrayList<>();
    private Integer respPregunta;
    private EvaRespuestaCuestionario evaRespCuest;
    private EvaEvaluacion evaEvaluacion;
    
    
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
    
    @Inject
    private EvaRespuestaCuestionarioService respuestaCuestionarioService;
    
    @Inject
    private EvaEvaluacionService evaEvaluacionService;
    
    @Inject
    private EvaDetalleEvaluacionService evaDetEvalService;
    
    @PostConstruct
    public void init() {
        
        this.cuestionarioBand=false;
        
        //this.rolesUsuarioPersona = this.perUsService.obtenerPorUsuario("1713627071"); //CAMBIAR POR CODIGO DE USUARIO
        this.rolesUsuarioPersona = this.perUsService.obtenerPorUsuario(usuario.getUsuario().getCodigo()); //CAMBIAR POR CODIGO DE USUARIO"1713627071"
        this.rolesLista=this.rolServicio.listaPorId(this.rolesUsuarioPersona);     
        
        this.persona=this.personaService.obtenerPorCodigo(usuario.getUsuario().getCodigo());
        
       String auxRol=rolesLista.get(0).getCodigo();
       this.actualizarClases(auxRol);
       
       this.evaEvaluacion=evaEvaluacionService.porId("EVA0001");
        
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

    public InsClase getClaseSeleccionada() {
        return claseSeleccionada;
    }

    public void setClaseSeleccionada(InsClase claseSeleccionada) {
        this.claseSeleccionada = claseSeleccionada;
    }

    public InsPersona getPersona() {
        return persona;
    }

    public void setPersona(InsPersona persona) {
        this.persona = persona;
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
        //System.out.println("a ver si entra!");
        this.claseSeleccionada=this.clasesEvaluacion.get(0);
        this.cuestionarioBand=false;
        
    }
    
    
    public void cargarCuestionario()
    {
        this.evaPreguntas=preguntaService.cargarCuestionario(this.rolBusqueda, this.evaEvaluacion.getCodigo());
        //this.evaPreguntas=preguntaService.todas();
       
        this.evaRespuestas.clear();
        //Para crear lista de respuestas
        System.out.println(evaPreguntas.size());
        for(int i=0;i<evaPreguntas.size();i++)
        {
            this.evaRespuestas.add(new EvaRespuestaPregunta(40+i,0,persona,evaPreguntas.get(i)));
        }
        
        this.evaCuestionario=this.evaPreguntas.get(0).getEvaCuestionario();
        this.cuestionarioBand=true;
    }
    
    public void guardarEvaluacion()
    {
        //evaCuestionario=this.evaPreguntas.get(0).getEvaCuestionario();
        
        //Posibilidad de Errore
        /*EvaRespuestaCuestionario evaRespCuest = new EvaRespuestaCuestionario();
        evaRespCuest.setInsPersona(persona);
        evaRespCuest.setCodigo(new EvaRespuestaCuestionarioPK(persona.getCodigo(),evaEvaluacion.getCodigo(),evaCuestionario.getCodigo(),claseSeleccionada.getCodigo().getCodClase()));
        evaRespCuest.setEvaDetalleEvaluacon(evaDetEvalService.porId(evaCuestionario.getCodigo(), evaEvaluacion.getCodigo()));
        evaRespCuest.setInsClase(claseSeleccionada);
        evaRespCuest.setInsPersona(persona);
        evaRespCuest.setFecha(new Date());
        evaRespCuest.setCalificacionPromedio(BigDecimal.ZERO);*/
        respuestaCuestionarioService.guardarRespuesta(evaRespuestas);
        //.
        
        
        this.cuestionarioBand=false;        
    }
    
    public void guardarRespuesta(Integer numIndex)
    {
        this.evaRespuestas.get(numIndex).setRespuesta(respPregunta); 
        System.out.println("Respuesta seteada: "+this.evaRespuestas.get(numIndex).getRespuesta());
    }
    
    

    public void actualizarDocente(String codigoClase)
    {
        //Para Saber Nombre de Profesor
        for(int i=0;i<clasesEvaluacion.size();i++)
        {
            if(this.clasesEvaluacion.get(i).getCodigo().getCodClase().compareTo(codigoClase)==0)
            {
                this.claseSeleccionada=clasesEvaluacion.get(i);
                this.cursoDeClaseSeleccionada=claseSeleccionada.getInsCurso();
                //System.out.println("Clase DENTRO BUCLE: "+this.claseSeleccionada.getCodigo());
                break;
            }
        }
        //System.out.println("Clase FUERA: "+this.claseSeleccionada.getCodigo()+"  "+codigoClase);        
    }
    
    
}
