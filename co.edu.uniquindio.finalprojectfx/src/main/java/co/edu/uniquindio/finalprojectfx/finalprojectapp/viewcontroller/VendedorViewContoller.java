package co.edu.uniquindio.finalprojectfx.finalprojectapp.viewcontroller;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.controller.VendedorController;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.dto.VendedorDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VendedorViewContoller {

    public void obtenerVendedores() {
        VendedorController vendedorController;
        ObservableList<VendedorDto> listaVendedores = FXCollections.observableArrayList();
        VendedorDto vendedorSeleccionado;

        listaVendedores.addAll(vendedorController.obtenerVendedor());
    }
}
