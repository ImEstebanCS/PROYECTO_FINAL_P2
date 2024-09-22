package co.edu.uniquindio.finalprojectfx.finalprojectapp.factory;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.EstadoProducto;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.service.IProductoCrud;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.service.IVendedorCrud;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.MarketPlace;

import java.time.LocalDate;

public class ModelFactory implements IVendedorCrud, IProductoCrud {

    private static ModelFactory modelFactory;
    private MarketPlace marketPlace;

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
}
