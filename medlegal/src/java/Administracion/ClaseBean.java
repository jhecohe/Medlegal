/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import Utilidades.Actualizar;
import Utilidades.Inserciones;
import Utilidades.Listados;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author jacs
 */
@ManagedBean
@RequestScoped
public class ClaseBean {

    /**
     * Creates a new instance of ClaseBean
     */
    private String nombre;
    private boolean modificar = false;
    
    public ClaseBean() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isModificar() {
        return modificar;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }
    
    public void agregar(){
        Inserciones insertar = new Inserciones();
        insertar.agregarClase(nombre);
    }
    
    public List claseLista(){
        Listados listas = new Listados();
        List clases = listas.listaClase();
        return clases;
    }
    
    public void modificar(RowEditEvent event) {
        Object riesgo = (Object) event.getObject();
        //System.out.println("Codigo del riesgo:  " + riesgo.getIdriesgo() + "  Descripcion:  " + riesgo.getDescripcion());
        Actualizar actualizar = new Actualizar();
        //actualizar.riesgoModificar(riesgo);
    }
    
    public void visible(){
        if(modificar == false){
            modificar = true;
        }else
            modificar = false;
    }
}
