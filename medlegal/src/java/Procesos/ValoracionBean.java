/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import UtilPersistencia.Inserciones;
import UtilPersistencia.Listados;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author jacs
 */
@ManagedBean
@ViewScoped
public class ValoracionBean {

    /**
     * Creates a new instance of ValoracionBean
     */
    private int idproceso;
    private int idpanorama;
    private int origen;
    private int probabilidad;
    private int impacto;
    private int calificacion;
    private int calificacion1 = 0;
    private int calificacion2 = 0;
    private String valoracion = null;
    private String color = null;

    public void agregar() {
        Inserciones inser = new Inserciones();
        System.out.println("Bean valoracio" + idpanorama +"/"+ origen +"/"+ probabilidad +"/"+ impacto +"/"+ calificacion2 +"/"+ color);
        inser.agregarValoracion(idpanorama, origen, probabilidad, impacto, calificacion2, color);
    }
    
    public List valoracionList(){
        Listados lista = new Listados();
        List valoraciones = lista.listaValoracion();
        return valoraciones;
    }

    public List procesoList() {
        Listados lista = new Listados();
        List procesos = lista.listaProceso();
        return procesos;
    }

    public List riesgosList() {
        Listados lista = new Listados();
        List riesgos = lista.listaRiesgoValoracion(idproceso);
        return riesgos;
    }

    public void calificacion1() {
        System.out.println("calificacion" + origen + "" + probabilidad + "" + impacto);
        calificacion1 = origen * probabilidad * impacto;
        calificacion2 = calificacion1 * calificacion;
    }

    public void calificacion2() {
        System.out.println("calificacion2  " + calificacion1 + " , " + calificacion + " , " + idpanorama);
        calificacion2 = calificacion1 * calificacion;
    }

    public String color() {
        if (calificacion1 >= 1 && calificacion1 < 10|| calificacion2 >= 1 && calificacion2 < 40) {
            color = "background-color: palegreen";
            valoracion ="bajo";
            return color;
        }
        if (calificacion1 >= 10 && calificacion1 < 15 || calificacion2 >= 40 && calificacion2 < 60) {
            color = "background-color: greenyellow";
            valoracion ="bajo";
            return color;
        }
        if (calificacion1 >= 15 && calificacion1 < 30 || calificacion2 >= 60 && calificacion2 < 80) {
            color = "background-color: yellow";
            valoracion ="medio";
            return color;
        }
        if (calificacion1 >= 30 && calificacion1 < 60 || calificacion2 >= 80 && calificacion2 < 100) {
            color = "background-color: red";
            valoracion ="medio";
            return color;
        }
        if (calificacion1 >= 60 || calificacion2 >= 120) {
            color = "background-color: darkgray";
            valoracion ="alto";
        }
        return color;
    }

    public int getIdproceso() {
        return idproceso;
    }

    public void setIdproceso(int idproceso) {
        this.idproceso = idproceso;
    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public int getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(int probabilidad) {
        this.probabilidad = probabilidad;
    }

    public int getImpacto() {
        return impacto;
    }

    public void setImpacto(int impacto) {
        this.impacto = impacto;
    }

    public int getCalificacion1() {
        return calificacion1;
    }

    public void setCalificacion1(int calificacion1) {
        this.calificacion1 = calificacion1;
    }

    public int getCalificacion2() {
        return calificacion2;
    }

    public void setCalificacion2(int calificacion2) {
        this.calificacion2 = calificacion2;
    }

    public int getIdpanorama() {
        return idpanorama;
    }

    public void setIdpanorama(int idpanorama) {
        this.idpanorama = idpanorama;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }
}
