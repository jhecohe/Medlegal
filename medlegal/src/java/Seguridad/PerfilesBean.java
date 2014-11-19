/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad;

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
public class PerfilesBean {

    /**
     * Creates a new instance of Grado
     */
    private String nombre;
    
    public PerfilesBean() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregar(){
        Inserciones insertar = new Inserciones();
        insertar.agregarPerfil(nombre);
    }
    
    public List roloesLista(){
        Listados listas = new Listados();
        List roles = listas.listaPerfiles();
        return roles;
    }
    
    public void modificar(RowEditEvent event) {
        Object riesgo = (Object) event.getObject();
        //System.out.println("Codigo del riesgo:  " + riesgo.getIdriesgo() + "  Descripcion:  " + riesgo.getDescripcion());
        Actualizar actualizar = new Actualizar();
        //actualizar.riesgoModificar(riesgo);
    }    
}
