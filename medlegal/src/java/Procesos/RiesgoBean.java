/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import Persistencia.Riesgo;
import Logica.Actualizar;
import Logica.Inserciones;
import Logica.Listados;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class RiesgoBean {

    /**
     * Creates a new instance of RiesgoBean
     */
    private String nombre;
    private String descripcion;
    private int idriesgo;
    private int idclasificacion;
    private int enfoque;
    private int idtipo;
    private List causas;
    private Map<String, String> riesgomap;
    private boolean modificar = true;
    private int idestado;

    public RiesgoBean() {
    }

    public boolean isModificar() {
        return modificar;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    public void agregar() {
        boolean respuesta;
        Inserciones insertar = new Inserciones();
        respuesta = insertar.agregarRiesgo(idclasificacion, enfoque, nombre, descripcion, idtipo);
        if(respuesta == false){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "'El riesgo "+ nombre +"' ya a sido  creado"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", nombre +" a sido creada correctamente."));
        }

    }

    public List riesgoLista() {
        List riesgolist;
        Listados listados = new Listados();
        riesgolist = listados.listaRiesgo();
        return riesgolist;
    }

    public Map<String, String> causaLista() {
        List listado;
        riesgomap = new HashMap<String, String>();
        Listados listados = new Listados();
        listado = listados.listaRiesgo();
        for (int i = 0; i < listado.size(); i++) {
            Riesgo riesgo = (Riesgo) listado.get(i);
            riesgomap.put(riesgo.getNombre(), "" + riesgo.getIdriesgo());
        }
        return riesgomap;
    }

    public void modificar(RowEditEvent event) {
        Riesgo riesgo = (Riesgo) event.getObject();
        Actualizar actualizar = new Actualizar();
        actualizar.riesgoModificar(riesgo , idestado);
    }
    
    public List listadoClasificacion(){
        Listados listas = new Listados();
        List clasificacion = listas.listaClasificacion();
        return clasificacion;
    }
    
    public List listadoEnfoque(){
        Listados listas = new Listados();
        List enfoque = listas.listaEnfoque();
        return enfoque;
    }
    
    public List listadoTipo(){
        Listados listas = new Listados();
        List tipo = listas.listaTipo();
        return tipo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdriesgo() {
        return idriesgo;
    }

    public void setIdriesgo(int idriesgo) {
        this.idriesgo = idriesgo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdclasificacion() {
        return idclasificacion;
    }

    public void setIdclasificacion(int idclasificacion) {
        this.idclasificacion = idclasificacion;
    }

    public int getEnfoque() {
        return enfoque;
    }

    public void setEnfoque(int enfoque) {
        this.enfoque = enfoque;
    }

    public List getCausas() {
        return causas;
    }

    public void setCausas(List causas) {
        this.causas = causas;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }
}
