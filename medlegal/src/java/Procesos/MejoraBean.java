/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import Logica.MejoramientoLogica;
import Utilidades.Listados;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author jacs
 */
@ManagedBean
@ViewScoped
public class MejoraBean {

    /**
     * Creates a new instance of MejoraBean
     */
    
    private int idproceso;
    private int idriesgo;
    private int idpanorama;
    private int idestado;
    private Date revision;
    private Date actual = new Date();
    private String mejora;
    private int calificacion;
    private int idfuncionario;
    
    public MejoraBean() {
    }

    public void agregar(){
        MejoramientoLogica mejoramiento = new MejoramientoLogica();
        mejoramiento.agregarMejoramiento(idestado, idriesgo, idfuncionario, calificacion, mejora, revision);
    }
    
    public List procesoList() {
        Listados lista = new Listados();
        List procesos = lista.listaProceso();
        return procesos;
    }

    public List riesgosList() {
        Listados lista = new Listados();
        List riesgos = lista.listaRiesgoValoracion(idproceso);
        return riesgos;
    }
    
    public List mejoramientoList() {
        Listados lista = new Listados();
        List riesgos = lista.listaMejoramiento(idpanorama);
        return riesgos;
    }
    
    public List cronogramaList() {
        Listados lista = new Listados();
        List crono = lista.listaCronograma();
        return crono;
    }
    
    public List funcionarioList() {
        Listados lista = new Listados();
        List funcionarios = lista.listaFuncionarios();
        return funcionarios;
    }
    
    public List mejorameintoList(){
        Listados lista = new Listados();
        List mejoras = lista.listaMejoramientobyRiesgo(idpanorama);
        return mejoras;
    }
    
    public int getIdproceso() {
        return idproceso;
    }

    public void setIdproceso(int idproceso) {
        this.idproceso = idproceso;
    }

    public int getIdpanorama() {
        return idpanorama;
    }

    public void setIdpanorama(int idpanorama) {
        this.idpanorama = idpanorama;
    }

    public String getMejora() {
        return mejora;
    }

    public void setMejora(String mejora) {
        this.mejora = mejora;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public int getIdriesgo() {
        return idriesgo;
    }

    public void setIdriesgo(int idriesgo) {
        this.idriesgo = idriesgo;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
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

    public Date getRevision() {
        return revision;
    }

    public void setRevision(Date revision) {
        this.revision = revision;
    }

    public Date getActual() {
        return actual;
    }

    public void setActual(Date actual) {
        this.actual = actual;
    }
}
