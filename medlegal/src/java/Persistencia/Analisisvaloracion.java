package Persistencia;
// Generated Mar 14, 2013 9:27:03 AM by Hibernate Tools 3.2.1.GA



/**
 * Analisisvaloracion generated by hbm2java
 */
public class Analisisvaloracion  implements java.io.Serializable {


     private int idanalisisvaloracion;
     private Panoramaderiesgos panoramaderiesgos;
     private int origen;
     private int probabilidad;
     private int impacto;
     private int control;
     private String color;

    public Analisisvaloracion() {
    }

    public Analisisvaloracion(int idanalisisvaloracion, Panoramaderiesgos panoramaderiesgos, int origen, int probabilidad, int impacto, int control, String color) {
       this.idanalisisvaloracion = idanalisisvaloracion;
       this.panoramaderiesgos = panoramaderiesgos;
       this.origen = origen;
       this.probabilidad = probabilidad;
       this.impacto = impacto;
       this.control = control;
       this.color = color;
    }
   
    public int getIdanalisisvaloracion() {
        return this.idanalisisvaloracion;
    }
    
    public void setIdanalisisvaloracion(int idanalisisvaloracion) {
        this.idanalisisvaloracion = idanalisisvaloracion;
    }
    public Panoramaderiesgos getPanoramaderiesgos() {
        return this.panoramaderiesgos;
    }
    
    public void setPanoramaderiesgos(Panoramaderiesgos panoramaderiesgos) {
        this.panoramaderiesgos = panoramaderiesgos;
    }
    public int getOrigen() {
        return this.origen;
    }
    
    public void setOrigen(int origen) {
        this.origen = origen;
    }
    public int getProbabilidad() {
        return this.probabilidad;
    }
    
    public void setProbabilidad(int probabilidad) {
        this.probabilidad = probabilidad;
    }
    public int getImpacto() {
        return this.impacto;
    }
    
    public void setImpacto(int impacto) {
        this.impacto = impacto;
    }
    public int getControl() {
        return this.control;
    }
    
    public void setControl(int control) {
        this.control = control;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }




}


