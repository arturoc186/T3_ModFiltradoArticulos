package POJOS;

import java.sql.Date;

public class Empleado extends Usuario {

    // Atributo de clase para realizar un seguimiento del número total Empleados
    private static int totalEmpleados = 0;

    // atributos de instancia
    private Departamento departamento;
    private boolean tienePrivilegios;

    public Empleado(String user, String dni, String nombre, String apellidos, String telefono, String fNacimiento, String direccion,
                    String email, boolean activo, String pass, Departamento departamento, boolean tienePrivilegios) {
        super();
        this.departamento = departamento;
        this.tienePrivilegios = tienePrivilegios;
    }

    public Empleado(String dni, String nombre, String apellidos, String telefono, Date fNacimiento, String direccion,
                    String email, boolean activo, String pass, Departamento departamento, boolean tienePrivilegios) {
        super(dni, nombre, apellidos, telefono, fNacimiento, direccion, email, activo, pass);
        this.departamento = departamento;
        this.tienePrivilegios = tienePrivilegios;
    }

    public Empleado(String dni, String nombre, String apellidos, String email, Departamento departamento,
                    boolean tienePrivilegios) {
        super(dni, nombre, apellidos, email);
        this.departamento = departamento;
        this.tienePrivilegios = tienePrivilegios;
    }

    // Getters y setters para los atributos de Administrador
    public static int getTotalEmpleados() {
        return totalEmpleados;
    }

    public static void setTotalEmpleados(int totalEmpleados) {
        Empleado.totalEmpleados = totalEmpleados;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public boolean isTiene_privilegios() {
        return tienePrivilegios;
    }

    public void setTiene_privilegios(boolean tiene_privilegios) {
        this.tienePrivilegios = tiene_privilegios;
    }

    // Métodos abstractos implementados
    @Override
    public String info() {
        return "Empleado: "+
                "DNI :" + getDni() + '\n' +
                "Nombre :" + getNombre() + "apellidos :'" + getApellidos() + '\n' +
                "Teléfono : '" + getTelefono() + '\n' +
                "Fecha de nacimiento :" + getfNacimiento() +'\n' +
                "Dirección :" + getDireccion() +'\n' +
                "Email :" + getEmail() + '\n' +
                "Está activo : " + isActivo() + '\n' +
                "Departamento código :" + departamento.getCodigo()+" "+departamento.getNombre() + '\n' +
                "tiene prililegios :" + isTiene_privilegios() + '\n';
    }

}