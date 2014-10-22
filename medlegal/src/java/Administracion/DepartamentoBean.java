/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import Logica.Actualizar;
import Logica.Inserciones;
import Logica.Listados;
import java.util.ArrayList;
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
public class DepartamentoBean {

    /**
     * Creates a new instance of Departamento
     */
    private String nombre;
    private String codigo;
    
    public DepartamentoBean() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public void agregar(){
        boolean respuesta;
        Inserciones insertar = new Inserciones();
        respuesta = insertar.agregarDepartamento(nombre, codigo);
        if(respuesta == false){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "'El enfoque "+ nombre +"' ya a sido  creado"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", nombre +" a sido creada correctamente."));
        }
    }
    
    public void modificar(RowEditEvent event) {
        Object objeto = (Object) event.getObject();
        Actualizar actualizar = new Actualizar();
        actualizar.departamentoModificar(objeto);
    }
    
    public List departamentoList(){
        Listados listas = new Listados();
        List departamentos = listas.listaDepartamentos();
        return departamentos;
    }
}
