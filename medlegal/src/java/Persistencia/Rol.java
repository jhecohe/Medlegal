package Persistencia;
// Generated 21/07/2014 10:05:29 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Rol generated by hbm2java
 */
public class Rol  implements java.io.Serializable {


     private int idrol;
     private Estado estado;
     private String descrol;
     private Set usuarios = new HashSet(0);

    public Rol() {
    }

	
    public Rol(int idrol, Estado estado, String descrol) {
        this.idrol = idrol;
        this.estado = estado;
        this.descrol = descrol;
    }
    public Rol(int idrol, Estado estado, String descrol, Set usuarios) {
       this.idrol = idrol;
       this.estado = estado;
       this.descrol = descrol;
       this.usuarios = usuarios;
    }
   
    public int getIdrol() {
        return this.idrol;
    }
    
    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }
    public Estado getEstado() {
        return this.estado;
    }
    
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public String getDescrol() {
        return this.descrol;
    }
    
    public void setDescrol(String descrol) {
        this.descrol = descrol;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }




}


