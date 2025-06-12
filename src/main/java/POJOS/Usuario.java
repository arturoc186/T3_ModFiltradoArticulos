package POJOS;

import java.sql.Date;

public abstract class Usuario {

    // Atributo de clase para realizar un seguimiento del número total de usuarios
    private static int totalUsuarios = 0;

    // atributos de instancia
    private String user;
    private String dni;
    private String nombre;
    private String apellidos;
    private String telefono;
    private Date fNacimiento;
    private String direccion;
    private String email;
    private boolean activo;
    private String pass;

    // Constructor principal
    public Usuario() {
        this.user = user;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fNacimiento = fNacimiento;
        this.direccion = direccion;
        this.email = email;
        this.activo = activo;
        this.pass = pass;
        // Incrementar el contador de usuarios cada vez que se crea una instancia
        totalUsuarios++;
    }

    public Usuario(String dni, String nombre, String apellidos, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    public Usuario(String dni, String nombre, String apellidos, String telefono, Date fNacimiento, String direccion, String email, boolean activo, String pass) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fNacimiento = fNacimiento;
        this.direccion = direccion;
        this.email = email;
        this.activo = activo;
        this.pass = pass;
    }

    // Métodos abstractos que deben ser implementados por las subclases
    public abstract String info();

    // Getters y setters para los atributos privados

    public static int getTotalUsuarios() {
        return totalUsuarios;
    }

    public static void setTotalUsuarios(int totalUsuarios) {
        Usuario.totalUsuarios = totalUsuarios;
    }

    public String getUser() { return user; }

    public void setUser(String user) { this.user = user; }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return(telefono);
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "user='" + user + '\'' +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", f_nacimiento=" + fNacimiento +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", activo=" + activo +
                ", pass='" + pass + '\'' +
                '}';
    }


}

