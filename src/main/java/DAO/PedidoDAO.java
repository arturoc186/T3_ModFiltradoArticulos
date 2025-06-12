package DAO;

import Controladores.CarritoController;
import POJOS.Pedido;
import java.sql.*;


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
}
