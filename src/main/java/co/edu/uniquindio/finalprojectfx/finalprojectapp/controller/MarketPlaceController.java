package co.edu.uniquindio.finalprojectfx.finalprojectapp.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class MarketPlaceController {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private TextField txtUserName;
    @FXML private ImageView imagePass;
    @FXML private Button btIngresar;
    @FXML private Hyperlink forgotPas;
    @FXML private ImageView imageUser;
    @FXML private ImageView btExit;
    @FXML private PasswordField txtPassword;

    @FXML
    void handleIngresar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/finalprojectfx/finalprojectapp/administrador.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) btIngresar.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Interfaz de Administrador");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handle9582ff(ActionEvent event) {
        // TODO: Implementar lógica
    }

    @FXML
    void f5f5f5(ActionEvent event) {
        // TODO: Implementar lógica
    }

    @FXML
    void handle6228f5(ActionEvent event) {
        // TODO: Implementar lógica
    }

    @FXML
    void initialize() {
        assert txtUserName != null : "fx:id=\"txtUserName\" was not injected: check your FXML file 'marketPlace.fxml'.";
        assert imagePass != null : "fx:id=\"imagePass\" was not injected: check your FXML file 'marketPlace.fxml'.";
        assert btIngresar != null : "fx:id=\"btIngresar\" was not injected: check your FXML file 'marketPlace.fxml'.";
        assert forgotPas != null : "fx:id=\"forgotPas\" was not injected: check your FXML file 'marketPlace.fxml'.";
        assert imageUser != null : "fx:id=\"imageUser\" was not injected: check your FXML file 'marketPlace.fxml'.";
        assert btExit != null : "fx:id=\"btExit\" was not injected: check your FXML file 'marketPlace.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'marketPlace.fxml'.";

    }
}

