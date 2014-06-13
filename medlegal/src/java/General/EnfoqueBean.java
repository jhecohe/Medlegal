/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import UtilPersistencia.Actualizar;
import UtilPersistencia.Inserciones;
import UtilPersistencia.Listados;
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
public class EnfoqueBean {

    /**
     * Creates a new instance of EnfoqueBean
     */
    private String descripcion;
    private boolean modificar = false;
    
    public EnfoqueBean() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isModificar() {
        return modificar;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }
    
    public void agregar (){
        Inserciones inser = new Inserciones();
        inser.agregarEnfoque(descripcion);
    }
    
    public List enfoqueListado(){
        Listados listas = new Listados();
        List enfoques = listas.listaEnfoque();
        return enfoques;
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
