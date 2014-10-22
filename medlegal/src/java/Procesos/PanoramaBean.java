/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import Persistencia.Panorama;
import Persistencia.Riesgo;
import Logica.Eliminar;
import Logica.Inserciones;
import Logica.Listados;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author jacs
 */
@ManagedBean
@ViewScoped
public class PanoramaBean {

    /**
     * Creates a new instance of PanoramaBean
     */
    private int idproceso;
    private int idsubarea;
    private int idnombreproceso;
    private int idtipoproceso;
    private int idfuncionario;
    private int idestado;
    private int codigo;
    private String personas;
    private int idriesgo;
    private int causa;
    private Riesgo riesg;
    Inserciones agregar;
    Eliminar eliminar;
    Panorama panoSelec;

    public PanoramaBean() {
        agregar = new Inserciones();
    }

    public int getIdriesgo() {
        return idriesgo;
    }

    public void setIdriesgo(int idriesgo) {
        this.idriesgo = idriesgo;
    }

    public Panorama getPanoSelec() {
        return panoSelec;
    }

    public void setPanoSelec(Panorama panoSelec) {
        this.panoSelec = panoSelec;
    }

    public int getIdproceso() {
        return idproceso;
    }

    public void setIdproceso(int idproceso) {
        this.idproceso = idproceso;
    }

    public int getIdsubarea() {
        return idsubarea;
    }

    public void setIdsubarea(int idsubarea) {
        this.idsubarea = idsubarea;
    }

    public int getIdnombreproceso() {
        return idnombreproceso;
    }

    public void setIdnombreproceso(int idnombreproceso) {
        this.idnombreproceso = idnombreproceso;
    }

    public int getIdtipoproceso() {
        return idtipoproceso;
    }

    public void setIdtipoproceso(int idtipoproceso) {
        this.idtipoproceso = idtipoproceso;
    }

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPersonas() {
        return personas;
    }

    public void setPersonas(String personas) {
        this.personas = personas;
    }

    public int getCausa() {
        return causa;
    }

    public void setCausa(int causa) {
        this.causa = causa;
    }

    public Riesgo getRiesg() {
        return riesg;
    }

    public void setRiesg(Riesgo riesg) {
        this.riesg = riesg;
    }
    
    public List procesoList(){
        List procesos;
        Listados lista = new Listados();
        procesos = lista.listaProceso();
        return procesos;
    }
    
    public List informacion(){
        System.out.println("informacion"+idproceso);
        Listados lista = new Listados();
       List proce = lista.listaProcesotobyId(idproceso);
        return proce;
    }
    
    public List riesgosList(){
        List riesgos = null;
        Listados lista = new Listados();
        riesgos = lista.listaRiesgo();
        return riesgos;
    }
    
    public List riesgoList(String query) {
        Listados lista = new Listados();
        List riesgo = null;
        System.out.println("Entro al metodo de listado riesgo:" + query);
        if (query == null) {
            query = "";
            riesgo = lista.listaRiesgoByParametro(query);
        } else {
            riesgo = lista.listaRiesgoByParametro(query);
        }
        return riesgo;
    }
    
    public void panoramaAgregar(){
        System.out.println("Datos panorama" + idproceso +"-"+ idriesgo+"-"+causa);
        if(validacion()){
            Inserciones ins = new Inserciones();
            ins.agregarPanoramaRiesgos(idproceso, idriesgo, causa);   
        }
    }
    
    public boolean validacion(){
        boolean validado = true;
        Listados lista = new Listados();
        List panora = lista.listaPanormaValidacionRiesgo(idproceso, idriesgo);
        if(panora != null){
            validado = false;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
        (FacesMessage.SEVERITY_INFO, "Info", "Este riesgo ya es una causa, una causa no puede ser efecto"));
        }       
        if(idriesgo == causa){
            validado = false;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
        (FacesMessage.SEVERITY_INFO, "Info", "Un riesgo no puede ser causa y efecto"));
        }       
        return validado;
    }
    
    public List panoramabyRiesgo(){
        Listados lista = new Listados();
        List panora = lista.listaPanoramabyProceso(idproceso);
        return panora;
    }
    
    public void eliminarPanorama(){
        System.out.println("A ver que salio a ver si vamos por buen camino "+ panoSelec.getIdpanorama());
        int id = (Integer)panoSelec.getIdpanorama();
        eliminar = new Eliminar();
        eliminar.panorama(id);
    }
    
}
