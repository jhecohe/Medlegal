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
public class Inserciones {

    iniciarHibernate inicio;

    public Inserciones() {
        inicio = new iniciarHibernate();
    }

    public boolean agregarDepartamento(String nombre, String codigo) {
        boolean respuesta = true;
        try {
            Departamento departamento = new Departamento();
            departamento.setDescdepartamento(nombre);
            departamento.setCodigodepartamento(codigo);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query q = inicio.session.createQuery("from Departamento where descdepartamento = :descripcion");
            q.setParameter("descripcion", nombre);
            if(q.uniqueResult() == null){
                inicio.getSession().persist(departamento);
                inicio.getSession().getTransaction().commit();
            }
            else
                respuesta = false;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
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

    public boolean agregarCiudad(String nombre, String codigo, int iddepartamento) {
        boolean respuesta = true;
        try {
            Ciudad ciudad = new Ciudad();
            Departamento departamento = new Departamento();
            ciudad.setDescciudad(nombre);
            ciudad.setCodigociudad(codigo);
            departamento.setIddepartamento(iddepartamento);
            ciudad.setDepartamento(departamento);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query q = inicio.session.createQuery("from Ciudad where descciudad = :descripcion");
            q.setParameter("descripcion", nombre);
            if(q.uniqueResult() == null){
                inicio.getSession().persist(ciudad);
                inicio.getSession().getTransaction().commit();
            }
            else
                respuesta = false;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
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

    public void agregarPerfil(String nombre) {
        try {
            Perfil perfil = new Perfil();
            perfil.setDescperfil(nombre);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(perfil);
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarUsuario(int idfuncionario, int idperfil, String nombre, String clave) {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setIdfuncionario(idfuncionario);
            Perfil roles = new Perfil();
            roles.setIdperfil(idperfil);
            Usuario usuario = new Usuario();
            usuario.setClave(clave);
            usuario.setFuncionario(funcionario);
            usuario.setNombreusuario(nombre);
            usuario.setPerfil(roles);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(usuario);
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean agregarEnfoque(String descripcion) {
        boolean respuesta = true;
        try {
            Enfoque enfoque = new Enfoque();
            enfoque.setDescenfoque(descripcion);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query q = inicio.session.createQuery("from Enfoque where descenfoque = :descripcion");
            q.setParameter("descripcion", descripcion);
            if(q.uniqueResult() == null){
                inicio.getSession().persist(enfoque);
                inicio.getSession().getTransaction().commit();
            }
            else
                respuesta = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public boolean agregarClasificacion(String descripcion) {
        boolean respuesta = true;
        try {
            Clasificacion clasi = new Clasificacion();
            clasi.setDescclasificacion(descripcion);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query q = inicio.session.createQuery("from Clasificacion where descclasificacion = :descripcion");
            q.setParameter("descripcion", descripcion);
            if(q.uniqueResult() == null){
                inicio.getSession().persist(clasi);
                inicio.getSession().getTransaction().commit();
            }
            else
                respuesta = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public boolean agregarRiesgo(int idclasificacion, int idenfoque, String nombre, String descripcion, int idtipo) {
        boolean respuesta = true;
        try {
            System.out.println("riesgo insercion agregar: " + nombre + "" + idenfoque + "" + idclasificacion + "" + idtipo);
            Clasificacion clasi = new Clasificacion();
            clasi.setIdclasificacion(idclasificacion);
            Enfoque enfoque = new Enfoque();
            enfoque.setIdenfoque(idenfoque);
            Tiporiesgo tipo = new Tiporiesgo();
            tipo.setIdtipo(idtipo);
            Estado estado = new Estado();
            estado.setIdestado(1);
            Riesgo riesgo = new Riesgo();
            riesgo.setNombre(nombre);
            riesgo.setDescriesgo(descripcion);
            riesgo.setEnfoque(enfoque);
            riesgo.setClasificacion(clasi);
            riesgo.setTiporiesgo(tipo);
            riesgo.setEstado(estado);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query q = inicio.session.createQuery("from Riesgo where nombre = :nombre");
            q.setParameter("nombre", nombre);
            if(q.uniqueResult() == null){
                inicio.getSession().persist(riesgo);
                inicio.getSession().getTransaction().commit();
            }else
                respuesta = false;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public boolean agregarArea(String nombre, int idseccional) {
        boolean respuesta = true;
        try {
            Seccional seccional = new Seccional();
            seccional.setIdseccional(idseccional);
            Area area = new Area();
            area.setDescarea(nombre);
            area.setSeccional(seccional);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query q = inicio.session.createQuery("from Area where descarea = :descripcion");
            q.setParameter("descripcion", nombre);
            if(q.uniqueResult() == null){
                inicio.getSession().persist(area);
                inicio.getSession().getTransaction().commit();
            }
            else
                respuesta = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
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

    public boolean agregarNombreProceso(String nombre, int idtipopro) {
        boolean respuesta = true;
        try {
            Tipoproceso tipoproceso = new Tipoproceso();
            tipoproceso.setIdtipoproceso(idtipopro);
            Nombreproceso nomproceso = new Nombreproceso();
            nomproceso.setDescnombre(nombre);
            nomproceso.setTipoproceso(tipoproceso);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query q = inicio.session.createQuery("from Nombreproceso where descnombre = :descripcion");
            q.setParameter("descripcion", nombre);
            if(q.uniqueResult() == null){
                inicio.getSession().persist(nomproceso);
                inicio.getSession().getTransaction().commit();
            }
            else
                respuesta = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public boolean agregarTipoProceso(String nombre) {
        boolean respuesta = true;
        try {
            Tipoproceso tipoproceso = new Tipoproceso();
            tipoproceso.setDesctipo(nombre);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query q = inicio.session.createQuery("from Tipoproceso where desctipo = :descripcion");
            q.setParameter("descripcion", nombre);
            if(q.uniqueResult() == null){
               inicio.getSession().persist(tipoproceso);
               inicio.getSession().getTransaction().commit(); 
            }
            else
                respuesta = false;            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public boolean agregarEstado(String descripcion) {
        boolean respuesta = true;
        try {
            Estado estado = new Estado();
            estado.setDescestado(descripcion);
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();                        
            Query q = inicio.session.createQuery("from Estado where descestado = :descripcion");
            q.setParameter("descripcion", descripcion);
            if(q.uniqueResult() == null){
                inicio.getSession().persist(estado);
                inicio.getSession().getTransaction().commit();
            }
            else
                respuesta = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
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

    public boolean agregarRegional(String nombre) {
        boolean respuesta = true;
        try {
            Regional regional = new Regional();
            regional.setDescregional(nombre);
            regional.setCodigoregional("null");
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            Query q = inicio.session.createQuery("from Regional where descregional = :descripcion");
            q.setParameter("descripcion", nombre);
            if(q.uniqueResult() == null){
                inicio.getSession().persist(regional);
                inicio.getSession().getTransaction().commit();
            }
            else
                respuesta = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
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
            
            //Traza de la creacion de proceso
            
            Trazaproceso traza = new Trazaproceso();
            System.out.println(asociado.getDescasociado()+"/"+asociado.getNombreproceso().getDescnombre()
                    +"/"+asociado.getNombreproceso().getTipoproceso().getDesctipo());
            traza.setProcesoasociado(asociado.getDescasociado());
            traza.setNombreproceso(asociado.getNombreproceso().getDescnombre());
            traza.setTipoproceso(asociado.getNombreproceso().getTipoproceso().getDesctipo());
            traza.setSubarea(subarea.getDescsubarea());
            traza.setFuncionarioasociado(funcionario.getNombre()+funcionario.getApellido()+""+ funcionario.getIdentificacion());
            traza.setEstado("activo");
            UsuarioActivo usuario = new UsuarioActivo();
            traza.setUsuariooperacion(usuario.getUsuarioNombre());
            traza.setFechaoperacion(fechainicio);
            traza.setTipooperacion("Creado");
            
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(proceso);
            inicio.getSession().persist(traza);
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
            Panorama panorama = new Panorama();
            panorama.setRiesgoByIdcausa(riesgo);
            panorama.setProceso(proceso);
            panorama.setRiesgoByIdefecto(causa);
            inicio.getSession().persist(panorama);
            inicio.getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarValoracion(int idpanorama, int origen, int probabilidad, int impacto, int calificacion, String color) {
        System.out.println("agregar valoracion   "+idpanorama+"/"+ origen+"/"+ probabilidad+"/"+ impacto+"/"+ calificacion+"/"+color);
        try {
            Panorama panorama = new Panorama();
            panorama.setIdpanorama(idpanorama);
            Analisisvaloracion valoracion = new Analisisvaloracion();
            valoracion.setPanorama(panorama);
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

    public void agregarMejoramiento(int idestado, int idpanorama, int idfuncionario, int reslutado, String mejora, Date revision) {
        try {
            Panorama panora = new Panorama();
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
            org.hibernate.Transaction tx = inicio.getSession().beginTransaction();
            inicio.getSession().persist(mejoramiento);
            inicio.getSession().getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
