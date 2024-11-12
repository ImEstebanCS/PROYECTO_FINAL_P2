package co.edu.uniquindio.finalprojectfx.finalprojectapp.viewcontroller;

import java.net.URL;
import java.net.http.WebSocket;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.controller.VendedorController;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.dto.ProductoDto;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static co.edu.uniquindio.finalprojectfx.finalprojectapp.utils.MarketPlaceConstantes.*;

public class VendedorViewController {

    VendedorController vendedorController;
    ObservableList<ProductoDto> listaProductos = FXCollections.observableArrayList();
    ProductoDto productoSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnPublicarProducto;

    @FXML
    private Button btneEliminar;

    @FXML
    private ImageView imagenProducto;

    @FXML
    private RadioButton rbCancelado;

    @FXML
    private RadioButton rbPublicado;

    @FXML
    private RadioButton rbVendido;

    @FXML
    private DatePicker dpFechaPublicacion;

    @FXML
    private TableView<ProductoDto> tableProductos;

    @FXML
    private TableColumn<ProductoDto, String> tcCategoria;

    @FXML
    private TableColumn<ProductoDto, String> tcEstado;

    @FXML
    private TableColumn<ProductoDto, LocalDate> tcFecha;

    @FXML
    private TableColumn<ProductoDto, String> tcNombre;

    @FXML
    private TableColumn<ProductoDto, Double> tcPrecio;

    @FXML
    private TextField txtCategoria;

    @FXML
    private TextField txtImagen;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;


    @FXML
    void onPublicarProducto(ActionEvent event) {

    }

    @FXML
    void initialize() {
        vendedorController = new VendedorController();
        initView();
        toggleGroupBotones();
    }

    @FXML
    void onAgregraProducto(ActionEvent event) {
        agregarProducto();
    }

    private void agregarProducto() {
        ProductoDto productoDto = crearProductoDto();
        if(datosValidos(productoDto)) {
            if(vendedorController.agregarProducto(productoDto)) {
                listaProductos.addAll(productoDto);
                limpiarCampos();
                mostrarMensaje(TITULO_PRODUCTO_AGREGADO, HEADER, BODY_PRODUCTO_AGREGADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_PRODUCTO_NO_AGREGADO, HEADER, BODY_PRODUCTO_NO_AGREGADO,Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.WARNING);

        }
    }

    private ProductoDto crearProductoDto() {
        String nombre = txtNombre.getText();
        String categoria = txtCategoria.getText();
        String imagen = txtImagen.getText();
        String estadoProducto = "";
        LocalDate fechaPublicacion = dpFechaPublicacion.getValue();
        if(rbPublicado.isSelected()) {
            estadoProducto = "Publicado";
        } else if (rbCancelado.isSelected()) {
            estadoProducto = "Cancelado";
        } else if (rbVendido.isSelected()) {
            estadoProducto = "Vendido";
        } else {
            mostrarMensaje(TITULO_ERROR_DEL_ESTADO, HEADER, BODY_ERROR_DEL_ESTADO, Alert.AlertType.ERROR);
            return null;
        }
        double precio;
        try {
            precio = Double.parseDouble(txtPrecio.getText());
        } catch (NumberFormatException e) {
            mostrarMensaje(TITULO_ERROR_EN_PRECIO, HEADER, BODY_NUMERO_INVALIDO, Alert.AlertType.ERROR);
            return null;
        }

        if(fechaPublicacion == null) {
            mostrarMensaje(TITULO_ERROR_FECHA, HEADER, BODY_FECHA_INVALIDA, Alert.AlertType.ERROR);
            return null;
        }
        return  new ProductoDto(nombre, categoria, precio,  fechaPublicacion, estadoProducto, imagen);
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtImagen.setText("");
        txtPrecio.setText("");
        txtCategoria.setText("");
        dpFechaPublicacion.setValue(null);
        imagenProducto.setImage(null);
    }

    private boolean datosValidos(ProductoDto productoDto) {
        return productoDto != null && !productoDto.nombre().isBlank() ||
                !productoDto.categoria().isBlank() ||
                productoDto.precio() != null ||
                productoDto.fechaPublicacion() != null ||
                !productoDto.imagen().isBlank();
    }

    private void toggleGroupBotones() {
        ToggleGroup toggleGroup = new ToggleGroup();
        rbPublicado.setToggleGroup(toggleGroup);
        rbVendido.setToggleGroup(toggleGroup);
        rbCancelado.setToggleGroup(toggleGroup);
        rbPublicado.setSelected(true);
    }

    private void initView() {
        initDataBinding();
        obtenerProductos();
        tableProductos.getItems().clear();
        tableProductos.setItems(listaProductos);
        listenerSelection();
    }

    private void obtenerProductos() {
        listaProductos.addAll(vendedorController.obtenerProductos());
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().categoria()));
        tcPrecio.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().precio()));
        tcEstado.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().estadoProducto()));
        tcFecha.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().fechaPublicacion()));
        tcFecha.setCellFactory(_ -> new TableCell<>() {
            @Override
            protected void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.toString());
                }
            }
        });
    }

    private void listenerSelection() {
        tableProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            productoSeleccionado = newSelection;
            mostrarInformacionProducto(productoSeleccionado);
        });

    }

    private void mostrarInformacionProducto(ProductoDto productoSeleccionado) {
        if(productoSeleccionado != null) {
            txtNombre.setText(productoSeleccionado.nombre());
            txtCategoria.setText(productoSeleccionado.categoria());
            txtPrecio.setText(String.valueOf(productoSeleccionado.precio()));
            dpFechaPublicacion.setValue(productoSeleccionado.fechaPublicacion());
            txtImagen.setText(productoSeleccionado.imagen());


            cargarImagen(productoSeleccionado.imagen());
        }
    }

    private void cargarImagen(String nombreImagen) {
        try {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/co/edu/uniquindio/finalprojectfx/finalprojectapp/ImagenesProductos/" + nombreImagen)));
            imagenProducto.setImage(image);
        } catch (Exception e) {
            imagenProducto.setImage(null);
            mostrarMensaje(TITULO_ERRROR_IMAGEN, BODY_ERRROR_IMAGEN+ e.getMessage(), HEADER, Alert.AlertType.ERROR);
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
    void onEliminarProducto(ActionEvent event) {
        eliminarProducto();
    }

    private void eliminarProducto() {
        boolean productoEliminado = false;
        if(productoSeleccionado != null) {
            if(mostrarMensajeConfirmacion("¿Estás seguro de eliminar este producto?")){
                productoEliminado = vendedorController.eliminarProducto(productoSeleccionado.nombre());
                if(productoEliminado == true){
                    listaProductos.remove(productoSeleccionado);
                    productoSeleccionado = null;
                    tableProductos.getSelectionModel().clearSelection();
                    limpiarCampos();
                    mostrarMensaje(TITTLE_SELLER_PRODUCTO, HEADER_SELLER_ELIMINATED_PRODUCTO, CONTENT_SELLER_DELECTED_PRODUCTO, Alert.AlertType.INFORMATION);
                }
            } else {
                mostrarMensaje(TITTLE_SELLER_PRODUCTO, HEADER_SELLER_NOT_DELECTED_PRODUCTO, CONTENT_SELLER_NOT_DELECTED_PRODUCTO, Alert.AlertType.WARNING);
            }
        }
    }

    @FXML
    void onActualizarProducto(ActionEvent event) {
        actualizarProducto();
    }

    private void actualizarProducto() {
        boolean productoActualizado = false;
        String nombreActual = productoSeleccionado.nombre();
        ProductoDto productoDto = crearProductoDto();
        if(productoSeleccionado != null) {
            if(datosValidos(productoDto)){
                productoActualizado = vendedorController.actualizarProducto(nombreActual, productoDto);
                if(productoActualizado){
                    listaProductos.remove(productoSeleccionado);
                    listaProductos.add(productoDto);
                    tableProductos.refresh();;
                    mostrarMensaje(TITTLE_SELLER_PRODUCTO, HEADER_UPDATED_SELLER_PRODUCTO, CONTENT_UPDATED_SELLER_PRODUCTO, Alert.AlertType.INFORMATION);
                }else {
                    mostrarMensaje(TITTLE_SELLER_PRODUCTO, HEADER_SELLER_NOT_UPDATED_PRODUCTO, CONTENT_SELLER_NOT_UPDATED_PRODUCTO, Alert.AlertType.WARNING);
                }
            } else {
                mostrarMensaje(TITTLE_SELLER_PRODUCTO, "Producto no creado", "Los datos ingresados no son validos", Alert.AlertType.ERROR);
            }
        }
    }
}




