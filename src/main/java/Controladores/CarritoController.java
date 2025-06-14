package Controladores;

import DAO.LineaPedidoDAO;
import DAO.PedidoDAO;
import DAO.Sesion;
import POJOS.*;
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
import java.time.LocalDate;

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

    @FXML private Button btnVolver;

    @FXML
    void btnVolverClick(ActionEvent event) throws IOException{
        Main.setRoot("main");
    }


    @FXML private Label labelNombre;
    @FXML private Label labelDNI;
    @FXML private Label labelNArticulos;
    @FXML private Label labelTotal;

    float total = 0f;

    @FXML
    public void initialize() {
        carritoObservable = FXCollections.observableArrayList(Articulo.carrito);

        colCodArt.setCellValueFactory(new PropertyValueFactory<>("codArt"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));

        tableCarrito.setItems(carritoObservable);

        labelNombre.setText(cliente.getNombre() + " "+ cliente.getApellidos());
        labelDNI.setText("ESP - " + cliente.getDni());
        labelNArticulos.setText("Tienes " + Articulo.carrito.size() + " artículos");

        refrescarTotal();
    }


    public void refrescarTotal() {
        float nuevoTotal = 0f;
        for (Articulo art : carritoObservable) {nuevoTotal += art.getPrecio();}
        labelTotal.setText(String.format("%.2f €", nuevoTotal));
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

                refrescarTotal();
            }
        } else {
            Main.crearAlerta("Error", "Selección requerida", "Por favor selecciona un artículo.");
        }
    }

    @FXML private ComboBox cbMetodoPago;

    @FXML
    void btnComprarClick(ActionEvent event) throws IOException {
        if (Articulo.carrito.isEmpty()) {
            Main.crearAlerta("Carrito vacío", "No hay artículos para comprar", "");
            return;
        }

        Cliente cliente = Sesion.getClienteActual();
        if (cliente == null) {
            Main.crearAlerta("Sesión", "Debes iniciar sesión para comprar", "");
            return;
        }

        int metodo_pago = (int) cbMetodoPago.getValue();
        MetodoPago mp = new MetodoPago(metodo_pago, null);

        Pedido pedido = new Pedido();
        pedido.setFecha(LocalDate.now());
        pedido.setDirEnvio(cliente.getDireccion());
        pedido.setEstado("En proceso");
        pedido.setMetodoPago(mp);
        pedido.setCliente(cliente.getDni().trim());

        System.out.println("Pedido.getCliente(): [" + pedido.getCliente() + "]");

        try {
            PedidoDAO pedidoDAO = new PedidoDAO();
            int numeroPedido = pedidoDAO.insertarPedido(pedido);

            if (numeroPedido > 0) {
                LineaPedidoDAO lpDAO = new LineaPedidoDAO();

                int cantidad = 1;

                for (Articulo articulo : Articulo.carrito) {
                    LineaPedido linea = new LineaPedido(cantidad, articulo);
                    lpDAO.insertarLineaPedido(articulo.getCodArt(), numeroPedido);
                }

                Main.crearAlerta("¡Pedido realizado!", "Tu pedido #" + numeroPedido + " ha sido procesado.", "");
                Articulo.carrito.clear();
                Main.setRoot("main");
            } else {
                Main.crearAlerta("Error", "No se pudo registrar el pedido", "");
            }

        } catch (Exception e) {
            e.printStackTrace();
            Main.crearAlerta("Error", "Fallo al guardar el pedido", e.getMessage());
        }
    }



}
