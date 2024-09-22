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
    private EstadoProducto estadoProducto;
    private LocalDate fechaPublicacion;

    private List<Comentario> comentarios = new ArrayList<>();

    public Producto(String nombre,
                    String imagen,
                    String categoria,
                    double precio,
                    EstadoProducto estadoProducto,
                    LocalDate fechaPublicacion) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.categoria = categoria;
        this.precio = precio;
        this.estadoProducto = estadoProducto;
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

    public EstadoProducto getEstadoProducto() {
        return estadoProducto;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public static ProductoBuilder builder() {
        return new ProductoBuilder();
    }
}