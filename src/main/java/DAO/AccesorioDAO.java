package DAO;

import POJOS.Accesorio;
import POJOS.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccesorioDAO {
    private static final String SQL_SELECT_ACCESORIO = "SELECT a.cod_art, a.nombre, a.precio, a.marca, a.descripcion, a.activo, a.imagen, a.color, a.material, acc.estilo, acc.personalizado FROM ARTICULO a JOIN ACCESORIO acc ON a.cod_art = acc.cod_art";

    public List<Accesorio> obtenerTodos() throws SQLException {
        List<Accesorio> lista = new ArrayList<>();

        try (Connection conn = DBUtils.getConexion();
             PreparedStatement ps = conn.prepareStatement(SQL_SELECT_ACCESORIO);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int codArt       = rs.getInt("cod_art");
                String nombre    = rs.getString("nombre");
                float precio     = rs.getFloat("precio");
                String marca     = rs.getString("marca");
                String desc      = rs.getString("descripcion");
                boolean activo   = rs.getBoolean("activo");
                String imagen    = rs.getString("imagen");
                String color     = rs.getString("color");

                int matId        = rs.getInt("material");
                Material material = MaterialDAO.obtenerporID(matId);

                String estilo    = rs.getString("estilo");
                boolean pers     = rs.getBoolean("personalizado");

                Accesorio acc = new Accesorio(
                        codArt, nombre, precio, marca,
                        desc, activo, imagen, color,
                        material, estilo, pers
                ) {};
                lista.add(acc);
            }
        }
        return lista;
    }
}