package POJOS;

import java.sql.Date;

public class Cliente extends Usuario {

    // Atributo de clase para realizar un seguimiento del número total de clientes
    private static int totalClientes = 0;

    private float saldo_cuenta;
    private int num_pedidos;
    private String dir_envio;
    private boolean tarjeta_fidelizacion;
    private int m_pago;


    public Cliente(String user, String dni, String nombre, String apellidos, String telefono, String fNacimiento, String direccion,
                   String email, boolean activo, String pass, float saldo_cuenta, int num_pedidos, String dir_envio,
                   boolean tarjeta_fidelizacion, int m_pago) {
        super();
        this.saldo_cuenta = saldo_cuenta;
        this.num_pedidos = num_pedidos;
        this.dir_envio = dir_envio;
        this.tarjeta_fidelizacion = tarjeta_fidelizacion;
        this.m_pago = m_pago;
        totalClientes++;
    }

    public Cliente(String dni, String nombre, String apellidos, String telefono, Date fNacimiento, String direccion,
                   String email, boolean activo, String pass, float saldo_cuenta, int num_pedidos, String dir_envio,
                   boolean tarjeta_fidelizacion, int m_pago) {
        super(dni, nombre, apellidos, telefono, fNacimiento, direccion, email, activo, pass);
        this.saldo_cuenta = saldo_cuenta;
        this.num_pedidos = num_pedidos;
        this.dir_envio = dir_envio;
        this.tarjeta_fidelizacion = tarjeta_fidelizacion;
        this.m_pago = m_pago;
    }


    public Cliente(String dni, String nombre, String apellidos, String email, float saldo_cuenta, int num_pedidos,
                   String dir_envio, boolean tarjeta_fidelizacion, int m_pago) {
        super(dni, nombre, apellidos, email);
        this.saldo_cuenta = saldo_cuenta;
        this.num_pedidos = num_pedidos;
        this.dir_envio = dir_envio;
        this.tarjeta_fidelizacion = tarjeta_fidelizacion;
        this.m_pago = m_pago;
    }

    public Cliente(String dni, String nombre, String apellidos, int telefono, Date fNacimiento, String direccion, String email, String pass, boolean fideliz) {
        super();

    }

    // Métodos abstractos implementados
    @Override
    public String info() {
        return "Cliente: "+
                "DNI :" + getDni() + '\n' +
                "Nombre :" + getNombre() + "apellidos :'" + getApellidos() + '\n' +
                "Teléfono : '" + getTelefono() + '\n' +
                "Fecha de nacimiento :" + getfNacimiento() +'\n' +
                "Dirección :" + getDireccion() +'\n' +
                "Email :" + getEmail() + '\n' +
                "Está activo : " + isActivo() + '\n' +
                "Direccion de envio : " + getDir_envio() + '\n' +
                "Método de pago :"+getM_pago()+'\n'+
                "Saldo de la Cuenta=" + getSaldo_cuenta() + "\n"+
                "Tiene tarjeta de Fidelidad :" + isTarjeta_fidelizacion() + "\n"+
                "Número de pededidos realizados :" + getNum_pedidos() + '\n';
    }

    // Getters y setters para los atributos de Cliente

    public static int getTotalClientes() {
        return totalClientes;
    }

    public static void setTotalClientes(int totalClientes) {
        Cliente.totalClientes = totalClientes;
    }

    public float getSaldo_cuenta() {
        return saldo_cuenta;
    }

    public void setSaldo_cuenta(float saldo_cuenta) {
        this.saldo_cuenta = saldo_cuenta;
    }

    public int getNum_pedidos() {
        return num_pedidos;
    }

    public void setNum_pedidos(int num_pedidos) {
        this.num_pedidos = num_pedidos;
    }

    public String getDir_envio() {
        return dir_envio;
    }

    public void setDir_envio(String dir_envio) {
        this.dir_envio = dir_envio;
    }

    public boolean isTarjeta_fidelizacion() {
        return tarjeta_fidelizacion;
    }

    public void setTarjeta_fidelizacion(boolean tarjeta_fidelizacion) {
        this.tarjeta_fidelizacion = tarjeta_fidelizacion;
    }

    public int getM_pago() {
        return m_pago;
    }

    public void setM_pago(int m_pago) {
        this.m_pago = m_pago;
    }
}