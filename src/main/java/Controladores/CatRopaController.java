package Controladores;

import DAO.RopaDAO;
import DAO.Sesion;
import POJOS.Articulo;
import POJOS.Ropa;
import Principal.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CatRopaController {

    @FXML private Button btnCerrarSesion;
    @FXML private Button btnInfoUsuario;
    @FXML private ImageView imgBtnLogin;
    @FXML private ImageView imgBtnSettings;
    @FXML private ImageView imgCarrito;
    @FXML private MenuItem menuacc;
    @FXML private MenuItem menulogin;
    @FXML private MenuItem menureg;
    @FXML private MenuItem menuropa;
    @FXML private Text textBienvenida;
    @FXML private Text textSaldo;

    @FXML
    private MenuItem menuHistorial;

    @FXML
    void menuHistorialClick(ActionEvent event) throws IOException{
        if (Sesion.getClienteActual() == null){
            System.out.println("Un cliente sin cuenta ha intentado entrar al Historial.");
            Main.crearAlerta("Error","Tenemos un error con tu sesión","Por favor, inicia sesión en tu cuenta o regístrate para entrar aquí.");
            Main.setRoot("main");
        } else {
            Main.setRoot("historial");
        }
    }


    @FXML private TableView<Ropa> tableRopa;
    @FXML private TableColumn<Ropa, Integer> colCodArt;
    @FXML private TableColumn<Ropa, String> colNombre;
    @FXML private TableColumn<Ropa, Float> colPrecio;
    @FXML private TableColumn<Ropa, String> colMarca;
    @FXML private TableColumn<Ropa, String> colDescripcion;
    @FXML private TableColumn<Ropa, Boolean> colActivo;
    @FXML private TableColumn<Ropa, String> colImagen;
    @FXML private TableColumn<Ropa, String> colColor;
    @FXML private TableColumn<Ropa, ?> colMaterial;
    @FXML private TableColumn<Ropa, String> colTalla;
    @FXML private TableColumn<Ropa, String> colCierre;

    private RopaDAO ropaDAO = new RopaDAO();

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
        colMaterial.setCellValueFactory(new PropertyValueFactory<>("material"));
        colTalla.setCellValueFactory(new PropertyValueFactory<>("tallaRopa"));
        colCierre.setCellValueFactory(new PropertyValueFactory<>("tipoCierre"));

        try {
            List<Ropa> lista = ropaDAO.obtenerTodos();
            ObservableList<Ropa> obs = FXCollections.observableArrayList(lista);
            tableRopa.setItems(obs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        menuropa.setDisable(true);

    }

    @FXML
    void btnAnadirClick(ActionEvent event) {
        Articulo seleccionado = tableRopa.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            if (!Articulo.carrito.contains(seleccionado)) {
                Articulo.carrito.add(seleccionado);
                System.out.println("Añadido al carrito: " + seleccionado.getNombre());
            } else {
                Main.crearAlerta("Aviso", "Ya en el carrito", "Este artículo ya está añadido.");
            }
        } else {
            Main.crearAlerta("Error", "Selección requerida", "Por favor selecciona un artículo.");
        }
    }

    @FXML  private Button btnCarrito;
    @FXML void btnCarritoClick(ActionEvent event) throws IOException{
        if (Sesion.getClienteActual() == null){
            System.out.println("Un cliente sin cuenta ha intentado entrar al carrito.");
            Main.crearAlerta("Error","Tenemos un error con tu sesión","Por favor, inicia sesión en tu cuenta o regístrate para entrar aquí.");
            Main.setRoot("main");
        } else {
            Main.setRoot("carrito");
        }
    }

    @FXML
    void btnInfoUsuarioClick(ActionEvent event) throws IOException {
        if (Sesion.getClienteActual() == null){
            System.out.println("Un cliente sin cuenta ha intentado entrar a infoCliente.");
            Main.crearAlerta("Error","Tenemos un error con tu sesión","Por favor, inicia sesión en tu cuenta o regístrate para entrar aquí.");
            Main.setRoot("main");
        } else {
            Main.setRoot("informacion");
        }
    }

    @FXML
    void menuLoginClick(ActionEvent event) throws IOException {
        Main.setRoot("login");

    }

    @FXML
    void menuRegistroClick(ActionEvent event) throws IOException {
        Main.setRoot("registrar");
    }

    @FXML
    private Button btnVolver;

    @FXML
    void btnVolverClick(ActionEvent event) throws IOException{
        Main.setRoot("main");
    }

    @FXML
    void menuAccClick(ActionEvent event) throws IOException {
        Main.setRoot("catalogoaccesorio");
    }

    @FXML
    void menuRopaClick(ActionEvent event) throws IOException {
        Main.setRoot("main");
    }

}
