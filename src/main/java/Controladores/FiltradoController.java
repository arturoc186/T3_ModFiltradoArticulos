package Controladores;

import DAO.ArticuloDAO;
import POJOS.Articulo;
import Principal.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.lang.annotation.Repeatable;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FiltradoController implements Initializable {

    String SQL = "SELECT a.cod_art, a.nombre, a.precio\n" +
            "FROM ARTICULO a\n" +
            "LEFT JOIN ROPA r ON a.cod_art = r.cod_art\n" +
            "LEFT JOIN ACCESORIO acc ON a.cod_art = acc.cod_art\n" +
            "WHERE 1=1";

    @FXML private CheckBox chkTipo;
    @FXML private ComboBox comboTipo;
    @FXML private CheckBox chkPrecio;
    @FXML private TextField txtMinPrecio;
    @FXML private TextField txtMaxPrecio;
    @FXML private CheckBox chkMaterial;
    @FXML private ComboBox comboMaterial;
    @FXML private Button btnBuscar;

    @FXML private TableView<Articulo> tablaResultados;
    @FXML private TableColumn<Articulo, Integer> colCodigo;
    @FXML private TableColumn<Articulo, String> colNombre;
    @FXML private TableColumn<Articulo, Float> colPrecio;


    @FXML
    private void btnBuscarClick(ActionEvent event) {
        String sql = "SELECT a.cod_art, a.nombre, a.precio FROM ARTICULO a LEFT JOIN ROPA r ON a.cod_art = r.cod_art LEFT JOIN ACCESORIO acc ON a.cod_art = acc.cod_art LEFT JOIN MATERIAL m ON a.material = m.codigo WHERE 1=1";

        if (chkTipo.isSelected()) {
            String tipo = (String) comboTipo.getValue();
            if (tipo == null) {
                Main.crearAlerta("Selecciona un tipo.", "", "");
                return;
            }
            sql += " AND (r.tipo_ropa = '" + tipo + "' OR acc.tipo_accesorio = '" + tipo + "')";
        }

        if (chkPrecio.isSelected()) {
            try {
                float min = Float.parseFloat(txtMinPrecio.getText());
                float max = Float.parseFloat(txtMaxPrecio.getText());
                sql += " AND a.precio BETWEEN " + min + " AND " + max;
            } catch (NumberFormatException e) {
                Main.crearAlerta("Introduce precios válidos.", "", "");
                return;
            }
        }

        if (chkMaterial.isSelected()) {
            String mat = (String) comboMaterial.getValue();
            if (mat == null) {
                Main.crearAlerta("Selecciona un material.", "", "");
                return;
            }
            sql += " AND m.denominacion = '" + mat + "'";
        }

        List<Articulo> resultados = ArticuloDAO.buscarFiltrados(sql);
        ObservableList<Articulo> obsResultados = FXCollections.observableArrayList(resultados);

        if (obsResultados.isEmpty()) {
            Main.crearAlerta("No se han encontrado artículos con esos criterios.", "", "");
        } else {
            tablaResultados.setItems(obsResultados);
        }
    }



    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboTipo.getItems().addAll("Camisa", "Pantalón", "Chaqueta", "Zapatos", "Bolso");
        comboMaterial.getItems().addAll("Algodón", "Cuero", "Lana", "Poliéster");

        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codArt"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
    }


    public void menuLoginClick(ActionEvent event) throws IOException {
        Main.setRoot("login");
    }

    public void menuRopaClick(ActionEvent event) throws IOException {
        Main.setRoot("catalogo");
    }

    public void menuRegistroClick(ActionEvent event) throws IOException {
        Main.setRoot("registrar");
    }

    public void menuAccClick(ActionEvent event) throws IOException {
        Main.setRoot("catalogoaccesorio");
    }

    public void menuHistorialClick(ActionEvent event) throws IOException {
        Main.setRoot("historial");
    }

    public void btnInfoUsuarioClick(ActionEvent event) throws IOException {
        Main.setRoot("informacion");
    }
}
