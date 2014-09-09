/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import UtilPersistencia.Actualizar;
import UtilPersistencia.Inserciones;
import UtilPersistencia.Listados;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author jacs
 */
@ManagedBean
@RequestScoped
public class NombreProcesoBean {

    /**
     * Creates a new instance of Departamento
     */
    private String nombre;
    private int idtipopro;
    
    public NombreProcesoBean() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdtipopro() {
        return idtipopro;
    }

    public void setIdtipopro(int idtipopro) {
        this.idtipopro = idtipopro;
    }

    public void agregar(){
        boolean respuesta;
        Inserciones insertar = new Inserciones();
        respuesta = insertar.agregarNombreProceso(nombre, idtipopro);
        if(respuesta == false){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "'El nombre de proceso "+ nombre +"' ya a sido  creado"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", nombre +" a sido creada correctamente."));
        }
    }
    
    public List  nombreProList (){
        Listados listas = new Listados();
        List nombres = listas.listaNombreproceso();
        return nombres;        
    }
    
    public List  tipoProList (){
        Listados listas = new Listados();
        List tipos = listas.listaTipoproceso();
        return tipos;        
    }
    
    public void modificar(RowEditEvent event) {
        Object obje = (Object) event.getObject();        
        Actualizar actualizar = new Actualizar();
        actualizar.nombreProModificar(obje);
    }
}
