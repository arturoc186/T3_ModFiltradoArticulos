package DAO;

import POJOS.Material;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {

    private static final String OBTENER_POR_ID = "SELECT codigo, denominacion FROM MATERIAL WHERE codigo = ?;";
    private static final String OBTENER_TODOS = "SELECT codigo, denominacion FROM MATERIAL;";


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

    public List<Material> obtenerTodos() throws SQLException {
        List<Material> lista = new ArrayList<>();

        try (Connection conn = DBUtils.getConexion();
             PreparedStatement ps = conn.prepareStatement(OBTENER_TODOS);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int codigo        = rs.getInt("codigo");
                String denom      = rs.getString("denominacion");
                lista.add(new Material(codigo, denom));
            }
        }

        return lista;
    }
}
