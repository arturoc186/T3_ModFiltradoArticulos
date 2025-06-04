package Controladores;

import DAO.Sesion;
import Principal.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;

public class CatRopaController {

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnInfoUsuario;

    @FXML
    private ImageView imgBtnLogin;

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
