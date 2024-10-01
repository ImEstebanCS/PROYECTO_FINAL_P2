package co.edu.uniquindio.finalprojectfx.finalprojectapp.factory;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.mappers.MarketPlaceMappingImpl;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.EstadoProducto;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.service.IMarketPlaceMapping;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.service.IModelFactoryService;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.service.IProductoCrud;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.service.IVendedorCrud;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.MarketPlace;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.utils.DataUtil;

import java.time.LocalDate;
import java.util.List;

public class ModelFactory implements IVendedorCrud, IProductoCrud, IModelFactoryService {

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
    public boolean crearVendedor(String nombre, String apellidos, String cedula, String direccion, String usuario, String contrasena) {
        return false;
    }

    @Override
    public boolean actualizarVendedor(String nombre, String apellidos, String cedula,String direccion, String usuario, String contrasena) {
        return false;
    }

    @Override
    public boolean eliminarVendedor(String cedula) {
        return false;
    }

    @Override
    public boolean crearProducto(String nombre, String imagen, String categoria, double precio, EstadoProducto estadoProducto, LocalDate fechaPublicacion) {
        return false;
    }

    @Override
    public boolean actulizarProducto(String nombre, double precio, EstadoProducto estadoProducto) {
        return false;
    }

    @Override
    public boolean eliminarProducto(String nombre) {
        return false;
    }

    @Override
    public List<VendedorDto> obtenerVendedores() {
        return mapper.getVendedorDto(marketPlace.getListaVendedores());
    }
}

// organizar dto, organizar model factory, organizar clases, minuto 39.53
// TRABAJAR MAÑANA
