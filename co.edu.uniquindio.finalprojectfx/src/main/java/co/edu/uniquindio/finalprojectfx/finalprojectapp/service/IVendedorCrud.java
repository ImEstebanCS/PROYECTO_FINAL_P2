package co.edu.uniquindio.finalprojectfx.finalprojectapp.service;

public interface IVendedorCrud {

    boolean crearVendedor (String nombre, String apellidos, String cedula, String direccion, String usuario, String contrasena);
    boolean actualizarVendedor (String nombre, String apellidos, String cedula, String direccion, String usuario, String contrasena);
    boolean eliminarVendedor (String cedula);
}
