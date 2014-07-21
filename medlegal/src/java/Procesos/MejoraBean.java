/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import UtilPersistencia.Inserciones;
import UtilPersistencia.Listados;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

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
    private int idpanorama;
    private int cronograma;
    private String mejora;
    private int calificacion;
    private int idfuncionario;
    private boolean modificar;
    
    public MejoraBean() {
    }

    public void agregar(){
        Inserciones insertar = new Inserciones();
        insertar.agregarMejoramiento(cronograma, idpanorama, idfuncionario, calificacion, mejora);
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
    
    public void modificar(RowEditEvent event) {
//        System.out.println("Modificar funcionario");
//        Object riesgo = (Object) event.getObject();
//        Actualizar actualizar = new Actualizar();
//        actualizar.funcionarioModificar(riesgo);
    }
    
    public void visible() {
        if (modificar == false) {
            modificar = true;
        } else {
            modificar = false;
        }
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

    public int getCronograma() {
        return cronograma;
    }

    public void setCronograma(int cronograma) {
        this.cronograma = cronograma;
    }

    public int getCalificacion() {
        return calificacion;
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

    public boolean isModificar() {
        return modificar;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }
}
