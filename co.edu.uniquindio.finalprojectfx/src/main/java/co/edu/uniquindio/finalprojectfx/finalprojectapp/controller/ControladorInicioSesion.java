package co.edu.uniquindio.finalprojectfx.finalprojectapp.controller;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class ControladorInicioSesion {

    @FXML
    private TextField campoUsuario;

    @FXML
    private PasswordField campoContrasena;

    @FXML
    private void manejarInicioSesion() {
        String usuario = campoUsuario.getText();
        String contrasena = campoContrasena.getText();
        // TODO: Implementar lógica de inicio de sesión
        System.out.println("Intento de inicio de sesión: " + usuario);
    }

    @FXML
    private void irARegistro() {
        // TODO: Implementar navegación a la pantalla de registro
        System.out.println("Navegando a la pantalla de registro");
    }
}
