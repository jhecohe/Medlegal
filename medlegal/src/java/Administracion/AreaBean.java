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
public class AreaBean {

    /**
     * Creates a new instance of Departamento
     */
    private String nombre;
    private int idseccional;
    private List seccionallist;
    
    public AreaBean() {
       
    }

    public int getIdseccional() {
        return idseccional;
    }

    public void setIdseccional(int idseccional) {
        this.idseccional = idseccional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregar(){
        boolean respuesta;
        Inserciones insertar = new Inserciones();
        respuesta = insertar.agregarArea(nombre, idseccional);
        if(respuesta == false){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "'El enfoque "+ nombre +"' ya a sido  creado"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", nombre +" a sido creada correctamente."));
        }
    }
    
    public List getSeccionallist() {
        Listados listas = new Listados();
        List seccionallist = listas.listaSeccional();
        return seccionallist;
    }
    
    public List getAreaLista(){
        Listados listas = new Listados();
        List areas= listas.listaArea();
        return areas;
    }
    
    public void modificar(RowEditEvent event) {
        Object objeto = (Object) event.getObject();
        Actualizar actualizar = new Actualizar();
        actualizar.areaModificar(objeto);
    }
}
