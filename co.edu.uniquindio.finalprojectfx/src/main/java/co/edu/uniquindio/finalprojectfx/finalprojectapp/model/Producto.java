package co.edu.uniquindio.finalprojectfx.finalprojectapp.model;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.builder.ProductoBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String nombre;
    private String imagen;
    private String categoria;
    private double precio;
    private String estadoProducto;
    private LocalDate fechaPublicacion;

    private List<Comentarios> comentarios = new ArrayList<>();

    public Producto(String nombre,
                    String imagen,
                    String categoria,
                    double precio,
                    String estadoProducto,
                    LocalDate fechaPublicacion) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.categoria = categoria;
        this.precio = precio;
        this.estadoProducto = estadoProducto;
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public List<Comentarios> getComentarios() {
        return comentarios;
    }

    public static ProductoBuilder builder() {
        return new ProductoBuilder();
    }
}