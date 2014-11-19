/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;


import Persistencia.*;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;


/**
 *
 * @author jacs
 */
public class Listados implements Serializable{

    iniciarHibernate inicio;
    Funcionario funcionario;

    public Listados() {
        inicio = new iniciarHibernate();
    }
    
    public List listaDepartamentos() {
        List<Departamento> listDepartamento = null;
        try {
            inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Departamento");
            listDepartamento = (List<Departamento>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDepartamento;
    }
    
    public List listaCiudad() {
        List<Ciudad> listCiudad = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Ciudad order by descciudad");
            listCiudad = (List<Ciudad>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCiudad;
    }
    
    public List listaGrado() {
        List<Grado> listGrado = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Grado");
            listGrado = (List<Grado>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGrado;
    }
    
    public List listaCargo() {
        List<Cargo> listCargo = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Cargo");
            listCargo = (List<Cargo>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCargo;
    }
    
    public List listaClase() {
        List<Clase> listClase = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Clase");
            listClase = (List<Clase>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listClase;
    }
    
    public List listaFuncionarios() {
        List<Funcionario> listFuncionario = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Funcionario");
            listFuncionario = (List<Funcionario>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listFuncionario;
    }
    
    public List listaFuncionariosbySubArea(int idsubarea) {
        List<Funcionario> listFuncionario = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Funcionario where idsubarea = :idsubarea");
            q.setParameter("idsubarea", idsubarea);
            listFuncionario = (List<Funcionario>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listFuncionario;
    }
    
    public Funcionario funcionario(int funcionari) {
        funcionario = new Funcionario();
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Funcionario f  where f.idfuncionario = :funcionario");
            q.setParameter("funcionario", funcionari);
            funcionario = (Funcionario) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return funcionario;
    }
    
    public List listaPerfiles() {
        List<Perfil> listPerfiles = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Perfil");
            listPerfiles = (List<Perfil>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPerfiles;
    }
    
    public List listaPanoramabyProceso(int proceso) {
    //public List listaPanoramabyProceso() {
        List<Panorama> listPanoramaRiesgo = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Panorama pr where pr.proceso.idproceso = :proceso");
            q.setParameter("proceso", proceso);
            listPanoramaRiesgo = (List<Panorama>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPanoramaRiesgo;
    }
    
    public Panorama panoramabyProceso(int proceso) {
    //public List listaPanoramabyProceso() {
        Panorama panora = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Panorama pr where proceso.idproceso = :proceso");
            q.setParameter("proceso", proceso);
            panora = (Panorama)q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return panora;
    }
    
    public List listaProceso() {
        List<Proceso> listProceso = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Proceso");
            listProceso = (List<Proceso>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProceso;
    }
    
    public List listaProcesoByParametro(String idproceso) {
        List<Proceso> listProceso = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("select p.codigo from Proceso p where cast(p.codigo as string) like :id");
            q.setParameter("id", "%"+idproceso+"%");
            listProceso = (List<Proceso>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProceso;
    }
    
    public List listaEnfoque() {
        List<Enfoque> listEnfoque = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Enfoque");
            listEnfoque = (List<Enfoque>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listEnfoque;
    }
    
    public List listaClasificacion() {
        List<Clasificacion> listClasificacion = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Clasificacion");
            listClasificacion = (List<Clasificacion>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listClasificacion;
    }
    
    public List listaRiesgo() {
        List<Riesgo> listRiesgo = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Riesgo  order by idriesgo");
            listRiesgo = (List<Riesgo>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRiesgo;
    }
    
    public List listaRiesgoValoracion(int idproceso) {
        List<Panorama> listRiesgo = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            //Query q = inicio.session.createQuery("select p.riesgo from Panoramariesgos p where p.proceso.idproceso = :proceso");
            Query q = inicio.session.createQuery("from Panorama p where p.proceso.idproceso = :proceso");
            q.setParameter("proceso", idproceso);
            listRiesgo = (List<Panorama>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRiesgo;
    }
    
    public List listaMejoramiento(int idriesgo) {
        List<Planmejoramiento> listRiesgo = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            //Query q = inicio.session.createQuery("select p.riesgo from Panoramariesgos p where p.proceso.idproceso = :proceso");
            Query q = inicio.session.createQuery("from Panorama p where p.riesgoByIdcausa.idriesgo = :riesgo");
            q.setParameter("riesgo", idriesgo);
            listRiesgo = (List<Planmejoramiento>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRiesgo;
    }
    
    public List listaRiesgoByParametro(String descripcion) {
        List<Riesgo> listRiesgo = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("select r.idriesgo from Riesgo r where deescripcion like :descripcion");
            q.setParameter("descripcion", "%"+descripcion+"%");
            listRiesgo = (List<Riesgo>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRiesgo;
    }
    
    public List listaArea() {
        List<Area> listArea = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Area");
            listArea = (List<Area>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listArea;
    }
    
    public List listaAreabySeccional(int seccional) {
        List<Area> listArea = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Area a  where a.seccional.idseccional = :seccional");
            q.setParameter("seccional", seccional);
            listArea = (List<Area>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listArea;
    }
    
    public List listaEstado() {
        List<Estado> listEstado = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Estado");
            listEstado = (List<Estado>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listEstado;
    }
    
    public List listaSubarea() {
        List<Subarea> listSubarea = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Subarea");
            listSubarea = (List<Subarea>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSubarea;
    }
    
    public List listaSubareabyArea(int area) {
        List<Subarea> listSubarea = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Subarea s  where s.area.idarea = :area");
            q.setParameter("area", area);
            listSubarea = (List<Subarea>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSubarea;
    }
    
    public List listaTipoproceso() {
        List<Tipoproceso> listTipoproceso = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Tipoproceso");
            listTipoproceso = (List<Tipoproceso>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTipoproceso;
    }
    
    public List listaNombreproceso() {
        List<Nombreproceso> listNombreproceso = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Nombreproceso");
            listNombreproceso = (List<Nombreproceso>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNombreproceso;
    }
    
    public List listaNombreprocesobyTipo(int idtipo) {
        List<Nombreproceso> listNombreproceso = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Nombreproceso where idtipoproceso = :idtipo");
            q.setParameter("idtipo", idtipo);
            listNombreproceso = (List<Nombreproceso>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNombreproceso;
    }
    
    public List listaProcesoasociado() {
        List<Procesoasociado> listAsociado = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Procesoasociado");
            listAsociado = (List<Procesoasociado>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAsociado;
    }
    
    public List listaProcesoasociadobyNombre(int idnombre) {
        List<Procesoasociado> listAsociado = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Procesoasociado where idnombreproceso = :idnombre");
            q.setParameter("idnombre", idnombre);
            listAsociado = (List<Procesoasociado>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAsociado;
    }
    
    public List listaSeccional() {
        List<Seccional> listSeccional = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Seccional");
            listSeccional = (List<Seccional>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSeccional;
    }
    
    public List listaSeccionalbyRegion(int region) {
        List<Seccional> listSeccional = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Seccional s  where s.regional.idregional = :region");
            q.setParameter("region", region);
            listSeccional = (List<Seccional>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSeccional;
    }
    
    public List listaRegional() {
        List<Regional> listRegional = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Regional");
            listRegional = (List<Regional>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRegional;
    }
    
    public List listaPanorama() {
        List<Panorama> listPanorama = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Panorama");
            listPanorama = (List<Panorama>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPanorama;
    }
    
    public List listaPanormaValidacionRiesgo(int idproceso, int idriesgo){
        List<Panorama> listaRiesgos = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Panorama p  "
                    + "where p.proceso.idproceso = :idproceso and p.riesgoByIdcausa.idriesgo = :idriesgo");
            q.setParameter("idproceso", idproceso);
            q.setParameter("idriesgo", idriesgo);
            listaRiesgos = (List<Panorama>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaRiesgos;
    }
    
    public List listaProcesotobyId(int idproceso) {
        //Proceso proce = null;
        List<Proceso> proce = null;
        try {
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Proceso p  where p.idproceso = :idproceso");
            q.setParameter("idproceso", idproceso);
            proce = q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proce;
    }
    
    public List listaUsuario(){
        List<Usuario> usua = null;
        try{
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Usuario");
            usua = q.list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return usua;
    }
    
    public List listaValoracion(){
        List valoracion = null;
        try{
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Analisisvaloracion");
            valoracion = q.list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return valoracion;
    }
    
    public Usuario validacionUsuario(String usuario, String password){
        Usuario user = null;
        try{
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Usuario u where u.nombreusuario = :usuario and  u.clave = :password");
            q.setParameter("usuario", usuario);
            q.setParameter("password", password);
            user = (Usuario)q.uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
    
    public List listaCronograma(){
        List cronograma = null;
        try{
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Cronograma");
            cronograma = q.list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return cronograma; 
    }
    
    public List listaMejoramientobyRiesgo(int idriesgo){
        List mejora = null;
        System.out.println(idriesgo);
        try{
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            //Query q = inicio.session.createQuery("from Plandemejoramiento p where p.panoramaderiesgos.riesgoByIdriesgo.idriesgo = :riesgo");
            Query q = inicio.session.createQuery("from Planmejoramiento p where p.panorama.riesgoByIdcausa.idriesgo = :riesgo ");
            q.setParameter("riesgo", idriesgo);
            mejora = q.list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return mejora; 
    }
    
    public List listaRiesgoProcesobyAsociado(int idproceso){
        List rproceso = null;
        try{
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Proceso where idprocesoasociado = :idpro");
            q.setParameter("idpro", idproceso);
            rproceso = q.list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rproceso;
    }
    
    public List listaRiesgoResponsable(int idresponsable){
        List lrespon = null;
        try{
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Proceso p where p.funcionario.idfuncionario = :idrespon");
            q.setParameter("idrespon", idresponsable);
            lrespon = q.list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return lrespon;
    }
    
    public List listaTipo (){
        List tipo = null;
        try{
            org.hibernate.Transaction tx = inicio.session.beginTransaction();
            Query q = inicio.session.createQuery("from Tiporiesgo");
            tipo = q.list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return tipo;
    }
}
