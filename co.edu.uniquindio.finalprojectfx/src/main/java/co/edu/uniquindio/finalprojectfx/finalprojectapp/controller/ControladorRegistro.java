package co.edu.uniquindio.finalprojectfx.finalprojectapp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class ControladorRegistro {

    @FXML
    private TextField campoNombre;

    @FXML
    private TextField campoApellido;

    @FXML
    private TextField campoCedula;

    @FXML
    private TextField campoDireccion;

    @FXML
    private TextField campoUsuario;

    @FXML
    private PasswordField campoContrasena;

    @FXML
    private PasswordField campoConfirmarContrasena;

    @FXML
    private void manejarRegistro() {
        // aqui procesos para el registro
        System.out.println("Intento de registro para: " + campoUsuario.getText());
    }

    @FXML
    private void volverAInicioSesion() {
        // aqui el proceso para iniciar la sesion
        System.out.println("Volviendo a la pantalla de inicio de sesión");
    }
}