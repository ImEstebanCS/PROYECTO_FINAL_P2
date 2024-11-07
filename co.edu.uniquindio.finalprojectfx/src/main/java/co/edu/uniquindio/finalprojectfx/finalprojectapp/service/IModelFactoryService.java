package co.edu.uniquindio.finalprojectfx.finalprojectapp.service;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.dto.ProductoDto;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.dto.VendedorDto;

import java.util.List;

public interface IModelFactoryService {
    List<VendedorDto> obtenerVendedores();
    boolean agregarVendedor(VendedorDto vendedorDto);
    boolean eliminarVendedor(String cedula);
    boolean actualizarVendedor(String cedulaActual, VendedorDto vendedorDto);

    List<ProductoDto> obtenerProductos();
    boolean agregarProducto(ProductoDto productoDto);

    boolean eliminarProducto(String nombre);

    boolean actualizarProducto(String nombreActual, ProductoDto productoDto);
}
