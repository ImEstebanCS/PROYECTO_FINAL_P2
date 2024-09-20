package co.edu.uniquindio.finalprojectfx.finalprojectapp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;

public class ControladorPanelPrincipal {

    @FXML
    private Label etiquetaNombreUsuario;

    @FXML
    private TabPane panelPestanasVendedores;

    public void initialize() {
        // poner los atos el usuario y mostrar
    }

    @FXML
    private void manejarCierreSesion() {
        // se ava la sesion
        System.out.println("Cerrando sesión");
    }

    // Método para añadir pestañas de vendedores dinámicamente
    public void anadirPestanaVendedor(String nombreVendedor) {
        // Segun yo esto lo necesitariamos
    }
}