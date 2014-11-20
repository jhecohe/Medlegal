/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Estadomejora;
import Persistencia.Funcionario;
import Persistencia.Planmejoramiento;
import Utilidades.iniciarHibernate;
import java.util.Date;

/**
 *
 * @author jhecohe
 */
public class MejoramientoLogica {
    
    iniciarHibernate inicio;
    
    public MejoramientoLogica(){
        inicio = new iniciarHibernate();
    }

    public void agregarMejoramiento(int idestado, int idpanorama, int idfuncionario, int reslutado, String mejora, Date revision) {
        org.hibernate.Transaction tx = null;
        try {
            Persistencia.Panorama panora = new Persistencia.Panorama();
            panora.setIdpanorama(idpanorama);
            Funcionario funcio = new Funcionario();
            funcio.setIdfuncionario(idfuncionario);
            Estadomejora estado = new Estadomejora();
            estado.setIdestadomejora(idestado);
            Planmejoramiento mejoramiento = new Planmejoramiento();
            mejoramiento.setPanorama(panora);
            mejoramiento.setFuncionario(funcio);
            mejoramiento.setResultado(reslutado);
            mejoramiento.setMejoramiento(mejora);
            mejoramiento.setFechainicio(new Date());
            mejoramiento.setFecharevision(revision);
            System.out.println("Agregar Mejorameinto aqui");
            tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(mejoramiento);
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}
