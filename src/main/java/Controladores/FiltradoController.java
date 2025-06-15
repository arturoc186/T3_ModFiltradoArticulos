package Controladores;

import DAO.ArticuloDAO;
import POJOS.Articulo;
import Principal.Main;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FiltradoController implements Initializable {

    String SQL = "SELECT a.*, r.talla_ropa, r.tipo_cierre, r.impermeable, r.tipo_manga, r.estampada, r.tipo_pantalon, r.tiene_bolsillos, r.tipo_ropa, ac.estilo, ac.personalizado, ac.tipo_cierre_bolso, ac.capacidad, ac.tipo_suela, ac.talla_zapato, ac.tipo_accesorio  FROM ARTICULO a " +
            "LEFT JOIN ROPA r ON a.cod_art=r.cod_art " +
            "LEFT JOIN ACCESORIO ac ON a.cod_art=ac.cod_art " +
            "JOIN MATERIAL m ON a.material=m.codigo " +
            "WHERE 1=1";

    @FXML private CheckBox chkTipo;
    @FXML private ComboBox comboTipo;
    @FXML private CheckBox chkPrecio;
    @FXML private TextField txtMinPrecio;
    @FXML private TextField txtMaxPrecio;
    @FXML private CheckBox chkMaterial;
    @FXML private ComboBox comboMaterial;

    @FXML private TableView<Articulo> tablaResultados;
    @FXML private TableColumn<Articulo, Integer> colCodigo;
    @FXML private TableColumn<Articulo, String> colNombre;
    @FXML private TableColumn<Articulo, Float> colPrecio;


    @FXML
    private void buscarArticulos() {
        StringBuilder sql = new StringBuilder("SELECT * FROM articulo WHERE 1=1");

        if (chkTipo.isSelected()) {
            String tipo = comboTipo.getValue().toString();
            if (tipo == null) {
                Main.crearAlerta("Selecciona un tipo.","","");
                return;
            }
            sql.append(" AND tipo = '").append(tipo).append("'");
        }

        if (chkPrecio.isSelected()) {
            try {
                float min = Float.parseFloat(txtMinPrecio.getText());
                float max = Float.parseFloat(txtMaxPrecio.getText());
                sql.append(" AND precio BETWEEN ").append(min).append(" AND ").append(max);
            } catch (NumberFormatException e) {
                Main.crearAlerta("Introduce precios válidos.","","");
                return;
            }
        }

        if (chkMaterial.isSelected()) {
            String material = comboMaterial.getValue().toString();
            if (material == null) {
                Main.crearAlerta("Selecciona un material.","","");
                return;
            }
            sql.append(" AND material = '").append(material).append("'");
        }

        List<Articulo> resultados = ArticuloDAO.buscarFiltrados(sql.toString());

        if (resultados.isEmpty()) {
            Main.crearAlerta("No se han encontrado artículos con esos criterios.","","");
        } else {
            tablaResultados.setItems(FXCollections.observableArrayList(resultados));
        }
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboTipo.getItems().addAll("Camisa", "Pantalón", "Chaqueta", "Zapatos", "Bolso");
        comboMaterial.getItems().addAll("Algodón", "Cuero", "Lana", "Poliéster");

        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
    }
}
