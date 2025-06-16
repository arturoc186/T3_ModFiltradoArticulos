package DAO;

import POJOS.Articulo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAO {

    public static List<Articulo> buscarFiltrados(String sql) {

        List<Articulo> listaFiltrada = new ArrayList<>();
        try (Connection con = DBUtils.getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int codigo = (rs.getInt("cod_art"));
                String nombre = (rs.getString("nombre"));
                float precio = (rs.getFloat("precio"));

                Articulo art = new Articulo(codigo, nombre, precio);

                listaFiltrada.add(art);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaFiltrada;
    }

}
