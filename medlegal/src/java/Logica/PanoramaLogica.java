/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import Utilidades.iniciarHibernate;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author jhecohe
 */
public class PanoramaLogica implements Serializable{
    
    iniciarHibernate inicio;
    
    public PanoramaLogica(){
        inicio = new iniciarHibernate();
    }
    
    public void agregarPanoramaRiesgos(int idproceso, int idriesgo, int idcausa) {
        try {
            //int idpanoramariesgos, Proceso proceso, Riesgo riesgo, int causa
            Persistencia.Proceso proceso = new Persistencia.Proceso();
            proceso.setIdproceso(idproceso);
            Persistencia.Riesgo riesgo = new Persistencia.Riesgo();
            riesgo.setIdriesgo(idriesgo);
            Persistencia.Riesgo causa = new Persistencia.Riesgo();
            causa.setIdriesgo(idcausa);
            Persistencia.Panorama panorama = new Persistencia.Panorama();
            panorama.setRiesgoByIdcausa(riesgo);
            panorama.setProceso(proceso);
            panorama.setRiesgoByIdefecto(causa);
            inicio.getSession().persist(panorama);
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List listaPanorama() {
        List<Persistencia.Panorama> listPanorama = null;
        try {
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query q = inicio.getSession().createQuery("from Panorama");
            listPanorama = (List<Persistencia.Panorama>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPanorama;
    }
    
    public List listaPanormaValidacionRiesgo(int idproceso, int idriesgo){
        List<Persistencia.Panorama> listaRiesgos = null;
        try {
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query q = inicio.getSession().createQuery("from Panorama p  "
                    + "where p.proceso.idproceso = :idproceso and p.riesgoByIdcausa.idriesgo = :idriesgo");
            q.setParameter("idproceso", idproceso);
            q.setParameter("idriesgo", idriesgo);
            listaRiesgos = (List<Persistencia.Panorama>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaRiesgos;
    }
}
