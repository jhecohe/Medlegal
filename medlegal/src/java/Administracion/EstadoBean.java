/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import Utilidades.Actualizar;
import Utilidades.Inserciones;
import Utilidades.Listados;
import Utilidades.iniciarHibernate;
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
public class EstadoBean {

    /**
     * Creates a new instance of Departamento
     */
    private String nombre;
    
    public EstadoBean() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregar(){
        boolean respuesta;
        Inserciones inser = new Inserciones();
        respuesta = inser.agregarEstado(nombre);
        if(respuesta == false){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "'El estado "+ nombre +"' ya a sido  creado"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", nombre +" a sido creada correctamente."));
        }
    }
    
    public List estadoLista(){
        Listados listas = new Listados();
        List estados = listas.listaEstado();
        return estados;
    }
    
    public void modificar(RowEditEvent event) {
        Object obje = (Object) event.getObject();
        Actualizar actualizar = new Actualizar();
        actualizar.estadoModificar(obje);
    }
}
