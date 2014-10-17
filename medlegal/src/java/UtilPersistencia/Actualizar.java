/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilPersistencia;

import Persistencia.*;
import java.util.Date;
import org.hibernate.Query;
import tools.UsuarioActivo;

/**
 *
 * @author jacs
 */
public class Actualizar {

    iniciarHibernate inicio;

    public Actualizar() {
        inicio = new iniciarHibernate();
    }

    public void riesgoModificar(Object objeto, int idestado) {
        Riesgo riesgo = (Riesgo) objeto;
        try {
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query query = inicio.session.createQuery("update Riesgo set idestado = :estado"
                    + " where idriesgo = :id");
            System.out.println("Numero del estado ------- " + idestado);
            query.setParameter("estado", idestado);
            query.setParameter("id", riesgo.getIdriesgo());
            int result = query.executeUpdate();
            inicio.getSession().getTransaction().commit();
            System.out.println("Actualizar riesgo resultado de la modificacion: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void areaModificar(Object objeto) {
        Area area = (Area) objeto;
        try {
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query query = inicio.session.createQuery("update Area set descripcion = :descrip"
                    + " where idarea = :id");
            query.setParameter("descrip", "'" + area.getDescarea() + "'");
            query.setParameter("id", area.getIdarea());
            int result = query.executeUpdate();
            inicio.getSession().getTransaction().commit();
            System.out.println("Actualir area resultado de la modificacion: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void funcionarioModificar(Object objeto) {
        Funcionario funcionario = (Funcionario) objeto;
        try {
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query query = inicio.session.createQuery("update Funcionario set nombre = :nombre , apellido= :apellido ,"
                    + "segnombre= :segnombre , segapellido= :segapellido , telefono = :telefono"
                    + ", correo= :correo , ciu_idciudad2 = :ciu_idciudad2 , direccion= :direccion , idgrado= :idgrado"
                    + ", idclase = :idclase , idcargo = :idcargo , idsubarea = :idsubarea where idfuncionario = :id");
            query.setParameter("nombre", funcionario.getNombre());
            query.setParameter("apellido", funcionario.getApellido());
            query.setParameter("segnombre", funcionario.getSegnombre());
            query.setParameter("segapellido", funcionario.getSegapellido());
            query.setParameter("telefono", funcionario.getTelefono());
            query.setParameter("correo", funcionario.getCorreo());
            query.setParameter("ciu_idciudad2", funcionario.getCiudadByIdciudad().getIdciudad());
            query.setParameter("direccion", "'" + funcionario.getDireccion() + "'");
            query.setParameter("idgrado", funcionario.getGrado().getIdgrado());
            query.setParameter("idclase", funcionario.getClase().getIdclase());
            query.setParameter("idcargo", funcionario.getCargo().getIdcargo());
            query.setParameter("idsubarea", funcionario.getSubarea().getIdsubarea());
            query.setParameter("id", funcionario.getIdfuncionario());
            int result = query.executeUpdate();
            inicio.getSession().getTransaction().commit();
            System.out.println("Actualizar funcionario resultado de la modificacion: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void procesoModificar(Object objeto, int estado, int funcionario) {
        Proceso proceso = (Proceso) objeto;

        if (estado == 0) {
            estado = proceso.getEstado().getIdestado();
        }
        if (funcionario == 0) {
            funcionario = proceso.getFuncionario().getIdfuncionario();
        }
        try {
            //traza modificacion de prcoeso            
            Trazaproceso traza = new Trazaproceso();
            traza.setProceso(proceso);
            traza.setProcesoasociado(proceso.getProcesoasociado().getDescasociado());
            traza.setNombreproceso(proceso.getProcesoasociado().getNombreproceso().getDescnombre());
            traza.setTipoproceso(proceso.getProcesoasociado().getNombreproceso().getTipoproceso().getDesctipo());
            traza.setSubarea(proceso.getSubarea().getDescsubarea());
            traza.setFuncionarioasociado(proceso.getFuncionario().getNombre() + " " + proceso.getFuncionario().getApellido()
                    + "(" + proceso.getFuncionario().getIdentificacion() + ")");
            traza.setEstado(proceso.getEstado().getDescestado());
            UsuarioActivo usuario = new UsuarioActivo();
            traza.setUsuariooperacion(usuario.getUsuarioNombre());
            Date fechamodi = new Date();
            traza.setFechaoperacion(fechamodi);
            traza.setTipooperacion("Modificado");

            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(traza);

            Query query = inicio.session.createQuery("update Proceso set idestado = :estado , idfuncionario = :funcionario, "
                    + "modificado = :modificado where idproceso = :id");
            query.setParameter("estado", estado);
            query.setParameter("funcionario", funcionario);
            query.setParameter("id", proceso.getIdproceso());
            query.setParameter("modificado", fechamodi);
            System.out.println("CLASE ACTUALIZAR " + estado + funcionario + proceso.getIdproceso());
            int result = query.executeUpdate();
            inicio.getSession().getTransaction().commit();
            System.out.println("Actualizar proceso resultado de la modificacion: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clasificacionModificar(Object objeto) {
        Clasificacion clasificacion = (Clasificacion) objeto;
        try {
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query query = inicio.session.createQuery("update Clasificacion set descclasificacion = :descrip"
                    + " where idclasificacion = :id");
            query.setParameter("descrip", clasificacion.getDescclasificacion());
            query.setParameter("id", clasificacion.getIdclasificacion());
            int result = query.executeUpdate();
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enfoqueModificar(Object objeto) {
        Enfoque obje = (Enfoque) objeto;
        try {
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query query = inicio.session.createQuery("update Enfoque set descenfoque = :descrip"
                    + " where idenfoque = :id");
            query.setParameter("descrip", obje.getDescenfoque());
            query.setParameter("id", obje.getIdenfoque());
            int result = query.executeUpdate();
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void estadoModificar(Object objeto) {
        Estado obje = (Estado) objeto;
        try {
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query query = inicio.session.createQuery("update Estado set descestado = :descrip"
                    + " where idestado = :id");
            query.setParameter("descrip", obje.getDescestado());
            query.setParameter("id", obje.getIdestado());
            int result = query.executeUpdate();
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void nombreProModificar(Object objeto) {
        Nombreproceso obje = (Nombreproceso) objeto;
        try {
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query query = inicio.session.createQuery("update Nombreproceso set descnombre = :descrip"
                    + " where idnombreproceso = :id");
            query.setParameter("descrip", obje.getDescnombre());
            query.setParameter("id", obje.getIdnombreproceso());
            int result = query.executeUpdate();
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tipoProModificar(Object objeto) {
        Tipoproceso obje = (Tipoproceso) objeto;
        try {
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query query = inicio.session.createQuery("update Tipoproceso set desctipo = :descrip"
                    + " where idtipoproceso = :id");
            query.setParameter("descrip", obje.getDesctipo());
            query.setParameter("id", obje.getIdtipoproceso());
            int result = query.executeUpdate();
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void departamentoModificar(Object objeto) {
        Departamento obje = (Departamento) objeto;
        try {
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query query = inicio.session.createQuery("update Departamento set descdepartamento = :descrip"
                    + " where iddepartamento = :id");
            query.setParameter("descrip", obje.getDescdepartamento());
            query.setParameter("id", obje.getIddepartamento());
            int result = query.executeUpdate();
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ciudadModificar(Object objeto) {
        Ciudad obje = (Ciudad) objeto;
        try {
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query query = inicio.session.createQuery("update Ciudad set descciudad = :descrip"
                    + " where idciudad = :id");
            query.setParameter("descrip", obje.getDescciudad());
            query.setParameter("id", obje.getIdciudad());
            int result = query.executeUpdate();
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mejoramientoModificar(Object objeto) {
        Planmejoramiento obje = (Planmejoramiento) objeto;
        try {
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query query = inicio.session.createQuery("update Planmejoramiento set mejoramiento = :descrip"
                    + " where idmejoramiento = :id");
            query.setParameter("descrip", obje.getMejoramiento());
            query.setParameter("id", obje.getIdmejoramiento());
            int result = query.executeUpdate();
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void usuarioModificar(Object objeto, int idperfil) {
        Usuario obje = (Usuario) objeto;
        try {
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query query = inicio.session.createQuery("update Usuario set idperfil = :idperfil where idusuario = :id");
            query.setParameter("idperfil", idperfil);
            query.setParameter("id", obje.getIdusuario());
            int result = query.executeUpdate();
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
