package co.edu.uniquindio.finalprojectfx.finalprojectapp.model.builder;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.Vendedor;

public class VendedorBuilder {
    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected String direccion;
    protected String usuario;
    protected String contrasena;
    public VendedorBuilder() {}
    public VendedorBuilder nombre(String nombre) {
        this.nombre = nombre;
        return  this;
    }
    public VendedorBuilder apellido(String apellido) {
        this.apellido = apellido;
        return  this;
    }
    public VendedorBuilder cedula(String cedula) {
        this.cedula = cedula;
        return  this;
    }
    public VendedorBuilder direccion(String direccion) {
        this.direccion = direccion;
        return  this;
    }
    public VendedorBuilder usuario(String usuario) {
        this.usuario = usuario;
        return  this;
    }
    public VendedorBuilder contrasena(String contrasena) {
        this.contrasena = contrasena;
        return  this;
    }
    public Vendedor build() {return new Vendedor(nombre, apellido, cedula
            , direccion, usuario, contrasena);}

}
