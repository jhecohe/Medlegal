package Persistencia;
// Generated 21/07/2014 10:05:29 AM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Funcionario generated by hbm2java
 */
public class Funcionario  implements java.io.Serializable {


     private int idfuncionario;
     private Grado grado;
     private Estado estado;
     private Ciudad ciudadByCiuIdciudad2;
     private Cargo cargo;
     private Ciudad ciudadByCiuIdciudad;
     private Ciudad ciudadByIdciudad;
     private Subarea subarea;
     private Clase clase;
     private String nombre;
     private String segnombre;
     private String apellido;
     private String segapellido;
     private int identificacion;
     private Date fechanacimiento;
     private String telefono;
     private String correo;
     private String direccion;
     private Set plandemejoramientos = new HashSet(0);
     private Set usuarios = new HashSet(0);
     private Set logs = new HashSet(0);
     private Set procesos = new HashSet(0);

    public Funcionario() {
    }

	
    public Funcionario(int idfuncionario, Grado grado, Estado estado, Ciudad ciudadByCiuIdciudad2, Cargo cargo, Ciudad ciudadByCiuIdciudad, Ciudad ciudadByIdciudad, Subarea subarea, Clase clase, String nombre, String apellido, int identificacion, Date fechanacimiento) {
        this.idfuncionario = idfuncionario;
        this.grado = grado;
        this.estado = estado;
        this.ciudadByCiuIdciudad2 = ciudadByCiuIdciudad2;
        this.cargo = cargo;
        this.ciudadByCiuIdciudad = ciudadByCiuIdciudad;
        this.ciudadByIdciudad = ciudadByIdciudad;
        this.subarea = subarea;
        this.clase = clase;
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.fechanacimiento = fechanacimiento;
    }
    public Funcionario(int idfuncionario, Grado grado, Estado estado, Ciudad ciudadByCiuIdciudad2, Cargo cargo, Ciudad ciudadByCiuIdciudad, Ciudad ciudadByIdciudad, Subarea subarea, Clase clase, String nombre, String segnombre, String apellido, String segapellido, int identificacion, Date fechanacimiento, String telefono, String correo, String direccion, Set plandemejoramientos, Set usuarios, Set logs, Set procesos) {
       this.idfuncionario = idfuncionario;
       this.grado = grado;
       this.estado = estado;
       this.ciudadByCiuIdciudad2 = ciudadByCiuIdciudad2;
       this.cargo = cargo;
       this.ciudadByCiuIdciudad = ciudadByCiuIdciudad;
       this.ciudadByIdciudad = ciudadByIdciudad;
       this.subarea = subarea;
       this.clase = clase;
       this.nombre = nombre;
       this.segnombre = segnombre;
       this.apellido = apellido;
       this.segapellido = segapellido;
       this.identificacion = identificacion;
       this.fechanacimiento = fechanacimiento;
       this.telefono = telefono;
       this.correo = correo;
       this.direccion = direccion;
       this.plandemejoramientos = plandemejoramientos;
       this.usuarios = usuarios;
       this.logs = logs;
       this.procesos = procesos;
    }
   
    public int getIdfuncionario() {
        return this.idfuncionario;
    }
    
    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }
    public Grado getGrado() {
        return this.grado;
    }
    
    public void setGrado(Grado grado) {
        this.grado = grado;
    }
    public Estado getEstado() {
        return this.estado;
    }
    
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public Ciudad getCiudadByCiuIdciudad2() {
        return this.ciudadByCiuIdciudad2;
    }
    
    public void setCiudadByCiuIdciudad2(Ciudad ciudadByCiuIdciudad2) {
        this.ciudadByCiuIdciudad2 = ciudadByCiuIdciudad2;
    }
    public Cargo getCargo() {
        return this.cargo;
    }
    
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    public Ciudad getCiudadByCiuIdciudad() {
        return this.ciudadByCiuIdciudad;
    }
    
    public void setCiudadByCiuIdciudad(Ciudad ciudadByCiuIdciudad) {
        this.ciudadByCiuIdciudad = ciudadByCiuIdciudad;
    }
    public Ciudad getCiudadByIdciudad() {
        return this.ciudadByIdciudad;
    }
    
    public void setCiudadByIdciudad(Ciudad ciudadByIdciudad) {
        this.ciudadByIdciudad = ciudadByIdciudad;
    }
    public Subarea getSubarea() {
        return this.subarea;
    }
    
    public void setSubarea(Subarea subarea) {
        this.subarea = subarea;
    }
    public Clase getClase() {
        return this.clase;
    }
    
    public void setClase(Clase clase) {
        this.clase = clase;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getSegnombre() {
        return this.segnombre;
    }
    
    public void setSegnombre(String segnombre) {
        this.segnombre = segnombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getSegapellido() {
        return this.segapellido;
    }
    
    public void setSegapellido(String segapellido) {
        this.segapellido = segapellido;
    }
    public int getIdentificacion() {
        return this.identificacion;
    }
    
    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }
    public Date getFechanacimiento() {
        return this.fechanacimiento;
    }
    
    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Set getPlandemejoramientos() {
        return this.plandemejoramientos;
    }
    
    public void setPlandemejoramientos(Set plandemejoramientos) {
        this.plandemejoramientos = plandemejoramientos;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }
    public Set getLogs() {
        return this.logs;
    }
    
    public void setLogs(Set logs) {
        this.logs = logs;
    }
    public Set getProcesos() {
        return this.procesos;
    }
    
    public void setProcesos(Set procesos) {
        this.procesos = procesos;
    }




}


