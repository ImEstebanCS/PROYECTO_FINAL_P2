package co.edu.uniquindio.finalprojectfx.finalprojectapp.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.controller.AdministradorController;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.dto.VendedorDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javax.lang.model.util.AbstractElementVisitor14;

public class AdministradorViewController {

    AdministradorController administradorController;
    ObservableList<VendedorDto> listaVendedores = FXCollections.observableArrayList();
    VendedorDto vendedorSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCedula;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnNuevo;

    @FXML
    private Button btneEliminar;

    @FXML
    private TableView<VendedorDto> tableVendedor;

    @FXML
    private TableColumn<VendedorDto, String> tcApellidos;

    @FXML
    private TableColumn<VendedorDto, String> tcCedula;

    @FXML
    private TableColumn<VendedorDto, String> tcContrasena;

    @FXML
    private TableColumn<VendedorDto, String> tcDireccion;

    @FXML
    private TableColumn<VendedorDto, String> tcNombre;

    @FXML
    private TableColumn<VendedorDto, String> tcUsuario;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtContrasena;

    @FXML
    void onActualizarVendedor(ActionEvent event) {

    }

    @FXML
    void initialize() {
        administradorController = new AdministradorController();
        initView();

    }

    private void initView() {
        initDataBinding();
        obtenerVendedores();
        tableVendedor.getItems().clear();
        tableVendedor.setItems(listaVendedores);
        listenerSelection();
    }

    private void obtenerVendedores() {
        listaVendedores.addAll(administradorController.obtenerVendedores());

    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellidos.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellidos()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedula()));
        tcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().direccion()));
        tcUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().usuario()));
        tcContrasena.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().contrasena()));
    }

    private void listenerSelection() {
        tableVendedor.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            vendedorSeleccionado = newSelection;
            mostrarInformacionVendedor(vendedorSeleccionado);
        });

    }

    private void mostrarInformacionVendedor(VendedorDto vendedorSeleccionado) {
        if(vendedorSeleccionado != null) {
            txtNombre.setText(vendedorSeleccionado.nombre());
            txtApellidos.setText(vendedorSeleccionado.apellidos());
            txtCedula.setText(vendedorSeleccionado.cedula());
            txtDireccion.setText(vendedorSeleccionado.direccion());
            txtUsuario.setText(vendedorSeleccionado.usuario());
            txtContrasena.setText(vendedorSeleccionado.contrasena());
        }
    }

    @FXML
    void onAgregarVendedor(ActionEvent event) {

    }

    @FXML
    void onEliminarVendedor(ActionEvent event) {

    }

    @FXML
    void onNuevoVendedor(ActionEvent event) {

    }

}

