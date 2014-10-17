/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import Persistencia.Usuario;
import UtilPersistencia.Listados;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
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
public class UsuarioLoginBean implements Serializable {

    private String usuario;
    private String password;
    private String perfil;
    private String mensaje = "";
    public final static String USER_KEY = "auth_user";

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioLoginBean() {
    }

    public void doLogin(ActionEvent e) throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        String url = "";
        if (administrador(usuario, password)) {
            url = extContext.encodeActionURL(
                    context.getApplication().getViewHandler().getActionURL(context, "/Admin/menuAdmin.jspx"));
            extContext.getSessionMap().put(USER_KEY, new TipoUsuario(usuario, perfil));
            extContext.redirect(url);
            return;
        }
        if (dueno(usuario, password)) {
            System.out.println("Entramos en la validacion if -- usuario --Dueño");
            url = extContext.encodeActionURL(
                    context.getApplication().getViewHandler().getActionURL(context, "/Dueno/menuDueno.jspx"));
            extContext.getSessionMap().put(USER_KEY, new TipoUsuario(usuario, perfil));
            extContext.redirect(url);
            return;
        }
        if (ejecutor(usuario, password)) {
            System.out.println("Entramos en la validacion if -- usuario --Ejecutor");
            url = extContext.encodeActionURL(
                    context.getApplication().getViewHandler().getActionURL(context, "/Ejecutor/menuEjecutor.jspx"));
            extContext.getSessionMap().put(USER_KEY, new TipoUsuario(usuario, perfil));
            extContext.redirect(url);
            return;
        }
        if (gestor(usuario, password)) {
            System.out.println("Entramos en la validacion if -- usuario --Gestor");
            url = extContext.encodeActionURL(
                    context.getApplication().getViewHandler().getActionURL(context, "/Gestor/menuGestor.jspx"));
            extContext.getSessionMap().put(USER_KEY, new TipoUsuario(usuario, perfil));
            extContext.redirect(url);
            return;
        }
        if (operador(usuario, password)) {
            System.out.println("Entramos en la validacion if -- usuario --operario");
            url = extContext.encodeActionURL(
                    context.getApplication().getViewHandler().getActionURL(context, "/Operador/menuOperador.jspx"));
            extContext.getSessionMap().put(USER_KEY, new TipoUsuario(usuario, perfil));
            extContext.redirect(url);
            return;
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
        (FacesMessage.SEVERITY_ERROR, "Error", "El usuario o clave es incorrecto"));
    }

    public String getLoggedUserName() {
        return ((TipoUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(USER_KEY)).toString();
    }

    public void logout() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        extContext.getSessionMap().remove(USER_KEY);
        String url = extContext.encodeActionURL(
                context.getApplication().getViewHandler().getActionURL(context, "/index.jspx"));
        extContext.redirect(url);
    }

    private Usuario validarUsuario() {
        Listados listas = new Listados();
        Usuario user = (Usuario) listas.validacionUsuario(usuario, password);
        if (user != null) {
            return user;
        }
        return null;
    }

    private boolean administrador(String usuario, String password) {
        boolean validacion = false;
        Usuario user;
        if (validarUsuario() != null) {
            user = validarUsuario();
            if ("administrador".equals(user.getPerfil().getDescperfil())) {
                validacion = true;
                setPerfil(user.getPerfil().getDescperfil());
            }
        }
        //System.out.println(usuario + "  /  " + password + "" + user.getPerfil().getDescperfil());
        return validacion;
    }

    private boolean dueno(String usuario, String password) {
        boolean validacion = false;
        Usuario user;
        if (validarUsuario() != null) {
            user = validarUsuario();
            if ("dueño de proceso".equals(user.getPerfil().getDescperfil())) {
                validacion = true;
                setPerfil(user.getPerfil().getDescperfil());
            }
        }
        //System.out.println(usuario + "  /  " + password + "" + user.getPerfil().getDescperfil());
        return validacion;
    }

    private boolean ejecutor(String usuario, String password) {
        boolean validacion = false;
        Usuario user;
        if (validarUsuario() != null) {
            user = validarUsuario();
            if ("ejecutor de proceso".equals(user.getPerfil().getDescperfil())) {
                validacion = true;
                setPerfil(user.getPerfil().getDescperfil());
            }
        }
        //System.out.println(usuario + "  /  " + password + "" + user.getPerfil().getDescperfil());
        return validacion;
    }

    private boolean gestor(String usuario, String password) {
        boolean validacion = false;
        Usuario user;
        if (validarUsuario() != null) {
            user = validarUsuario();
            if ("gestor de riesgo".equals(user.getPerfil().getDescperfil())) {
                validacion = true;
                setPerfil(user.getPerfil().getDescperfil());
            }
        }
        //System.out.println(usuario + "  /  " + password + "" + user.getPerfil().getDescperfil());
        return validacion;
    }

    private boolean operador(String usuario, String password) {
        boolean validacion = false;
        Usuario user;
        if (validarUsuario() != null) {
            user = validarUsuario();
            if ("operador".equals(user.getPerfil().getDescperfil())) {
                validacion = true;
                setPerfil(user.getPerfil().getDescperfil());
            }
        }
        //System.out.println(usuario + "  /  " + password + "" + user.getPerfil().getDescperfil());
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

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

}
