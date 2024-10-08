package co.edu.uniquindio.finalprojectfx.finalprojectapp.model;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.builder.VendedorBuilder;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona{
    private List<Vendedor> listaAliados = new ArrayList<>();
    private List<Producto> listaProductos = new ArrayList<>();

    public Vendedor(String nombre, String apellidos, String cedula, String direccion, String usuario, String contrasena) {
        super (nombre,apellidos,cedula,direccion,usuario,contrasena);
    }

    public static VendedorBuilder builder() {
        return new VendedorBuilder();
    }
}
