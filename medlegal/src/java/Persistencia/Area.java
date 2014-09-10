package Persistencia;
// Generated 8/09/2014 11:38:16 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Area generated by hbm2java
 */
public class Area  implements java.io.Serializable {


     private int idarea;
     private Seccional seccional;
     private String codigoarea;
     private String descarea;
     private Set subareas = new HashSet(0);

    public Area() {
    }

	
    public Area(int idarea, Seccional seccional, String codigoarea, String descarea) {
        this.idarea = idarea;
        this.seccional = seccional;
        this.codigoarea = codigoarea;
        this.descarea = descarea;
    }
    public Area(int idarea, Seccional seccional, String codigoarea, String descarea, Set subareas) {
       this.idarea = idarea;
       this.seccional = seccional;
       this.codigoarea = codigoarea;
       this.descarea = descarea;
       this.subareas = subareas;
    }
   
    public int getIdarea() {
        return this.idarea;
    }
    
    public void setIdarea(int idarea) {
        this.idarea = idarea;
    }
    public Seccional getSeccional() {
        return this.seccional;
    }
    
    public void setSeccional(Seccional seccional) {
        this.seccional = seccional;
    }
    public String getCodigoarea() {
        return this.codigoarea;
    }
    
    public void setCodigoarea(String codigoarea) {
        this.codigoarea = codigoarea;
    }
    public String getDescarea() {
        return this.descarea;
    }
    
    public void setDescarea(String descarea) {
        this.descarea = descarea;
    }
    public Set getSubareas() {
        return this.subareas;
    }
    
    public void setSubareas(Set subareas) {
        this.subareas = subareas;
    }




}


