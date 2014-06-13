/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import UtilPersistencia.Inserciones;
import UtilPersistencia.Listados;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
        Inserciones insertar = new Inserciones();
        insertar.agregarRegional(nombre);
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
