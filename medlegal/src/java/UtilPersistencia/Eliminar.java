/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilPersistencia;

import java.io.Serializable;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author jhecohe
 */
public class Eliminar implements Serializable {

    iniciarHibernate inicio;

    public Eliminar() {
        inicio = new iniciarHibernate();
    }

    public void panorama(int codigo) {
        System.out.println("Procedemos a eliminar panorama :------- " );
        try {
            Transaction tx = inicio.getSession().beginTransaction();
            Query query = inicio.session.createQuery("delete from Panoramaderiesgos where "
                    + "idpanorama = :idpanorama");
            query.setParameter("idpanorama", codigo);
            int result = query.executeUpdate();
            tx.commit();
            System.out.println("Actualizar panorama resultado de la modificacion: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
