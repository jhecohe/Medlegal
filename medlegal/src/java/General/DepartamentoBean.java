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
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author jacs
 */
@ManagedBean
@RequestScoped
public class DepartamentoBean {

    /**
     * Creates a new instance of Departamento
     */
    private String nombre;
    private boolean modificar = false;
    
    public DepartamentoBean() {
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
        insertar.agregarDepartamento(nombre);
    }
    
    public void modificar(RowEditEvent event) {
        Object riesgo = (Object) event.getObject();
        //System.out.println("Codigo del riesgo:  " + riesgo.getIdriesgo() + "  Descripcion:  " + riesgo.getDescripcion());
        Actualizar actualizar = new Actualizar();
        //actualizar.riesgoModificar(riesgo);
    }
    
    public List departamentoList(){
        Listados listas = new Listados();
        List departamentos = new ArrayList(listas.listaDepartamentos());
        return departamentos;
    }
    
    public void visible(){
        if(modificar == false){
            modificar = true;
        }else
            modificar = false;
    }
}
