package Principal;

import DAO.DBUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.io.IOException;

import static javafx.scene.control.Alert.AlertType.WARNING;

public class Main extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        DBUtils bbdd = new DBUtils();
        System.out.println("Comprobando conexión a la BD... · [0%]");
        System.out.println("Conexión establecida con Tienda_Ropa... · [100%]");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Principal/main.fxml"));
        Parent root = loader.load();
        scene = new Scene(root);

        primaryStage.setTitle("Ventana Principal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/Principal/" + fxml + ".fxml"));
        return loader.load();
    }

    public static void crearAlerta(String titulo, String encabezado, String contenido) {
        Alert alerta = new Alert(WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(encabezado);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
