/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import UtilPersistencia.Inserciones;
import UtilPersistencia.Listados;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author jacs
 */
@ManagedBean
@RequestScoped
public class RegionalBean {

    /**
     * Creates a new instance of Departamento
     */
    private String nombre;

    public RegionalBean() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregar() {
        boolean respuesta;
        Inserciones insertar = new Inserciones();
        respuesta = insertar.agregarRegional(nombre);
        if(respuesta == false){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "'La regional "+ nombre +"' ya a sido  creado"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", nombre +" a sido creada correctamente."));
        }
    }

    public List listadoRegional() {
        List regionales;
        Listados listados = new Listados();
        regionales = listados.listaRegional();
        return regionales;
    }
    
    public void modificar (){
        
    }
}
