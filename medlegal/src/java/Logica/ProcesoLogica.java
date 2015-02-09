/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Estado;
import Persistencia.Funcionario;
import Persistencia.Proceso;
import Persistencia.Procesoasociado;
import Persistencia.Subarea;
import Utilidades.iniciarHibernate;
import java.util.Date;
import org.hibernate.Query;

/**
 *
 * @author jhecohe
 */
public class ProcesoLogica {

    iniciarHibernate inicio;

    public ProcesoLogica() {
        inicio = new iniciarHibernate();
    }

    public int agregarProceso(int codigo, int idasociado, int idsubarea, int idfuncionario) {
        org.hibernate.Transaction tx = null;
        int llave = 0;
        try {
            Subarea subarea = new Subarea();
            subarea.setIdsubarea(idsubarea);
            Procesoasociado asociado = new Procesoasociado();
            asociado.setIdprocesoasociado(idasociado);
            Funcionario funcionario = new Funcionario();
            funcionario.setIdfuncionario(idfuncionario);
            Estado estado = new Estado();
            estado.setIdestado(1);
            String id = "" + codigo + buscarProcesoUltimoRegistro() + 1;
            Date fechainicio = new Date();

            Proceso proceso = new Proceso();
            proceso.setEstado(estado);
            proceso.setSubarea(subarea);
            proceso.setProcesoasociado(asociado);
            proceso.setFuncionario(funcionario);
            proceso.setCodigoproceso(id);
            proceso.setCreado(fechainicio);

            tx = inicio.getSession().beginTransaction();
            llave = (Integer) inicio.getSession().save(proceso);
            tx.commit();
            //trazaProceso(llave);

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return llave;
    }

    public int buscarProcesoUltimoRegistro() {
        int id = 0;
        try {
            inicio.getSession().beginTransaction();
            Query q = inicio.getSession().createQuery("select max(p.idproceso) from Proceso p");
            //Query q = inicio.getSession().createQuery("from Proceso order by idproceso desc");
            if (q.uniqueResult() == null) {
                id = 1;
            } else {
                id = (Integer) q.uniqueResult();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}
