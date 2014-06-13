/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import UtilPersistencia.Actualizar;
import UtilPersistencia.Inserciones;
import UtilPersistencia.Listados;
import java.util.ArrayList;
import java.util.Date;
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
public class FuncionarioBean {

    private String nombre;
    private String segnombre;
    private String apellido;
    private String segapellido;
    private int cedula;
    private Date fechanacimiento;
    private String telefono;
    private String correo;
    private String direccion;
    private int idgrado;
    private int idciudad;
    private int idciudadexp;
    private int idciudadreci;
    private int idclase;
    private int idcargo;
    private int idregion;
    private int idseccional;
    private int idarea;
    private int idsubarea;
    List funcionariolist;
    private boolean modificar = false;

    /**
     * Creates a new instance of Ciudad
     */
    public FuncionarioBean() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public int getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
    }

    public int getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(int idciudad) {
        this.idciudad = idciudad;
    }

    public int getIdclase() {
        return idclase;
    }

    public void setIdclase(int idclase) {
        this.idclase = idclase;
    }

    public int getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
    }

    public String getSegapellido() {
        return segapellido;
    }

    public void setSegapellido(String segapellido) {
        this.segapellido = segapellido;
    }

    public String getSegnombre() {
        return segnombre;
    }

    public void setSegnombre(String segnombre) {
        this.segnombre = segnombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isModificar() {
        return modificar;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    public int getIdciudadexp() {
        return idciudadexp;
    }

    public void setIdciudadexp(int idciudadexp) {
        this.idciudadexp = idciudadexp;
    }

    public int getIdciudadreci() {
        return idciudadreci;
    }

    public void setIdciudadreci(int idciudadreci) {
        this.idciudadreci = idciudadreci;
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

    public int getIdsubarea() {
        return idsubarea;
    }

    public void setIdsubarea(int idsubarea) {
        this.idsubarea = idsubarea;
    }

    public void agregar() {
        System.out.println("Estamos en el funcionariobean " + idciudad + "+ " + idciudadexp + "+ " + idciudadreci + "+ " + idcargo);
        Inserciones insertar = new Inserciones();
        insertar.agregarFuncionario(idgrado, idciudad, idclase, idcargo, idsubarea, nombre,
                segnombre, apellido, segapellido, cedula, fechanacimiento, telefono, correo, direccion,
                idciudadexp, idciudadreci);
    }

    public List getGradolist() {
        Listados listas = new Listados();
        List gradolist = listas.listaGrado();
        return gradolist;
    }

    public List getCiudadlist() {
        Listados listas = new Listados();
        List ciudadlist = listas.listaCiudad();
        return ciudadlist;
    }

    public List getClaselist() {
        Listados listas = new Listados();
        List claselist = listas.listaClase();
        return claselist;
    }

    public List getCargolist() {  
        Listados listas = new Listados();
        List cargolist = listas.listaCargo(); 
        return cargolist;
    }

    public List getFuncionarioslist() {
        Listados listas = new Listados();
        if (funcionariolist == null) {
            funcionariolist = new ArrayList(listas.listaFuncionarios());
        }
        return funcionariolist;
    }

    public void modificar(RowEditEvent event) {
        System.out.println("Modificar funcionario");
        Object riesgo = (Object) event.getObject();
        Actualizar actualizar = new Actualizar();
        actualizar.funcionarioModificar(riesgo);
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
        System.out.println("Entro a listado area" + getIdseccional());
        Listados listas = new Listados();
        List arealist = listas.listaAreabySeccional(getIdseccional());
        return arealist;
    }
    
    public List getSubarealist() {
        Listados listas = new Listados();
        List arealist = listas.listaSubareabyArea(getIdarea());
        return arealist;
    }

    public void visible() {
        if (modificar == false) {
            modificar = true;
        } else {
            modificar = false;
        }
    }
}
