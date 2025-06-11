package DAO;

import POJOS.Cliente;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class ClienteDAO implements DAO<Cliente, String>{

    private static final String INSERTAR_CLIENTE = "INSERT INTO CLIENTE (DNI, nombre, apellidos, telefono, f_nacimiento, direccion, email, activo, pass, saldo_cuenta, num_pedidos, dir_envio, tarjeta_fidelizacion, m_pago) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_LOGIN = "SELECT DNI, nombre, apellidos, telefono, f_nacimiento, direccion, email, activo, pass, saldo_cuenta, num_pedidos, dir_envio, tarjeta_fidelizacion, m_pago FROM CLIENTE WHERE email = ? AND pass  = ?";
    private static final String ACTUALIZAR_CLIENTE = "UPDATE CLIENTE SET telefono = ?, f_nacimiento = ?, direccion = ?, email = ?, dir_envio= ? WHERE DNI = ?";

    public void registrar(Cliente cliente) {
        try (Connection conn = DBUtils.getConexion();
             PreparedStatement ps = conn.prepareStatement(INSERTAR_CLIENTE)) {

            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getTelefono());
            ps.setDate(5,  new Date(cliente.getfNacimiento().getTime()));
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

    public void login(Cliente cliente) throws IOException, SQLException {
        Connection conn = DBUtils.getConexion();

        try (PreparedStatement ps = conn.prepareStatement(SQL_LOGIN)) {
            ps.setString(1, cliente.getEmail());
            ps.setString(2, cliente.getPass());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente.setDni(                 rs.getString("DNI"));
                    cliente.setNombre(              rs.getString("nombre"));
                    cliente.setApellidos(           rs.getString("apellidos"));
                    cliente.setTelefono(            rs.getString("telefono"));
                    cliente.setfNacimiento(         rs.getDate("f_nacimiento"));
                    cliente.setDireccion(           rs.getString("direccion"));
                    cliente.setEmail(               rs.getString("email"));
                    cliente.setActivo(              rs.getBoolean("activo"));
                    cliente.setPass(                rs.getString("pass"));
                    cliente.setSaldo_cuenta(        rs.getFloat("saldo_cuenta"));
                    cliente.setNum_pedidos(         rs.getInt("num_pedidos"));
                    cliente.setDir_envio(           rs.getString("dir_envio"));
                    cliente.setTarjeta_fidelizacion(rs.getBoolean("tarjeta_fidelizacion"));
                    cliente.setM_pago(              rs.getInt("m_pago"));
                } else {
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error en la autenticación.", e);
        }
    }

    public void update(Cliente cliente) throws SQLException {
        try (Connection conn = DBUtils.getConexion();
             PreparedStatement ps = conn.prepareStatement(ACTUALIZAR_CLIENTE)) {

            ps.setString(1, cliente.getTelefono());
            LocalDate fechaNacimiento = cliente.getfNacimiento().toLocalDate();
            ps.setDate(2, Date.valueOf(fechaNacimiento));
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getDir_envio());
            ps.setString(5, cliente.getEmail());
            ps.setString(6, cliente.getDni());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Se ha producido un error en la actualización.", e);
        }
    }



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
}
