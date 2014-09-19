package Persistencia;
// Generated 18/09/2014 10:15:52 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Subarea generated by hbm2java
 */
public class Subarea  implements java.io.Serializable {


     private int idsubarea;
     private Ciudad ciudad;
     private Area area;
     private String codigosubarea;
     private String descsubarea;
     private Set procesos = new HashSet(0);
     private Set funcionarios = new HashSet(0);

    public Subarea() {
    }

	
    public Subarea(int idsubarea, Ciudad ciudad, Area area, String codigosubarea, String descsubarea) {
        this.idsubarea = idsubarea;
        this.ciudad = ciudad;
        this.area = area;
        this.codigosubarea = codigosubarea;
        this.descsubarea = descsubarea;
    }
    public Subarea(int idsubarea, Ciudad ciudad, Area area, String codigosubarea, String descsubarea, Set procesos, Set funcionarios) {
       this.idsubarea = idsubarea;
       this.ciudad = ciudad;
       this.area = area;
       this.codigosubarea = codigosubarea;
       this.descsubarea = descsubarea;
       this.procesos = procesos;
       this.funcionarios = funcionarios;
    }
   
    public int getIdsubarea() {
        return this.idsubarea;
    }
    
    public void setIdsubarea(int idsubarea) {
        this.idsubarea = idsubarea;
    }
    public Ciudad getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    public Area getArea() {
        return this.area;
    }
    
    public void setArea(Area area) {
        this.area = area;
    }
    public String getCodigosubarea() {
        return this.codigosubarea;
    }
    
    public void setCodigosubarea(String codigosubarea) {
        this.codigosubarea = codigosubarea;
    }
    public String getDescsubarea() {
        return this.descsubarea;
    }
    
    public void setDescsubarea(String descsubarea) {
        this.descsubarea = descsubarea;
    }
    public Set getProcesos() {
        return this.procesos;
    }
    
    public void setProcesos(Set procesos) {
        this.procesos = procesos;
    }
    public Set getFuncionarios() {
        return this.funcionarios;
    }
    
    public void setFuncionarios(Set funcionarios) {
        this.funcionarios = funcionarios;
    }




}


