package Controladores;

import DAO.Sesion;
import POJOS.Articulo;
import POJOS.Cliente;
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

public class CarritoController {

    private ObservableList<Articulo> carritoObservable;
    Cliente cliente = Sesion.getClienteActual();

    @FXML private Button btnCerrarSesion;
    @FXML private Button btnInfoUsuario;

    @FXML private TableView<Articulo> tableCarrito;
    @FXML private TableColumn<Articulo, Integer> colCodArt;
    @FXML private TableColumn<Articulo, String> colMarca;
    @FXML private TableColumn<Articulo, String> colNombre;
    @FXML private TableColumn<Articulo, Float> colPrecio;


    @FXML private ImageView imgBtnLogin;
    @FXML private ImageView imgBtnSettings;
    @FXML private ImageView imgCarrito;

    @FXML private MenuItem menuacc;
    @FXML private MenuItem menulogin;
    @FXML private MenuItem menureg;
    @FXML private MenuItem menuropa;



    @FXML
    private Text textBienvenida;

    @FXML
    private Text textSaldo;

    @FXML
    void btnInfoUsuarioClick(ActionEvent event) throws IOException {
        Main.setRoot("informacion");
    }

    @FXML
    void menuAccClick(ActionEvent event) throws IOException {
        Main.setRoot("catalogoaccesorio");
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
    void menuRopaClick(ActionEvent event) throws IOException {
        Main.setRoot("catalogoropa");
    }


    @FXML
    public void initialize() {
        System.out.println("Carrito tiene: " + Articulo.carrito.size() + " artículos.");
        carritoObservable = FXCollections.observableArrayList(Articulo.carrito);

        colCodArt.setCellValueFactory(new PropertyValueFactory<>("codArt"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));

        tableCarrito.setItems(carritoObservable);
    }


    @FXML private Button btnQuitar;

    @FXML
    void btnQuitarClick(ActionEvent event) {
        Articulo seleccionado = tableCarrito.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            if (Articulo.carrito.contains(seleccionado)) {
                Articulo.carrito.remove(seleccionado);
                carritoObservable.remove(seleccionado);
                System.out.println("Se ha eliminado del carrito: " + seleccionado.getNombre());
            }
        } else {
            Main.crearAlerta("Error", "Selección requerida", "Por favor selecciona un artículo.");
        }
    }

}
