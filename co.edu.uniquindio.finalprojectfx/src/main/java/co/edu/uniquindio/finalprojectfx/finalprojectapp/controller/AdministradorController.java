package co.edu.uniquindio.finalprojectfx.finalprojectapp.controller;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.factory.ModelFactory;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.dto.VendedorDto;

import java.util.List;

public class AdministradorController {
    ModelFactory modelFactory;
    public AdministradorController() {
        modelFactory = ModelFactory.getInstance();
    }

    public List<VendedorDto> obtenerVendedores() {
        return modelFactory.obtenerVendedores();
    }

    public boolean agregarVendedor(VendedorDto vendedorDto) {
        return modelFactory.agregarVendedor(vendedorDto);
    }
    public boolean eliminarVendedor(String cedula) { return modelFactory.eliminarVendedor(cedula); }

}
