package co.edu.uniquindio.finalprojectfx.finalprojectapp.model;

public class Persona {
    private String nombre;
    private String apellidos;
    private String cedula;
    private String direccion;
    private String usuario;
    private String contrasena;

    public Persona(String nombre, String apellidos, String cedula, String direccion, String usuario, String contrasena) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
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

