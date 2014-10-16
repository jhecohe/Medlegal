package Persistencia;
// Generated 16/10/2014 07:50:08 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Panorama generated by hbm2java
 */
public class Panorama  implements java.io.Serializable {


     private int idpanorama;
     private Riesgo riesgoByIdefecto;
     private Proceso proceso;
     private Riesgo riesgoByIdcausa;
     private Set analisisvaloracions = new HashSet(0);
     private Set planmejoramientos = new HashSet(0);
     private Set trazapanoramas = new HashSet(0);

    public Panorama() {
    }

	
    public Panorama(int idpanorama, Riesgo riesgoByIdefecto, Proceso proceso, Riesgo riesgoByIdcausa) {
        this.idpanorama = idpanorama;
        this.riesgoByIdefecto = riesgoByIdefecto;
        this.proceso = proceso;
        this.riesgoByIdcausa = riesgoByIdcausa;
    }
    public Panorama(int idpanorama, Riesgo riesgoByIdefecto, Proceso proceso, Riesgo riesgoByIdcausa, Set analisisvaloracions, Set planmejoramientos, Set trazapanoramas) {
       this.idpanorama = idpanorama;
       this.riesgoByIdefecto = riesgoByIdefecto;
       this.proceso = proceso;
       this.riesgoByIdcausa = riesgoByIdcausa;
       this.analisisvaloracions = analisisvaloracions;
       this.planmejoramientos = planmejoramientos;
       this.trazapanoramas = trazapanoramas;
    }
   
    public int getIdpanorama() {
        return this.idpanorama;
    }
    
    public void setIdpanorama(int idpanorama) {
        this.idpanorama = idpanorama;
    }
    public Riesgo getRiesgoByIdefecto() {
        return this.riesgoByIdefecto;
    }
    
    public void setRiesgoByIdefecto(Riesgo riesgoByIdefecto) {
        this.riesgoByIdefecto = riesgoByIdefecto;
    }
    public Proceso getProceso() {
        return this.proceso;
    }
    
    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }
    public Riesgo getRiesgoByIdcausa() {
        return this.riesgoByIdcausa;
    }
    
    public void setRiesgoByIdcausa(Riesgo riesgoByIdcausa) {
        this.riesgoByIdcausa = riesgoByIdcausa;
    }
    public Set getAnalisisvaloracions() {
        return this.analisisvaloracions;
    }
    
    public void setAnalisisvaloracions(Set analisisvaloracions) {
        this.analisisvaloracions = analisisvaloracions;
    }
    public Set getPlanmejoramientos() {
        return this.planmejoramientos;
    }
    
    public void setPlanmejoramientos(Set planmejoramientos) {
        this.planmejoramientos = planmejoramientos;
    }
    public Set getTrazapanoramas() {
        return this.trazapanoramas;
    }
    
    public void setTrazapanoramas(Set trazapanoramas) {
        this.trazapanoramas = trazapanoramas;
    }




}


