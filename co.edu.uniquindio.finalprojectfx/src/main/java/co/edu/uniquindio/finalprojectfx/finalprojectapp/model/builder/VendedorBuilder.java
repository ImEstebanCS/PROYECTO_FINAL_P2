package co.edu.uniquindio.finalprojectfx.finalprojectapp.model.builder;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.Vendedor;

public class VendedorBuilder {
    private String nombre;
    private String apellidos;
    private String cedula;
    private String direccion;
    private String usuario;
    private String contrasena;

    public VendedorBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public VendedorBuilder apellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public VendedorBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public VendedorBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public VendedorBuilder usuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public VendedorBuilder contrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    public Vendedor build() {
        return new Vendedor(nombre, apellidos, cedula, direccion, usuario, contrasena);
    }
}
