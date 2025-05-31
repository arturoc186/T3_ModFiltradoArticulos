package DAO;

import POJOS.Cliente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ClienteDAO implements DAO<Cliente, String>{

    private static final String INSERTAR_CLIENTE = """
        INSERT INTO CLIENTE (DNI, nombre, apellidos, telefono, f_nacimiento, direccion, email,
            activo, pass, saldo_cuenta, num_pedidos, dir_envio, tarjeta_fidelizacion, m_pago) 
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    """;


    @Override
    public void insertar(Cliente obj) {

    }

    @Override
    public Cliente obtenerPorId(String id) {
        return null;
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return List.of();
    }

    @Override
    public void actualizar(Cliente obj) {

    }

    @Override
    public void eliminar(String id) {

    }

    public void registrar(Cliente cliente) {
        try (Connection conn = DBUtils.getConexion();
             PreparedStatement ps = conn.prepareStatement(INSERTAR_CLIENTE)) {

            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getTelefono());
            ps.setDate(5,   new Date(cliente.getfNacimiento().getTime()));
            ps.setString(6, cliente.getDireccion());
            ps.setString(7, cliente.getEmail());
            ps.setBoolean(8, cliente.isActivo());
            ps.setString(9, cliente.getPass());
            ps.setFloat(10, cliente.getSaldo_cuenta());
            ps.setInt(11,   cliente.getNum_pedidos());
            ps.setString(12, cliente.getDir_envio());
            ps.setBoolean(13, cliente.isTarjeta_fidelizacion());
            ps.setInt(14, cliente.getM_pago());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Se ha producido un error en la inserción", e);
        }
    }
}
