package co.edu.uniquindio.finalprojectfx.finalprojectapp.factory;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.mappers.MarketPlaceMappingImpl;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.Vendedor;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.VendedorException;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.service.*;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.MarketPlace;
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
            Vendedor vendedor=mapper.vendedorDtoToVendedor(vendedorDto);
            return marketPlace.actualizarVendedor(cedulaActual,vendedor);


    }
}
