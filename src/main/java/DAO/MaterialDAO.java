package DAO;

import POJOS.Material;
import java.sql.*;

public class MaterialDAO {

    private static final String OBTENER_POR_ID = "SELECT codigo, denominacion FROM MATERIAL WHERE codigo = ?;";

    public static Material obtenerporID(int codigo) throws SQLException {
        Material mat = null;
        try (Connection conn = DBUtils.getConexion();
             PreparedStatement ps = conn.prepareStatement(OBTENER_POR_ID)) {

            ps.setInt(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String denominacion = rs.getString("denominacion");
                    mat = new Material(codigo, denominacion);
                }
            }
        }
        return mat;
    }
}
