package co.edu.uniquindio.finalprojectfx.finalprojectapp.service;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.Vendedor;

import java.util.List;

public interface IMarketPlaceMapping {
    List<VendedorDto> getVendedorDto(List<Vendedor> listaVendedores);
    VendedorDto vendedorToVendedorDto(Vendedor vendedor);
    Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto);
}
