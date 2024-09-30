package co.edu.uniquindio.finalprojectfx.finalprojectapp.model;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.builder.AdministradorBuilder;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.builder.VendedorBuilder;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Persona {
    private List<Vendedor> listaVendedores = new ArrayList<>();

    public Administrador(String nombre, String apellidos, String cedula, String direccion, String usuario, String contrasena) {
        super (nombre,apellidos,cedula,direccion,usuario,contrasena);
    }


    public static AdministradorBuilder builder() {
        return new AdministradorBuilder();
    }
}
