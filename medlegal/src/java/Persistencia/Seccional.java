package Persistencia;
// Generated 21/07/2014 10:05:29 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Seccional generated by hbm2java
 */
public class Seccional  implements java.io.Serializable {


     private int idseccional;
     private Regional regional;
     private String descseccional;
     private String codigoseccional;
     private Set areas = new HashSet(0);

    public Seccional() {
    }

	
    public Seccional(int idseccional, Regional regional, String descseccional, String codigoseccional) {
        this.idseccional = idseccional;
        this.regional = regional;
        this.descseccional = descseccional;
        this.codigoseccional = codigoseccional;
    }
    public Seccional(int idseccional, Regional regional, String descseccional, String codigoseccional, Set areas) {
       this.idseccional = idseccional;
       this.regional = regional;
       this.descseccional = descseccional;
       this.codigoseccional = codigoseccional;
       this.areas = areas;
    }
   
    public int getIdseccional() {
        return this.idseccional;
    }
    
    public void setIdseccional(int idseccional) {
        this.idseccional = idseccional;
    }
    public Regional getRegional() {
        return this.regional;
    }
    
    public void setRegional(Regional regional) {
        this.regional = regional;
    }
    public String getDescseccional() {
        return this.descseccional;
    }
    
    public void setDescseccional(String descseccional) {
        this.descseccional = descseccional;
    }
    public String getCodigoseccional() {
        return this.codigoseccional;
    }
    
    public void setCodigoseccional(String codigoseccional) {
        this.codigoseccional = codigoseccional;
    }
    public Set getAreas() {
        return this.areas;
    }
    
    public void setAreas(Set areas) {
        this.areas = areas;
    }




}


