package co.edu.uniquindio.finalprojectfx.finalprojectapp.factory;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.mappers.MarketPlaceMappingImpl;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.Vendedor;
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
}
