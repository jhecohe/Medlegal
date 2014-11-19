/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import Utilidades.Actualizar;
import Utilidades.Inserciones;
import Utilidades.Listados;
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
public class EnfoqueBean {

    /**
     * Creates a new instance of EnfoqueBean
     */
    private String descripcion;
    private boolean modificar = false;
    
    public EnfoqueBean() {
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
    
    public void agregar (){
        boolean respuesta;
        Inserciones inser = new Inserciones();
        respuesta = inser.agregarEnfoque(descripcion);
        if(respuesta == false){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "'El enfoque "+ descripcion +"' ya a sido  creado"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", descripcion +" a sido creada correctamente."));
        }
    }
    
    public List enfoqueListado(){
        Listados listas = new Listados();
        List enfoques = listas.listaEnfoque();
        return enfoques;
    }
    
    public void modificar(RowEditEvent event) {
        Object enfoque = (Object) event.getObject();
        Actualizar actualizar = new Actualizar();
        actualizar.enfoqueModificar(enfoque);
    }
}
