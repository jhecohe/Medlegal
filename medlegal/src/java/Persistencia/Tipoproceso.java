package Persistencia;
// Generated 16/10/2014 07:50:08 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Tipoproceso generated by hbm2java
 */
public class Tipoproceso  implements java.io.Serializable {


     private int idtipoproceso;
     private String desctipo;
     private Set nombreprocesos = new HashSet(0);

    public Tipoproceso() {
    }

	
    public Tipoproceso(int idtipoproceso, String desctipo) {
        this.idtipoproceso = idtipoproceso;
        this.desctipo = desctipo;
    }
    public Tipoproceso(int idtipoproceso, String desctipo, Set nombreprocesos) {
       this.idtipoproceso = idtipoproceso;
       this.desctipo = desctipo;
       this.nombreprocesos = nombreprocesos;
    }
   
    public int getIdtipoproceso() {
        return this.idtipoproceso;
    }
    
    public void setIdtipoproceso(int idtipoproceso) {
        this.idtipoproceso = idtipoproceso;
    }
    public String getDesctipo() {
        return this.desctipo;
    }
    
    public void setDesctipo(String desctipo) {
        this.desctipo = desctipo;
    }
    public Set getNombreprocesos() {
        return this.nombreprocesos;
    }
    
    public void setNombreprocesos(Set nombreprocesos) {
        this.nombreprocesos = nombreprocesos;
    }




}


