package DAO;

import POJOS.LineaPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LineaPedidoDAO {
    public void insertarLineaPedido(int codArt, int numeroPedido) throws SQLException {
        String sql = "INSERT INTO LINEA_PEDIDO (cod_art, num_pedido) VALUES (?, ?)";

        try (Connection con = DBUtils.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, codArt);
            ps.setInt(2, numeroPedido);

            ps.executeUpdate();
        }
    }

    public void insertarLineaPedido() {
    }
}
