package DAO;

import POJOS.Articulo;
import POJOS.LineaPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<LineaPedido> obtenerLineasPorPedido(int numPedido) throws SQLException {
        List<LineaPedido> lista = new ArrayList<>();
        String sql = "SELECT A.* FROM LINEA_PEDIDO LP JOIN ARTICULO A ON LP.cod_art = A.cod_art WHERE LP.num_pedido = ?";

        try (Connection con = DBUtils.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, numPedido);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Articulo art = new Articulo(
                        rs.getInt("cod_art"),
                        rs.getString("nombre"),
                        rs.getFloat("precio"),
                        rs.getString("marca")
                ) {
                    @Override
                    public float calculaPrecioVenta(float dto) {
                        return 0;
                    }
                };
                lista.add(new LineaPedido(1, art));
            }
        }
        return lista;
    }

}
