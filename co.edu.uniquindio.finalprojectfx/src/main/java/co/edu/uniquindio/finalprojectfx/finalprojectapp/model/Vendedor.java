package co.edu.uniquindio.finalprojectfx.finalprojectapp.model;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.builder.VendedorBuilder;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Usuario{
    private List<Vendedor> vendedores = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();

    public Vendedor (String nombre, String apellidos, String cedula, String direccion, String usuario, String contrasena) {
        super(nombre, apellidos, cedula, direccion, usuario, contrasena);
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public static VendedorBuilder builder() {
        return new VendedorBuilder();
    }
}
