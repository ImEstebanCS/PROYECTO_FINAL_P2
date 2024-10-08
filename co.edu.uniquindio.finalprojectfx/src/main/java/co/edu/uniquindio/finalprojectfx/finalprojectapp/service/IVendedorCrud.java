package co.edu.uniquindio.finalprojectfx.finalprojectapp.service;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.Vendedor;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.VendedorException;

public interface IVendedorCrud {

    boolean crearVendedor (String nombre, String apellidos, String cedula, String direccion, String usuario, String contrasena);
    boolean actualizarVendedor (String cedulaActual, Vendedor vendedor) throws VendedorException ;
    boolean eliminarVendedor (String cedula) throws VendedorException;

}
