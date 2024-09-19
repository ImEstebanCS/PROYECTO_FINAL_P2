package co.edu.uniquindio.finalprojectfx.finalprojectapp.services;

public interface IVendedorCrud {
    boolean crearVendedor(String nombre, String apellido, String cedula, String direccion, String usuario, String contrasena);
    boolean actualizarVendedor(String nombre, String cedula, String idNuevo);
    boolean obtenerVendedor();
    boolean eliminarVendedor(String nombre, String cedula);

}
