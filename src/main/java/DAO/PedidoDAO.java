package DAO;

import Controladores.CarritoController;
import POJOS.Pedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PedidoDAO {

    public int insertarPedido(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO PEDIDO (fecha, dir_envio, estado, m_pago, DNI_cliente) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBUtils.getConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDate(1, Date.valueOf(pedido.getFecha()));
            ps.setString(2, pedido.getDirEnvio());
            ps.setString(3, pedido.getEstado());
            ps.setInt(4, pedido.getMetodoPago());
            ps.setString(5, String.valueOf(pedido.getCliente()));

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }

    public static List<Pedido> obtenerPedidosPorCliente(String dni) throws SQLException {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM PEDIDO WHERE DNI_cliente = ? ORDER BY fecha DESC";

        try (Connection con = DBUtils.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setNumero(rs.getInt("numero"));
                pedido.setFecha(rs.getDate("fecha").toLocalDate());
                pedido.setEstado(rs.getString("estado"));
                pedido.setDirEnvio(rs.getString("dir_envio"));
                pedido.setCliente(rs.getString("DNI_cliente"));
                lista.add(pedido);
            }
        }
        return lista;
    }

}
