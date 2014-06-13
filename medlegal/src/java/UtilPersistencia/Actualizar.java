/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilPersistencia;

import Persistencia.Area;
import Persistencia.Funcionario;
import Persistencia.Riesgo;
import org.hibernate.Query;

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
        Query query = inicio.session.createQuery("update Area set descripcion = :descrip"
                + " where idarea = :id");
        query.setParameter("descrip", "'" + area.getDescarea() + "'");
        query.setParameter("id", area.getIdarea());
        int result = query.executeUpdate();
        inicio.getSession().getTransaction().commit();
        System.out.println("Actualir area resultado de la modificacion: " + result);
    }

    public void funcionarioModificar(Object objeto) {
        Funcionario funcionario = (Funcionario) objeto;
        try {
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query query = inicio.session.createQuery("update Funcionario set nombre = :nombre , apellido= :apellido ,"
                    + "segnombre= :segnombre , segapellido= :segapellido , telefono = :telefono"
                    + ", correo= :correo , ciu_idciudad2 = :ciu_idciudad2 , direccion= :direccion , idgrado= :idgrado"
                    + ", idclase = :idclase , idcargo = :idcargo , idsubarea = :idsubarea where idfuncionario = :id");
            query.setParameter("nombre", funcionario.getNombre() );
            query.setParameter("apellido", funcionario.getApellido());
            query.setParameter("segnombre", funcionario.getSegnombre());
            query.setParameter("segapellido", funcionario.getSegapellido());
            query.setParameter("telefono", funcionario.getTelefono());
            query.setParameter("correo", funcionario.getCorreo());
            query.setParameter("ciu_idciudad2", funcionario.getCiudadByIdciudad().getIdciudad());
            query.setParameter("direccion", "'" + funcionario.getDireccion() + "'");
            query.setParameter("idgrado",  funcionario.getGrado().getIdgrado());
            query.setParameter("idclase",  funcionario.getClase().getIdclase());
            query.setParameter("idcargo",  funcionario.getCargo().getIdcargo());
            query.setParameter("idsubarea",funcionario.getSubarea().getIdsubarea());
            query.setParameter("id", funcionario.getIdfuncionario());
            int result = query.executeUpdate();
            inicio.getSession().getTransaction().commit();
            System.out.println("Actualizar funcionario resultado de la modificacion: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
