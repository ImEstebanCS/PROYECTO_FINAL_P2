package co.edu.uniquindio.finalprojectfx.finalprojectapp.service;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.EstadoProducto;

import java.time.LocalDate;

public interface IProductoCrud {
    boolean crearProducto (String nombre, String imagen, String categoria, double precio, EstadoProducto estadoProducto, LocalDate fechaPublicacion);
    boolean actulizarProducto (String nombre, double precio, EstadoProducto estadoProducto);
    boolean eliminarProducto (String nombre);
}