package co.edu.uniquindio.finalprojectfx.finalprojectapp.viewcontroller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.controller.AdministradorController;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.dto.VendedorDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.lang.model.util.AbstractElementVisitor14;

import static co.edu.uniquindio.finalprojectfx.finalprojectapp.utils.MarketPlaceConstantes.*;

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
    void initialize() {
        administradorController = new AdministradorController();
        initView();
    }

    @FXML
    void onAgregarVendedor(ActionEvent event) {
        agregarVendedor();
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

    private void agregarVendedor() {
        VendedorDto vendedorDto = crearVendedorDto();
        if(datosValidos(vendedorDto)) {
            if(administradorController.agregarVendedor(vendedorDto)) {
                listaVendedores.addAll(vendedorDto);
                limpiarCampos();
                mostrarMensaje(TITULO_VENDEDOR_AGREGADO, HEADER, BODY_VENDEDOR_AGREGADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_VENDEDOR_NO_AGREGADO, HEADER, BODY_VENDEDOR_NO_AGREGADO,Alert.AlertType.ERROR);

            }
        } else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.WARNING);

        }

    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellidos.setText("");
        txtCedula.setText("");
        txtDireccion.setText("");
        txtUsuario.setText("");
        txtContrasena.setText("");
    }

    private boolean datosValidos(VendedorDto vendedorDto) {
        if(vendedorDto.nombre().isBlank() ||
                vendedorDto.apellidos().isBlank() ||
           vendedorDto.cedula().isBlank() ||
           vendedorDto.direccion().isBlank() ||
           vendedorDto.usuario().isBlank() ||
           vendedorDto.contrasena().isBlank()
        ){
            return false;
        } else {
            return true;
        }
    }

    private VendedorDto crearVendedorDto() {
        return new VendedorDto(
                txtNombre.getText(),
                txtApellidos.getText(),
                txtCedula.getText(),
                txtDireccion.getText(),
                txtUsuario.getText(),
                txtContrasena.getText());
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

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    void onEliminarVendedor(ActionEvent event) {

    }

    @FXML
    void onNuevoVendedor(ActionEvent event) {

    }

    @FXML
    void onActualizarVendedor(ActionEvent event) {

    }

}

