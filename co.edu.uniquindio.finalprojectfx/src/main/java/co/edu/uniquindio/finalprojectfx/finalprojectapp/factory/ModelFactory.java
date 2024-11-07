package co.edu.uniquindio.finalprojectfx.finalprojectapp.factory;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.dto.ProductoDto;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.mappers.MarketPlaceMappingImpl;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.*;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.service.*;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.utils.DataUtil;

import java.util.List;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory modelFactory;
    private MarketPlace marketPlace;
    private IMarketPlaceMapping mapper;

    private ModelFactory() {
        mapper = new MarketPlaceMappingImpl();
        marketPlace = DataUtil.inicializarDatos();
    }

    public static ModelFactory getInstance() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    @Override
    public List<VendedorDto> obtenerVendedores() {
        return mapper.getVendedorDto(marketPlace.getListaVendedores());
    }

    @Override
    public boolean agregarVendedor(VendedorDto vendedorDto) {
        Vendedor vendedor = mapper.vendedorDtoToVendedor(vendedorDto);
        return marketPlace.crearVendedor(vendedor);
    }

    @Override
    public boolean eliminarVendedor(String cedula) {
        boolean flagExiste=false;
        try{
            flagExiste = marketPlace.eliminarVendedor(cedula);

        }catch (VendedorException e){
            e.printStackTrace();

        }
        return flagExiste;
    }

    @Override
    public boolean actualizarVendedor(String cedulaActual, VendedorDto vendedorDto)  {
        Vendedor vendedor = mapper.vendedorDtoToVendedor(vendedorDto);
        return marketPlace.actualizarVendedor(cedulaActual, vendedor);
    }

    @Override
    public List<ProductoDto> obtenerProductos() {
        return mapper.getProductoDto(marketPlace.getListaProductos());
    }

    @Override
    public boolean agregarProducto(ProductoDto productoDto) {
        Producto producto = mapper.ProductoDtoToProducto(productoDto);
        return marketPlace.crearProducto(producto);
    }

    @Override
    public boolean eliminarProducto(String nombre) {
        boolean flagExiste = false;
        try{
            flagExiste = marketPlace.eliminarProducto(nombre);

        }catch (ProductoException e){
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarProducto(String nombreActual, ProductoDto productoDto) {
        Producto producto = mapper.ProductoDtoToProducto(productoDto);
        return marketPlace.actualizarProducto(nombreActual, producto);
    }

}
