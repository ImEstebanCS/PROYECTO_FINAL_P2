package co.edu.uniquindio.finalprojectfx.finalprojectapp.model.builder;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.EstadoProducto;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.Producto;

import java.time.LocalDate;

public class ProductoBuilder {
    private String nombre;
    private String imagen;
    private String categoria;
    private double precio;
    private EstadoProducto estadoProducto;
    private LocalDate fechaPublicacion;

    public ProductoBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoBuilder imagen(String imagen) {
        this.imagen = imagen;
        return this;
    }

    public ProductoBuilder categoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public ProductoBuilder precio(double precio) {
        this.precio = precio;
        return this;
    }

    public ProductoBuilder estadoProducto(EstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
        return this;
    }

    public ProductoBuilder fechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
        return this;
    }

    public Producto build() {
        return new Producto(nombre, imagen, categoria, precio, estadoProducto, fechaPublicacion);
    }
}
