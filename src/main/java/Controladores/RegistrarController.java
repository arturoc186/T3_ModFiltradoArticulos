package Controladores;

import DAO.ClienteDAO;
import DAO.Sesion;
import POJOS.Cliente;
import Principal.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RegistrarController implements Initializable {

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnRegistrar;

    @FXML private CheckBox checkTarjeta;
    @FXML private DatePicker dateNacimiento;
    @FXML private TextField fieldApellidos;
    @FXML private TextField fieldContrasena;
    @FXML private TextField fieldCorreo;
    @FXML private TextField fieldDNI;
    @FXML private TextField fieldDireccion;
    @FXML private TextField fieldNombre;
    @FXML private TextField fieldTelefono;
    @FXML private ImageView imgBtnLogin;
    @FXML private ImageView imgBtnRopa;
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
    void btnRegistrarClick(ActionEvent event) throws IOException {
        String dni       = fieldDNI.getText().trim();
        String nombre    = fieldNombre.getText().trim();
        String apellidos = fieldApellidos.getText().trim();
        String telefono     = fieldTelefono.getText();

        LocalDate ld     = dateNacimiento.getValue();
        Date fNacimiento = Date.valueOf(ld);

        String direccion = fieldDireccion.getText().trim();
        String email     = fieldCorreo.getText().trim();
        String pass      = fieldContrasena.getText();
        boolean fideliz  = checkTarjeta.isSelected();

        Cliente cliente = new Cliente(dni, nombre, apellidos, telefono, fNacimiento, direccion, email, true, pass, 0.0f, 0, "", fideliz, 2);

        ClienteDAO dao = new ClienteDAO();
        dao.registrar(cliente);

        System.out.println("El cliente " + nombre + " " + apellidos + " se ha registrado con éxito.");
        Main.setRoot("main");
    }

    @FXML
    void menuLoginClick(ActionEvent event) throws IOException {
        Main.setRoot("login");
    }

    @FXML
    void menuRegistroClick(ActionEvent event) throws IOException {
        Main.setRoot("main");
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

    @FXML  private Button btnCarrito;
    @FXML void btnCarritoClick(ActionEvent event) throws IOException{Main.setRoot("carrito");}


    @FXML
    void menuRopaClick(ActionEvent event) throws IOException {
        Main.setRoot("catalogoropa");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menureg.setDisable(true);
    }
}
