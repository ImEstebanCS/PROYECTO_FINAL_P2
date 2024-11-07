package co.edu.uniquindio.finalprojectfx.finalprojectapp.service;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.ProductoException;

import java.text.ParseException;
import java.time.LocalDate;

public interface IProductoCrud {
    boolean crearProducto (String nombre, String imagen, String categoria, double precio, String estadoProducto, LocalDate fechaPublicacion);
    boolean actualizarProducto (String nombre, double precio, String estadoProducto);
    boolean eliminarProducto (String nombre) throws ProductoException;
}