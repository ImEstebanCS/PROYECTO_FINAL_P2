package co.edu.uniquindio.finalprojectfx.finalprojectapp.model;

public class Usuario {
    private String nombre;
    private String apellido;
    private String  cedula;
    private String direccion;
    private String usuario;
    private String contrasena;

    public Usuario(String nombre, String apellido, String cedula
            , String direccion, String usuario
            , String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contrasena=contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }
}
