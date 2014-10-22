/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import Logica.Actualizar;
import Logica.Inserciones;
import Logica.Listados;
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
public class CiudadBean {
    
    private String nombre;
    private String codigo;
    private int iddepartamento;
    Listados listas;

    /**
     * Creates a new instance of CiudadBean
     */
    public CiudadBean() {
        listas = new Listados();
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

    public int getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(int iddepartamento) {
        this.iddepartamento = iddepartamento;
    }
    
    public void agregar(){
        boolean respuesta;
        Inserciones insertar = new Inserciones();
        respuesta = insertar.agregarCiudad(nombre, codigo, iddepartamento);
        if(respuesta == false){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "'El enfoque "+ nombre +"' ya a sido  creado"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", nombre +" a sido creada correctamente."));
        }        
    }
    
    public List getDepartamentolist() {
        List departamentolist;
        departamentolist = listas.listaDepartamentos();
        return departamentolist;
    }
    
    public List ciudadLista(){
        Listados lista = new Listados();
        List ciudades = lista.listaCiudad();
        return ciudades;
    }
    
    public void modificar(RowEditEvent event) {
        Object objeto = (Object) event.getObject();
        Actualizar actualizar = new Actualizar();
        actualizar.ciudadModificar(objeto);
    }
}
