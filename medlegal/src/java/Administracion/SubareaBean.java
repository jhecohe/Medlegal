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
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author jacs
 */
@ManagedBean
@RequestScoped
public class SubareaBean {
    
    private String nombre;
    private int idarea;
    Listados listas;
    private boolean modificar = false;

    /**
     * Creates a new instance of Ciudad
     */
    public SubareaBean() {
        listas = new Listados();
    }

    public int getIdarea() {
        return idarea;
    }

    public void setIdarea(int iddepartamento) {
        this.idarea = iddepartamento;
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
        System.out.println("Estamos en el bean " + nombre + "+ " + idarea);
        Inserciones insertar = new Inserciones();
        insertar.agregarSubArea(idarea, nombre);
    }
    
    public List getArealist() {
        List arealist = listas.listaArea();
        return arealist;
    }
    
    public List subareaLista (){
        Listados listas = new Listados();
        List subs = listas.listaSubarea();
        return subs;
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
