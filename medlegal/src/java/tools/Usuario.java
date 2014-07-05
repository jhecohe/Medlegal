/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tools;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import login.TipoUsuario;
import static login.UsuarioLoginBean.USER_KEY;

/**
 *
 * @author jhecohe
 */
@ManagedBean
@RequestScoped
public class Usuario {

    /**
     * Creates a new instance of Usuario
     */
    public Usuario() {
    }
    
    public String getUsuarioNombre(){
        String usuario = ((TipoUsuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(USER_KEY)).toString();
        return usuario.toUpperCase();
    }
    
}
