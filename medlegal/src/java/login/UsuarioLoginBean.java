/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import Persistencia.Usuario;
import UtilPersistencia.Listados;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author jacs
 */
@ManagedBean
@SessionScoped
public class UsuarioLoginBean {

    private String usuario;
    private String password;
    private String rol;
    private String mensaje;
    public final static String USER_KEY="auth_user";
    
    /** Creates a new instance of UsuarioBean */
    public UsuarioLoginBean() {
    }
    
    public void doLogin(ActionEvent e) throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        String url = "";
        if(usuario(usuario, password))
        {
            url = extContext.encodeActionURL(
                    context.getApplication().getViewHandler().getActionURL
                    (context, "/Usuario/menuUsuario.jspx"));
            extContext.getSessionMap().put(USER_KEY, new TipoUsuario(usuario, "usuario"));
            extContext.redirect(url);
            return;
            
        }
        //if(administrador(usuario, password))
        if(administrador())
        {
            url = extContext.encodeActionURL(
                    context.getApplication().getViewHandler().getActionURL
                    (context, "/Admin/menuAdmin.jspx"));
            extContext.getSessionMap().put(USER_KEY, new TipoUsuario(usuario, "rol1"));
            extContext.redirect(url);
            return;
        }
        mensaje="Usuario y/o clave invalida";
    }
    
    public String getLoggedUserName(){
        return ((TipoUsuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(USER_KEY)).toString();
    }
    
    public void logout() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        extContext.getSessionMap().remove(USER_KEY);
        String url = extContext.encodeActionURL(
                    context.getApplication().getViewHandler().getActionURL
                    (context, "/index.jspx"));
        extContext.redirect(url);
    }
    
    private boolean usuario(String user, String password){
        return user.equals("usuario") && password.equals("usuario");
        //Aqui se puede validar hacia una base de datos
    }
    
    //private boolean administrador(String usuarior, String password){
    private boolean administrador(){
        Listados listas = new Listados();
        boolean validacion = true;
        //return user.equals("admin") && password.equals("admin");
        System.out.println(usuario+ "  /  " + password);
        Usuario user = listas.validacionUsuario(usuario, password);
        if(user != null){
            System.out.println(user.getPerfil().getDescperfil()+ " if nombre usuario  ");
            validacion = true;
            setRol(user.getPerfil().getDescperfil());
        }
        //Aqui se puede validar hacia una base de datos
        return validacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
