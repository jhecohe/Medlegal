package Persistencia;
// Generated 18/09/2014 10:15:52 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Tiporiesgo generated by hbm2java
 */
public class Tiporiesgo  implements java.io.Serializable {


     private int idtipo;
     private String desctiporiesgo;
     private Set riesgos = new HashSet(0);

    public Tiporiesgo() {
    }

	
    public Tiporiesgo(int idtipo, String desctiporiesgo) {
        this.idtipo = idtipo;
        this.desctiporiesgo = desctiporiesgo;
    }
    public Tiporiesgo(int idtipo, String desctiporiesgo, Set riesgos) {
       this.idtipo = idtipo;
       this.desctiporiesgo = desctiporiesgo;
       this.riesgos = riesgos;
    }
   
    public int getIdtipo() {
        return this.idtipo;
    }
    
    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }
    public String getDesctiporiesgo() {
        return this.desctiporiesgo;
    }
    
    public void setDesctiporiesgo(String desctiporiesgo) {
        this.desctiporiesgo = desctiporiesgo;
    }
    public Set getRiesgos() {
        return this.riesgos;
    }
    
    public void setRiesgos(Set riesgos) {
        this.riesgos = riesgos;
    }




}


