package Principal;

import DAO.DBUtils;
import POJOS.Cliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        DBUtils bbdd = new DBUtils();
        System.out.println("Comprobando conexión a la BD... · [0%]");
        bbdd.conecta();
        System.out.println("Conexión establecida con Tienda_Ropa... · [100%]");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Principal/main.fxml"));
        Parent root = loader.load();
        scene = new Scene(root);

        primaryStage.setTitle("Ventana Principal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * Cambia la raíz de la escena estática para navegar entre vistas.
     * @param fxml Nombre del fichero FXML (sin la extensión)
     * @throws IOException devolverá un error si no encuentra el Root.
     */

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/Principal/" + fxml + ".fxml"));
        return loader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
