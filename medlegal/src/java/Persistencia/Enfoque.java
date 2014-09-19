package Persistencia;
// Generated 18/09/2014 10:15:52 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Enfoque generated by hbm2java
 */
public class Enfoque  implements java.io.Serializable {


     private int idenfoque;
     private String descenfoque;
     private Set riesgos = new HashSet(0);

    public Enfoque() {
    }

	
    public Enfoque(int idenfoque, String descenfoque) {
        this.idenfoque = idenfoque;
        this.descenfoque = descenfoque;
    }
    public Enfoque(int idenfoque, String descenfoque, Set riesgos) {
       this.idenfoque = idenfoque;
       this.descenfoque = descenfoque;
       this.riesgos = riesgos;
    }
   
    public int getIdenfoque() {
        return this.idenfoque;
    }
    
    public void setIdenfoque(int idenfoque) {
        this.idenfoque = idenfoque;
    }
    public String getDescenfoque() {
        return this.descenfoque;
    }
    
    public void setDescenfoque(String descenfoque) {
        this.descenfoque = descenfoque;
    }
    public Set getRiesgos() {
        return this.riesgos;
    }
    
    public void setRiesgos(Set riesgos) {
        this.riesgos = riesgos;
    }




}


