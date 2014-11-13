/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import Persistencia.Funcionario;
import Persistencia.Proceso;
import Logica.Actualizar;
import Logica.Inserciones;
import Logica.Listados;
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
public class ProcesoBean {

    /**
     * Creates a new instance of ProcesoBea
     */
    private int idproceso;
    private int idsubarea;
    private int idnombreproceso;
    private int idtipoproceso;
    private int idasociado;
    private int idfuncionario;
    private int idestado;
    private int idregion;
    private int idseccional;
    private int idarea;
    private Funcionario funcionario;  

    /**
     * Creates a new instance of Ciudad
     */
    public ProcesoBean() {

    }

    public int getIdsubarea() {
        return idsubarea;
    }

    public void setIdsubarea(int idsubarea) {
        this.idsubarea = idsubarea;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public int getIdnombreproceso() {
        return idnombreproceso;
    }

    public void setIdnombreproceso(int idnombreproceso) {
        this.idnombreproceso = idnombreproceso;
    }

    public int getIdproceso() {
        return idproceso;
    }

    public void setIdproceso(int idproceso) {
        this.idproceso = idproceso;
    }

    public int getIdtipoproceso() {
        return idtipoproceso;
    }

    public void setIdtipoproceso(int idtipoproceso) {
        this.idtipoproceso = idtipoproceso;
    }

    public int getIdregion() {
        return idregion;
    }

    public void setIdregion(int idregion) {
        this.idregion = idregion;
    }

    public int getIdseccional() {
        return idseccional;
    }

    public void setIdseccional(int idseccional) {
        this.idseccional = idseccional;
    }

    public int getIdarea() {
        return idarea;
    }

    public void setIdarea(int idarea) {
        this.idarea = idarea;
    }

    public int getIdasociado() {
        return idasociado;
    }

    public void setIdasociado(int idasociado) {
        this.idasociado = idasociado;
    }

    public void agregar() {
        Inserciones insertar = new Inserciones();
        String idpro = "" + idtipoproceso + idnombreproceso + idasociado;
        idproceso = Integer.parseInt(idpro);
        System.out.println("Agregar proceso " + idproceso + " " + idasociado + " " + idfuncionario + " " + idsubarea);
        insertar.agregarProceso(idproceso, idasociado, idsubarea, idfuncionario);
        idproceso = 0; idasociado = 0; idsubarea = 0; idfuncionario = 0; idsubarea = 0;
    }
    
    public List procesoList(){
        Listados listas = new Listados();
        List procesos = listas.listaProceso();
        return procesos;
    }

    public List getTipoprocesolist() {
        Listados listas = new Listados();
        List tipoprocesolist = listas.listaTipoproceso();
        return tipoprocesolist;
    }
    
    public List getNombreprocesolist() {
        Listados listas = new Listados();
        List nombreprocesolist = listas.listaNombreprocesobyTipo(getIdtipoproceso());
        return nombreprocesolist;
    }
    
    public List getProcesoasociadolist() {
        Listados listas = new Listados();
        List tipoprocesolist = listas.listaProcesoasociadobyNombre(getIdnombreproceso());
        return tipoprocesolist;
    }

    public List getFuncionariolist() {
        Listados listas = new Listados();
        List funcionariolist = listas.listaFuncionariosbySubArea(idsubarea);
        return funcionariolist;
    }

    public List getEstadolist() {
        Listados listas = new Listados();
        List estadolist = listas.listaEstado();
        return estadolist;
    }

    public List getRegionlist() {
        Listados listas = new Listados();
        List regionlist = listas.listaRegional();
        return regionlist;
    }

    public List getSeccionallist() {
        Listados listas = new Listados();     
        List seccionallist = listas.listaSeccionalbyRegion(getIdregion());
        return seccionallist;
    }

    public List getArealist() {
        Listados listas = new Listados();
        List arealist = listas.listaAreabySeccional(idseccional);
        return arealist;
    }
    
    public List getSubarealist() {
        Listados listas = new Listados();
        List arealist = listas.listaSubareabyArea(idarea);
        return arealist;
    }
    
    public void modificar(RowEditEvent event){
        System.out.println("Modificar proceso" + idestado);
        Object proceso = (Object) event.getObject();
        Actualizar actualizar = new Actualizar();
        actualizar.procesoModificar(proceso, idestado, idfuncionario);
    }
}
