package co.edu.uniquindio.finalprojectfx.finalprojectapp.model.builder;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.Administrador;

public class AdministradorBuilder {
    private String nombre;
    private String apellidos;
    private String cedula;
    private String direccion;
    private String usuario;
    private String contrasena;

    public AdministradorBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public AdministradorBuilder apellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public AdministradorBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public AdministradorBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public AdministradorBuilder usuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public AdministradorBuilder contrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    public Administrador build() {
        return new Administrador(nombre, apellidos, cedula, direccion, usuario, contrasena);
    }
}

