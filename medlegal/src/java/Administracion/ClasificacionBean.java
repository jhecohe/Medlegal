/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import Logica.Actualizar;
import Logica.Inserciones;
import Logica.Listados;
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
public class ClasificacionBean {

    /**
     * Creates a new instance of ClasificacionBean
     */
    
    private String descripcion;
    private boolean modificar = false;
    
    public ClasificacionBean() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isModificar() {
        return modificar;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }
    
    public void agregar(){
        boolean respuesta;
        Inserciones inser = new Inserciones();
        respuesta = inser.agregarClasificacion(descripcion);
        if(respuesta == false){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "'La clasificacion "+ descripcion +"' ya a sido  creado"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", descripcion +" a sido creada correctamente."));
        }
    }
    
    public List clasificacionListado (){
        Listados listas = new Listados();
        List clasificaciones = listas.listaClasificacion();
        return clasificaciones;
    }
    
    public void modificar(RowEditEvent event) {
        Object clasificacion = (Object) event.getObject();
        Actualizar actualizar = new Actualizar();
        actualizar.clasificacionModificar(clasificacion);
    }
    
}
