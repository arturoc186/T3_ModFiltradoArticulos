module com.iescamp.tiendaropa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens Principal to javafx.fxml;
    exports Principal;
    exports Controladores;
    opens Controladores to javafx.fxml;
    exports DAO;
    opens DAO to javafx.fxml;
    exports POJOS;
    opens POJOS to javafx.fxml;
}