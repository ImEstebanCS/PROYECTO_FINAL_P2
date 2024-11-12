package co.edu.uniquindio.finalprojectfx.finalprojectapp.service;

public interface IAdministradorCrud {
    boolean crearAdministrador (String nombre, String apellidos, String cedula, String direccion, String usuario, String contrasena);
    boolean actualizarAdministrador (String nombre, String apellidos, String cedula, String direccion, String usuario, String contrasena);
    boolean eliminarAdministrador  (String cedula);

}
