package co.edu.uniquindio.finalprojectfx.finalprojectapp.controller;


import co.edu.uniquindio.finalprojectfx.finalprojectapp.factory.ModelFactory;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.dto.ProductoDto;

import java.util.List;

public class VendedorController {
    ModelFactory modelFactory;
    public VendedorController() {
        modelFactory = ModelFactory.getInstance();
    }

    public List<ProductoDto> obtenerProductos() {
        return modelFactory.obtenerProductos();
    }

    public boolean agregarProducto(ProductoDto productoDto) {
        return modelFactory.agregarProducto(productoDto);
    }

    public boolean eliminarProducto(String nombre) {
        return modelFactory.eliminarProducto(nombre);
    }

    public boolean actualizarProducto(String nombreActual, ProductoDto productoDto) {
        return modelFactory.actualizarProducto(nombreActual, productoDto);
    }
}
