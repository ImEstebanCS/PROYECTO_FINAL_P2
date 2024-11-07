package co.edu.uniquindio.finalprojectfx.finalprojectapp.utils;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.*;

import java.time.LocalDate;

public class DataUtil {

    public static MarketPlace inicializarDatos() {
        MarketPlace marketPlace = new MarketPlace();

        Vendedor vendedor1 = Vendedor.builder()
                .nombre("Esteban")
                .apellidos("Carmona")
                .cedula("1094878402")
                .direccion("MzB Cs2 Laureles")
                .usuario("ImEstebanCS")
                .contrasena("Juanito2004")
                .build();

        Vendedor vendedor2= Vendedor.builder()
                .nombre("Manuel")
                .apellidos("Rojas")
                .cedula("1000456562")
                .direccion("Laureles Armenia")
                .usuario("ImRojasAFK")
                .contrasena("123456789")
                .build();

        Producto producto1 = Producto.builder()
                .nombre("Saco Verde a Cuadros")
                .imagen("SacoVerdeCuadros.png")
                .categoria("Ropa - Hombre")
                .precio(800)
                .estadoProducto("Publicado")
                .fechaPublicacion(LocalDate.of(2023, 7, 5))
                .build();


        marketPlace.getListaVendedores().add(vendedor1);
        marketPlace.getListaVendedores().add(vendedor2);
        marketPlace.getListaProductos().add(producto1);
        return marketPlace;
    }
}
