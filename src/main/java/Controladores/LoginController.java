package Controladores;

import DAO.ClienteDAO;
import DAO.Sesion;
import POJOS.Cliente;
import Principal.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private TextField fieldContrasena;

    @FXML
    private TextField fieldCorreo;

    @FXML
    private Hyperlink hyperlinkOlvidar;

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
    private Text textBienvenida;

    @FXML
    private Text textSaldo;

    @FXML
    void btnIniciarSesionClick(ActionEvent event) throws IOException {
        String email    = fieldCorreo.getText();
        String password = fieldContrasena.getText();

        Cliente cliente = new Cliente(email, password);
        cliente.setEmail(email);
        cliente.setPass(password);

        ClienteDAO dao = new ClienteDAO();
        Sesion.setClienteActual(cliente);
        dao.login(cliente);

        System.out.println("El login se ha realizado correctamente.");
        Main.setRoot("main");
    }

    @FXML
    void hyperlinkOlvidarClick(ActionEvent event) {

    }

    @FXML
    void menuLoginClick(ActionEvent event) throws IOException {
        Main.setRoot("main");
    }

    @FXML
    void menuRegistroClick(ActionEvent event) throws IOException {
        Main.setRoot("registrar");

    }

    @FXML private Button btnInfoUsuario;

    @FXML
    public void btnInfoUsuarioClick(ActionEvent event) throws IOException {

        if (Sesion.getClienteActual() == null){
            System.out.println("Un cliente sin cuenta ha intentado entrar a infoCliente.");
            Main.crearAlerta("Error","Tenemos un error con tu sesión","Por favor, inicia sesión en tu cuenta o regístrate para entrar aquí.");
            Main.setRoot("main");
        } else {
            Main.setRoot("informacion");
        }
    }

    @FXML
    void menuAccClick(ActionEvent event) throws IOException {
        Main.setRoot("catalogoaccesorio");
    }

    @FXML
    void menuRopaClick(ActionEvent event) throws IOException {
        Main.setRoot("catalogoropa");
    }

}
