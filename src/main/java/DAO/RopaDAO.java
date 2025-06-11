package DAO;

import POJOS.Material;
import POJOS.Ropa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RopaDAO {
    private static final String SQL_SELECT_ALL = "SELECT a.cod_art, a.nombre, a.precio, a.marca, a.descripcion, a.activo, a.imagen, a.color, a.material, r.talla_ropa, r.tipo_cierre FROM ARTICULO a JOIN ROPA r ON a.cod_art = r.cod_art JOIN MATERIAL m ON a.material = m.codigo";

    public List<Ropa> obtenerTodos() throws SQLException {
        List<Ropa> lista = new ArrayList<>();

        try (Connection conn = DBUtils.getConexion();
             PreparedStatement ps = conn.prepareStatement(SQL_SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int codArt     = rs.getInt("cod_art");
                String nombre  = rs.getString("nombre");
                float precio   = rs.getFloat("precio");
                String marca   = rs.getString("marca");
                String desc    = rs.getString("descripcion");
                boolean activo = rs.getBoolean("activo");
                String imagen  = rs.getString("imagen");
                String color   = rs.getString("color");

                int matId        = rs.getInt("material");
                Material material = MaterialDAO.obtenerporID(matId);

                String talla       = rs.getString("talla_ropa");
                String cierre      = rs.getString("tipo_cierre");

                Ropa ropa = new Ropa(codArt, nombre, precio, marca, desc, activo, imagen, color, material, talla, cierre);
                lista.add(ropa);
            }
        }
        return lista;
    }
}
