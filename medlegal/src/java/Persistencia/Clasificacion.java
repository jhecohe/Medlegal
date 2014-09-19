package Persistencia;
// Generated 18/09/2014 10:15:52 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Clasificacion generated by hbm2java
 */
public class Clasificacion  implements java.io.Serializable {


     private int idclasificacion;
     private String descclasificacion;
     private Set riesgos = new HashSet(0);

    public Clasificacion() {
    }

	
    public Clasificacion(int idclasificacion, String descclasificacion) {
        this.idclasificacion = idclasificacion;
        this.descclasificacion = descclasificacion;
    }
    public Clasificacion(int idclasificacion, String descclasificacion, Set riesgos) {
       this.idclasificacion = idclasificacion;
       this.descclasificacion = descclasificacion;
       this.riesgos = riesgos;
    }
   
    public int getIdclasificacion() {
        return this.idclasificacion;
    }
    
    public void setIdclasificacion(int idclasificacion) {
        this.idclasificacion = idclasificacion;
    }
    public String getDescclasificacion() {
        return this.descclasificacion;
    }
    
    public void setDescclasificacion(String descclasificacion) {
        this.descclasificacion = descclasificacion;
    }
    public Set getRiesgos() {
        return this.riesgos;
    }
    
    public void setRiesgos(Set riesgos) {
        this.riesgos = riesgos;
    }




}


