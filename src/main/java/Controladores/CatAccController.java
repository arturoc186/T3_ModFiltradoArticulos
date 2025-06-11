package Controladores;

import DAO.AccesorioDAO;
import DAO.Sesion;
import POJOS.Accesorio;
import Principal.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CatAccController {

    @FXML private Button btnCerrarSesion;
    @FXML private Button btnInfoUsuario;
    @FXML private Button btnVolver;
    @FXML private ImageView imgBtnLogin;
    @FXML private ImageView imgBtnSettings;
    @FXML private ImageView imgCarrito;
    @FXML private MenuItem menuacc;
    @FXML private MenuItem menulogin;
    @FXML private MenuItem menureg;
    @FXML private MenuItem menuropa;
    @FXML private Text textBienvenida;
    @FXML private Text textSaldo;

    @FXML private TableView<Accesorio> tableAccesorio;
    @FXML private TableColumn<Accesorio, Integer> colCodArt;
    @FXML private TableColumn<Accesorio, String> colNombre;
    @FXML private TableColumn<Accesorio, Float> colPrecio;
    @FXML private TableColumn<Accesorio, String> colMarca;
    @FXML private TableColumn<Accesorio, String> colDescripcion;
    @FXML private TableColumn<Accesorio, Boolean> colActivo;
    @FXML private TableColumn<Accesorio, String> colImagen;
    @FXML private TableColumn<Accesorio, String> colColor;
    @FXML private TableColumn<Accesorio, String> colMaterial;
    @FXML private TableColumn<Accesorio, String> colEstilo;
    @FXML private TableColumn<Accesorio, Boolean> colEsPersonalizado;

    private final AccesorioDAO accesorioDAO = new AccesorioDAO();

    @FXML
    public void initialize() {
        colCodArt.setCellValueFactory(new PropertyValueFactory<>("codArt"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colActivo.setCellValueFactory(new PropertyValueFactory<>("activo"));
        colImagen.setCellValueFactory(new PropertyValueFactory<>("imagen"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        colMaterial.setCellValueFactory(new PropertyValueFactory<>("materialName"));
        colEstilo.setCellValueFactory(new PropertyValueFactory<>("estilo"));
        colEsPersonalizado.setCellValueFactory(new PropertyValueFactory<>("esPersonalizado"));

        try {
            List<Accesorio> lista = accesorioDAO.obtenerTodos();
            ObservableList<Accesorio> obs = FXCollections.observableArrayList(lista);
            tableAccesorio.setItems(obs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML void btnInfoUsuarioClick(ActionEvent event) throws IOException {
        if (Sesion.getClienteActual() == null) {
            Main.crearAlerta("Error","Error de sesión","Por favor inicia sesión.");
            Main.setRoot("main");
        } else {
            Main.setRoot("informacion");
        }
    }
    @FXML void btnVolverClick(ActionEvent event) throws IOException { Main.setRoot("main"); }
    @FXML void menuLoginClick(ActionEvent event) throws IOException { Main.setRoot("login"); }
    @FXML void menuRegistroClick(ActionEvent event) throws IOException { Main.setRoot("registrar"); }
    @FXML void menuAccClick(ActionEvent event) throws IOException { Main.setRoot("main"); }
    @FXML void menuRopaClick(ActionEvent event) throws IOException { Main.setRoot("catalogoropa"); }
}
