/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reporte;

import Logica.Listados;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author jacs
 */
@ManagedBean
@RequestScoped
public class ReportesBean {

    /**
     * Creates a new instance of ReportesBean
     */
    public int idproceso = -1;
    public int idresponsable;
    
    public ReportesBean() {
    }
    
    public List listaRiesProcesoAsociado(){
        List riesProceso = null;
        Listados list = new Listados();
        riesProceso = list.listaRiesgoProcesobyAsociado(idproceso);
        return riesProceso;
    }
    
    public List listaRiesResponsable(){
        List riesResponsable = null;
        Listados list = new Listados();
        riesResponsable = list.listaRiesgoResponsable(idresponsable);
        return riesResponsable;
    }
    
    public List listaProcesoAsociado(){
        List procesoAsociado = null;
        Listados list = new Listados();
        procesoAsociado = list.listaProcesoasociado();
        return procesoAsociado;
    } 
    
    public List listaFuncionarios(){
        List funcionarios = null;
        Listados list = new Listados();
        funcionarios = list.listaFuncionarios();
        return funcionarios;
    }    

    public int getIdproceso() {
        return idproceso;
    }

    public void setIdproceso(int idproceso) {
        this.idproceso = idproceso;
    }

    public int getIdresponsable() {
        return idresponsable;
    }

    public void setIdresponsable(int idresponsable) {
        this.idresponsable = idresponsable;
    }
    
    
}
