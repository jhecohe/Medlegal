/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.Serializable;

/**
 *
 * @author jacs
 */
public class TipoUsuario implements Serializable {
    
    private String user;
    private String role;
    
    public TipoUsuario(String user, String role){
        this.user = user;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    @Override
    public String toString() {
        return user;
    }
    
}
