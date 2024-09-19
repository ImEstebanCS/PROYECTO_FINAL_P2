package co.edu.uniquindio.finalprojectfx.finalprojectapp.factory;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.RedSocial;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.Vendedor;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.services.IVendedorCrud;

public class ModelFactory implements IVendedorCrud {
    public static ModelFactory modelFactory;
    private RedSocial redSocial;

    private ModelFactory() {inicializarDatos();}
    public static ModelFactory getInstance(){
        if(modelFactory ==null){
            modelFactory = new ModelFactory();
        }

        return modelFactory;
    }







    private void inicializarDatos(){
        redSocial = new RedSocial();
        Vendedor Esteban=Vendedor.builder()
                .nombre("Juan")
                .apellido("Carmona")
                .cedula("1094878402")
                .direccion("Mz B Cs 2")
                .usuario("ImEstebanCS")
                .contrasena("Hola123")
                .build();
        Vendedor Juan=Vendedor.builder()
                .nombre("Juan")
                .apellido("Rojas")
                .cedula("1096644395")
                .direccion("Mz B Cs ")
                .usuario("ImJuanR")
                .contrasena("Hola1234")
                .build();



    }

    @Override
    public boolean crearVendedor(String nombre, String apellido, String cedula, String direccion, String usuario, String contrasena) {
        return false;
    }

    @Override
    public boolean actualizarVendedor(String nombre, String cedula, String idNuevo) {
        return false;
    }

    @Override
    public boolean obtenerVendedor() {
        return false;
    }

    @Override
    public boolean eliminarVendedor(String nombre, String cedula) {
        return false;
    }
}
