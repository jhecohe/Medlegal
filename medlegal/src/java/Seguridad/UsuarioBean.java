/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad;

import Utilidades.Actualizar;
import Utilidades.Inserciones;
import Utilidades.Listados;
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
public class UsuarioBean {
    
    private String nombre;
    private int idfuncionario;
    private int idroles;
    String clave;
    String reclave;
    Listados listas;

    /**
     * Creates a new instance of Ciudad
     */
    public UsuarioBean() {
        listas = new Listados();
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getReclave() {
        return reclave;
    }

    public void setReclave(String reclave) {
        this.reclave = reclave;
    }

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public int getIdroles() {
        return idroles;
    }

    public void setIdroles(int idroles) {
        this.idroles = idroles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregar(){
        System.out.println("Estamos en el bean " + idfuncionario + " + " + idroles);
        Inserciones insertar = new Inserciones();
        insertar.agregarUsuario(idfuncionario, idroles, nombre, clave);
    }
    
    public List getFuncionariolist() {
        List funcionariolist = listas.listaFuncionarios();
        return funcionariolist;
    }
    
    public List getRoles() {
        List roleslist = listas.listaPerfiles();
        return roleslist;
    }
    
    public boolean validarclave(){
        boolean valido = false;
        return valido;
    }
    
    public List usuarioList(){
        Listados listas = new Listados();
        List usuarios = listas.listaUsuario();
        return usuarios;
    }
    
    public void modificar(RowEditEvent event) {
        Object objeto = (Object) event.getObject();       
        Actualizar actualizar = new Actualizar();
        actualizar.usuarioModificar(objeto, idroles);
    }
}
