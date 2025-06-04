package Controladores;

import DAO.ClienteDAO;
import DAO.Sesion;
import POJOS.Cliente;
import Principal.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class InformacionController implements Initializable {

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnVolver;

    @FXML
    private TextField fieldDNI;

    @FXML
    private TextField fieldDireccion;

    @FXML
    private TextField fieldDireccionEnvio;

    @FXML
    private TextField fieldEmail;

    @FXML
    private TextField fieldFechaNacimiento;

    @FXML
    private TextField fieldTarjetaFidelizacion;

    @FXML
    private TextField fieldTelefono;

    @FXML
    private ImageView imgBtnLogin;

    @FXML
    private ImageView imgBtnRopa;

    @FXML
    private ImageView imgBtnSettings;

    @FXML
    private ImageView imgCarrito;

    @FXML
    private MenuItem menuacc;

    @FXML
    private MenuItem menulogin;

    @FXML
    private MenuItem menureg;

    @FXML
    private MenuItem menuropa;

    @FXML
    private TextField fieldPedidos;

    @FXML
    private Text textBienvenida;

    @FXML
    private Text textSaldo;

    /*"UPDATE CLIENTE SET telefono = ?, f_nacimiento = ? direccion = ?, email = ?, dir_envio= ? WHERE DNI = ?"*/
    @FXML
    void btnActualizarClick(ActionEvent event) throws SQLException {
        Cliente cliente = Sesion.getClienteActual();

        String telefono = fieldTelefono.getText();
        String fNacimiento = fieldFechaNacimiento.getText();
        String direccion = fieldDireccion.getText();
        String email = fieldDireccion.getText();
        String dir_envio = fieldDireccionEnvio.getText();

        cliente.setTelefono(telefono);
        cliente.setfNacimiento(Date.valueOf(fNacimiento));
        cliente.setDireccion(direccion);
        cliente.setEmail(email);
        cliente.setDir_envio(dir_envio);

        ClienteDAO dao = new ClienteDAO();
        dao.update(cliente);
        System.out.println("Información actualizada con éxito.");
    }

    @FXML
    void btnVolverClick(ActionEvent event) throws IOException {
        Main.setRoot("main");

    }

    @FXML
    void menuLoginClick(ActionEvent event) throws IOException {
        Main.setRoot("login");

    }

    @FXML
    void menuRegistroClick(ActionEvent event) throws IOException {
        Main.setRoot("registrar");
    }


    @FXML private Button btnInfoUsuario;

    @FXML
    void btnInfoUsuarioClick(ActionEvent event) throws IOException{
        Main.setRoot("main");
    }

    Cliente cliente = Sesion.getClienteActual();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fieldDNI.setText(cliente.getDni());
        fieldFechaNacimiento.setText(String.valueOf(cliente.getfNacimiento()));
        fieldEmail.setText(cliente.getEmail());
        fieldDireccionEnvio.setText(cliente.getDir_envio());
        fieldPedidos.setText(String.valueOf(cliente.getNum_pedidos()));
        fieldTelefono.setText(cliente.getTelefono());
        fieldTarjetaFidelizacion.setText(String.valueOf(cliente.isTarjeta_fidelizacion()));
    }
}

