package Persistencia;
// Generated Mar 14, 2013 9:27:03 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Grado generated by hbm2java
 */
public class Grado  implements java.io.Serializable {


     private int idgrado;
     private String descgrado;
     private Set funcionarios = new HashSet(0);

    public Grado() {
    }

	
    public Grado(int idgrado, String descgrado) {
        this.idgrado = idgrado;
        this.descgrado = descgrado;
    }
    public Grado(int idgrado, String descgrado, Set funcionarios) {
       this.idgrado = idgrado;
       this.descgrado = descgrado;
       this.funcionarios = funcionarios;
    }
   
    public int getIdgrado() {
        return this.idgrado;
    }
    
    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
    }
    public String getDescgrado() {
        return this.descgrado;
    }
    
    public void setDescgrado(String descgrado) {
        this.descgrado = descgrado;
    }
    public Set getFuncionarios() {
        return this.funcionarios;
    }
    
    public void setFuncionarios(Set funcionarios) {
        this.funcionarios = funcionarios;
    }




}


