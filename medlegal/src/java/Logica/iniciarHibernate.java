/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import org.hibernate.Session;

/**
 *
 * @author jacs
 */
public class iniciarHibernate {

    Session session = null;

    public iniciarHibernate() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
