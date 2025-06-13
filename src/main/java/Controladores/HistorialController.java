package Controladores;

import DAO.LineaPedidoDAO;
import DAO.PedidoDAO;
import DAO.Sesion;
import POJOS.Cliente;
import POJOS.LineaPedido;
import POJOS.Pedido;
import Principal.Main;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

    public class HistorialController {

        @FXML private TableView<Pedido> tablaPedidos;
        @FXML private TableColumn<Pedido, Integer> colNumero;
        @FXML private TableColumn<Pedido, LocalDate> colFecha;
        @FXML private TableColumn<Pedido, String> colEstado;
        @FXML private TableColumn<Pedido, Float> colTotal;

        @FXML private TableView<LineaPedido> tablaLineas;
        @FXML private TableColumn<LineaPedido, String> colArticulo;
    @FXML private TableColumn<LineaPedido, Float> colPrecio;

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
    public void initialize() {
        Cliente cliente = Sesion.getClienteActual();
        menuHistorial.setDisable(true);

        if (cliente == null) return;

        colNumero.setCellValueFactory(p -> new SimpleStringProperty(String.valueOf(p.getValue().getNumero())).length().asObject());
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colTotal.setCellValueFactory(p -> new SimpleFloatProperty(p.getValue().calcularTotal()).asObject());

        colArticulo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getArticulo().getNombre()));
        colPrecio.setCellValueFactory(data -> new SimpleFloatProperty(data.getValue().getArticulo().getPrecio()).asObject());

        tablaPedidos.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                try {
                    List<LineaPedido> lineas = LineaPedidoDAO.obtenerLineasPorPedido(newVal.getNumero());
                    tablaLineas.setItems(FXCollections.observableArrayList(lineas));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            List<Pedido> pedidos = PedidoDAO.obtenerPedidosPorCliente(cliente.getDni());
            tablaPedidos.setItems(FXCollections.observableArrayList(pedidos));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnVolverClick() throws IOException {
        Main.setRoot("main");
    }


    @FXML
    void btnAccesorioClick(ActionEvent event) throws IOException {
        Main.setRoot("catalogoaccesorio");
    }

    @FXML
    void btnRopaClick(ActionEvent event) throws IOException {
        Main.setRoot("catalogoropa");
    }

    @FXML
    void menuAccClick(ActionEvent event) throws IOException {
        Main.setRoot("catalogoaccesorio");
    }

    @FXML
    void menuRopaClick(ActionEvent event) throws IOException {
        Main.setRoot("catalogoropa");
    }

    @FXML
    void btnCarritoClick(ActionEvent event) throws IOException{
        if (Sesion.getClienteActual() == null){
            System.out.println("Un cliente sin cuenta ha intentado entrar al carrito.");
            Main.crearAlerta("Error","Tenemos un error con tu sesión","Por favor, inicia sesión en tu cuenta o regístrate para entrar aquí.");
            Main.setRoot("main");
        } else {
            Main.setRoot("carrito");
        }
    }

    @FXML
    void menuLoginClick(ActionEvent event) throws IOException {
        Main.setRoot("login");
    }

    @FXML
    void menuRegistroClick(ActionEvent event) throws IOException{
        Main.setRoot("registrar");
    }

    public void btnInfoUsuarioClick(ActionEvent event) throws IOException {

        if (Sesion.getClienteActual() == null){
            System.out.println("Un cliente sin cuenta ha intentado entrar a infoCliente.");
            Main.crearAlerta("Error","Tenemos un error con tu sesión","Por favor, inicia sesión en tu cuenta o regístrate para entrar aquí.");
            Main.setRoot("main");
        } else {
            Main.setRoot("informacion");
        }
    }
}
