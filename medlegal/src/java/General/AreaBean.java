/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import UtilPersistencia.Actualizar;
import UtilPersistencia.Inserciones;
import UtilPersistencia.Listados;
import UtilPersistencia.iniciarHibernate;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;
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
    private boolean datos = false;
    private boolean visible = false;
    
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

    public boolean isDatos() {
        return datos;
    }

    public void setDatos(boolean datos) {
        this.datos = datos;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

 
    
    public void agregar(){
        Inserciones insertar = new Inserciones();
        insertar.agregarArea(nombre, idseccional);
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
    
    public void visible(){
        visible = true;
    }
}
