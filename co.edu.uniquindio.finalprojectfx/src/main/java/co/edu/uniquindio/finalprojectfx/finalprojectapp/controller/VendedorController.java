package co.edu.uniquindio.finalprojectfx.finalprojectapp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.Vendedor;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class VendedorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtDireccion;

    @FXML
    private Button btnResgitrarVendedor;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtUsuario;

    @FXML
    void onRegistrarVendedor(ActionEvent event) {
        registrarVendedor();
    }

    @FXML
    void initialize() {
    }

    private void registrarVendedor() {
        Vendedor vendedor
    }
}
