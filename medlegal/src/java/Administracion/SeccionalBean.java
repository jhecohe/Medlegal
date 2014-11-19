/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import Utilidades.Inserciones;
import Utilidades.Listados;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author jacs
 */
@ManagedBean
@RequestScoped
public class SeccionalBean {
    
    private String nombre;
    private int idregional;
    List regionallist;
    Listados listas;

    /**
     * Creates a new instance of Ciudad
     */
    public SeccionalBean() {
        listas = new Listados();
    }

    public int getIdregional() {
        return idregional;
    }

    public void setIdregional(int idregional) {
        this.idregional = idregional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregar(){
        Inserciones insertar = new Inserciones();
        insertar.agregarSeccional(nombre, idregional);
    }
    
    public List getRegionallist() {
        if (regionallist == null) {
            regionallist = listas.listaRegional();
        }
        return regionallist;
    }
    
    public List getSeccionallist(){
        List seccionales = listas.listaSeccional();
        return seccionales;
    }
    
    public void modificar(){
            
    }
}
