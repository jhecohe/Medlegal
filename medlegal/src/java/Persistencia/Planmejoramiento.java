package Persistencia;
// Generated 16/10/2014 07:50:08 AM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Planmejoramiento generated by hbm2java
 */
public class Planmejoramiento  implements java.io.Serializable {


     private int idmejoramiento;
     private Estadomejora estadomejora;
     private Panorama panorama;
     private Funcionario funcionario;
     private int resultado;
     private String mejoramiento;
     private Date fechainicio;
     private Date fecharevision;
     private Set trazamejoras = new HashSet(0);

    public Planmejoramiento() {
    }

	
    public Planmejoramiento(int idmejoramiento, Estadomejora estadomejora, Panorama panorama, Funcionario funcionario, int resultado, String mejoramiento, Date fechainicio, Date fecharevision) {
        this.idmejoramiento = idmejoramiento;
        this.estadomejora = estadomejora;
        this.panorama = panorama;
        this.funcionario = funcionario;
        this.resultado = resultado;
        this.mejoramiento = mejoramiento;
        this.fechainicio = fechainicio;
        this.fecharevision = fecharevision;
    }
    public Planmejoramiento(int idmejoramiento, Estadomejora estadomejora, Panorama panorama, Funcionario funcionario, int resultado, String mejoramiento, Date fechainicio, Date fecharevision, Set trazamejoras) {
       this.idmejoramiento = idmejoramiento;
       this.estadomejora = estadomejora;
       this.panorama = panorama;
       this.funcionario = funcionario;
       this.resultado = resultado;
       this.mejoramiento = mejoramiento;
       this.fechainicio = fechainicio;
       this.fecharevision = fecharevision;
       this.trazamejoras = trazamejoras;
    }
   
    public int getIdmejoramiento() {
        return this.idmejoramiento;
    }
    
    public void setIdmejoramiento(int idmejoramiento) {
        this.idmejoramiento = idmejoramiento;
    }
    public Estadomejora getEstadomejora() {
        return this.estadomejora;
    }
    
    public void setEstadomejora(Estadomejora estadomejora) {
        this.estadomejora = estadomejora;
    }
    public Panorama getPanorama() {
        return this.panorama;
    }
    
    public void setPanorama(Panorama panorama) {
        this.panorama = panorama;
    }
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public int getResultado() {
        return this.resultado;
    }
    
    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    public String getMejoramiento() {
        return this.mejoramiento;
    }
    
    public void setMejoramiento(String mejoramiento) {
        this.mejoramiento = mejoramiento;
    }
    public Date getFechainicio() {
        return this.fechainicio;
    }
    
    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }
    public Date getFecharevision() {
        return this.fecharevision;
    }
    
    public void setFecharevision(Date fecharevision) {
        this.fecharevision = fecharevision;
    }
    public Set getTrazamejoras() {
        return this.trazamejoras;
    }
    
    public void setTrazamejoras(Set trazamejoras) {
        this.trazamejoras = trazamejoras;
    }




}


