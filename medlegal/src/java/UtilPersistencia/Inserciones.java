/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilPersistencia;

import Persistencia.*;
import java.util.Date;
import org.hibernate.Query;

/**
 *
 * @author jacs
 */
public class Inserciones {

    iniciarHibernate inicio;

    public Inserciones() {
        inicio = new iniciarHibernate();
    }

    public void agregarDepartamento(String nombre) {
        try {
            Departamento departamento = new Departamento();
            departamento.setDescdepartamento(nombre);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(departamento);
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarGrado(String nombre) {
        try {
            Grado grado = new Grado();
            grado.setDescgrado(nombre);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(grado);
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarCiudad(String nombre, int iddepartamento) {
        try {
            Ciudad ciudad = new Ciudad();
            Departamento departamento = new Departamento();
            ciudad.setDescciudad(nombre);
            departamento.setIddepartamento(iddepartamento);
            ciudad.setDepartamento(departamento);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(ciudad);
            inicio.getSession().getTransaction().commit();
            inicio.getSession().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarClase(String nombre) {
        try {
            Clase clase = new Clase();
            clase.setDescclase(nombre);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(clase);
            inicio.getSession().getTransaction().commit();
            inicio.getSession().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarCargo(String nombre) {
        try {
            Cargo cargo = new Cargo();
            cargo.setDesccargo(nombre);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(cargo);
            inicio.getSession().getTransaction().commit();
            inicio.getSession().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarFuncionario(int idgrado, int idciudad, int idclase, int idcargo, int idsubarea,
            String nombre, String segnombre, String apellido, String segapellido, int cedula,
            Date fechanacimiento, String telefono, String correo, String direccion, int idciudadexp,
            int idciudadreci) {
        try {
            Grado grado = new Grado();
            grado.setIdgrado(idgrado);
            Ciudad ciudadcedu = new Ciudad();
            ciudadcedu.setIdciudad(idciudad);
            Ciudad ciudadexp = new Ciudad();
            ciudadexp.setIdciudad(idciudadexp);
            Ciudad ciudadreci = new Ciudad();
            ciudadreci.setIdciudad(idciudadreci);
            Clase clase = new Clase();
            clase.setIdclase(idclase);
            Cargo cargo = new Cargo();
            cargo.setIdcargo(idcargo);
            Subarea subarea = new Subarea();
            subarea.setIdsubarea(idsubarea);
            Estado estado = new Estado();
            estado.setIdestado(1);
            Funcionario funcionario = new Funcionario();
            funcionario.setApellido(apellido);
            funcionario.setCargo(cargo);
            funcionario.setIdentificacion(cedula);
            funcionario.setCiudadByCiuIdciudad2(ciudadcedu);
            funcionario.setCiudadByCiuIdciudad(ciudadexp);
            funcionario.setCiudadByIdciudad(ciudadreci);
            funcionario.setClase(clase);
            funcionario.setSubarea(subarea);
            funcionario.setCorreo(correo);
            funcionario.setDireccion(direccion);
            funcionario.setFechanacimiento(fechanacimiento);
            funcionario.setGrado(grado);
            funcionario.setNombre(nombre);
            funcionario.setSegnombre(segnombre);
            funcionario.setSegapellido(segapellido);
            funcionario.setTelefono(telefono);
            funcionario.setEstado(estado);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(funcionario);
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarRoles(String nombre) {
        try {
            Rol roles = new Rol();
            roles.setDescrol(nombre);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(roles);
            inicio.getSession().getTransaction().commit();
            inicio.getSession().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarUsuario(int idfuncionario, int idroles, String nombre, String clave) {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setIdfuncionario(idfuncionario);
            Rol roles = new Rol();
            roles.setIdrol(idroles);
            Usuario usuario = new Usuario();
            usuario.setClave(clave);
            usuario.setFuncionario(funcionario);
            usuario.setNombreusuario(nombre);
            usuario.setRol(roles);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(usuario);
            inicio.getSession().getTransaction().commit();
            inicio.getSession().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public int idfuncionario (){
//        int id = -1;
//        try {
//            org.hibernate.Transaction tx = inicio.session.beginTransaction();
//            Query q = inicio.session.createQuery("select max(idfuncionario) from Funcionario");
//            id = (Integer) q.uniqueResult();
//            inicio.getSession().close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return id;
//    }
    public void agregarEnfoque(String descripcion) {
        try {
            Enfoque enfoque = new Enfoque();
            enfoque.setDescenfoque(descripcion);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(enfoque);
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarClasificacion(String descripcion) {
        try {
            Clasificacion clasi = new Clasificacion();
            clasi.setDescclasificacion(descripcion);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(clasi);
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarRiesgo(int idclasificacion, int idenfoque, String nombre, String descripcion) {
        try {
            System.out.println("riesgo insercion agregar: " + nombre + "" + idenfoque + "" + idclasificacion);
            Clasificacion clasi = new Clasificacion();
            clasi.setIdclasificacion(idclasificacion);
            Enfoque enfoque = new Enfoque();
            enfoque.setIdenfoque(idenfoque);
            Riesgo riesgo = new Riesgo();
            riesgo.setNombre(nombre);
            riesgo.setDescripcion(descripcion);
            riesgo.setEnfoque(enfoque);
            riesgo.setClasificacion(clasi);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(riesgo);
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarArea(String nombre, int idseccional) {
        try {
            Seccional seccional = new Seccional();
            seccional.setIdseccional(idseccional);
            Area area = new Area();
            area.setDescarea(nombre);
            area.setSeccional(seccional);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(area);
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarSubArea(int idarea, String nombre) {
        try {
            Area area = new Area();
            area.setIdarea(idarea);
            Subarea subarea = new Subarea();
            subarea.setArea(area);
            subarea.setDescsubarea(nombre);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(subarea);
            inicio.getSession().getTransaction().commit();
            inicio.getSession().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarNombreProceso(String nombre) {
        try {
            System.out.println("Inserciones nombreproceso");
            Nombreproceso nomproceso = new Nombreproceso();
            nomproceso.setDescnombre(nombre);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(nomproceso);
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarTipoProceso(String nombre) {
        try {
            Tipoproceso tipoproceso = new Tipoproceso();
            tipoproceso.setDesctipo(nombre);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(tipoproceso);
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarEstado(String nombre) {
        try {
            Estado estado = new Estado();
            estado.setDescestado(nombre);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(estado);
            inicio.getSession().getTransaction().commit();
            inicio.getSession().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarSeccional(String nombre, int idregional) {
        try {
            Regional regional = new Regional();
            regional.setIdregional(idregional);
            Seccional seccional = new Seccional();
            seccional.setDescseccional(nombre);
            seccional.setRegional(regional);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(seccional);
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarRegional(String nombre) {
        try {
            Regional regional = new Regional();
            regional.setDescregional(nombre);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(regional);
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarProceso(int codigo, int idasociado, int idsubarea, int idfuncionario) {
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
            Proceso proceso = new Proceso(estado, subarea, asociado, funcionario, id, fechainicio);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(proceso);
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int buscarProcesoUltimoRegistro() {
        int id = 0;
        try {
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
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

    public void agregarPanoramaRiesgos(int idproceso, int idriesgo, int idcausa) {
        try {
            //int idpanoramariesgos, Proceso proceso, Riesgo riesgo, int causa
            Proceso proceso = new Proceso();
            proceso.setIdproceso(idproceso);
            Riesgo riesgo = new Riesgo();
            riesgo.setIdriesgo(idriesgo);
            Riesgo causa = new Riesgo();
            causa.setIdriesgo(idcausa);
            Panoramaderiesgos panorama = new Panoramaderiesgos();
            panorama.setRiesgoByIdriesgo(riesgo);
            panorama.setProceso(proceso);
            panorama.setRiesgoByIdcausa(causa);
            inicio.getSession().persist(panorama);
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarValoracion(int idpanorama, int origen, int probabilidad, int impacto, int calificacion, String color) {
        System.out.println("agregar valoracion   "+idpanorama+"/"+ origen+"/"+ probabilidad+"/"+ impacto+"/"+ calificacion+"/"+color);
        try {
            Panoramaderiesgos panorama = new Panoramaderiesgos();
            panorama.setIdpanoramariesgos(idpanorama);
            Analisisvaloracion valoracion = new Analisisvaloracion();
            valoracion.setPanoramaderiesgos(panorama);
            valoracion.setOrigen(origen);
            valoracion.setProbabilidad(probabilidad);
            valoracion.setImpacto(impacto);
            valoracion.setControl(calificacion);
            valoracion.setColor(color);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(valoracion);
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarMejoramiento(int idcronograma, int idpanorama, int idfuncionario, int reslutado, String mejora) {
        try {
            Cronograma cronogra = new Cronograma();
            cronogra.setIdcronograma(idcronograma);
            Panoramaderiesgos panora = new Panoramaderiesgos();
            panora.setIdpanoramariesgos(idpanorama);
            Funcionario funcio = new Funcionario();
            funcio.setIdfuncionario(idfuncionario);
            Plandemejoramiento mejoramiento = new Plandemejoramiento();
            mejoramiento.setCronograma(cronogra);
            mejoramiento.setPanoramaderiesgos(panora);
            mejoramiento.setFuncionario(funcio);
            mejoramiento.setResultado(reslutado);
            mejoramiento.setMejoramiento(mejora);
            System.out.println("Agregar Mejorameinto aqui");
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(mejoramiento);
            inicio.getSession().getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    public int buscarMejoramientoUltimoRegistro() {
//        int id = 0;
//        try {
//            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
//            Query q = inicio.getSession().createQuery("select max(p.idmejoramiento) from Plandemejoramiento p");
//            //Query q = inicio.getSession().createQuery("from Proceso order by idproceso desc");
//            if (q.uniqueResult() == null) {
//                id = 1;
//            } else {
//                id = (Integer) q.uniqueResult();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return id;
//    }
}
