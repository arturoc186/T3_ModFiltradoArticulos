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

public class MainController {

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private ImageView imgBtnAccesorios;

    @FXML
    private ImageView imgBtnLogin;

    @FXML
    private ImageView imgBtnRopa;

    @FXML
    private ImageView imgBtnSettings;

    @FXML
    private ImageView imgCarrito;

    @FXML
    private MenuItem menuLogin;

    @FXML
    private MenuItem menuRegistro;

    @FXML
    private MenuItem menuropa;

    @FXML
    private Text textBienvenida;

    @FXML
    private Text textSaldo;

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
