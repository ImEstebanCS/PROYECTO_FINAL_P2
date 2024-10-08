package co.edu.uniquindio.finalprojectfx.finalprojectapp.model;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.service.IAdministradorCrud;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.service.IProductoCrud;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.service.IVendedorCrud;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MarketPlace implements IVendedorCrud, IProductoCrud, IAdministradorCrud {

    private String nombre;
    private List<Vendedor> ListaVendedores = new ArrayList<>();
    private List<Producto> ListaProductos = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vendedor> getListaVendedores() {
        return ListaVendedores;
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        ListaVendedores = listaVendedores;
    }

    public List<Producto> getListaProductos() {
        return ListaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        ListaProductos = listaProductos;
    }

    @Override
    public boolean crearVendedor(String nombre,
                                 String apellidos,
                                 String cedula,
                                 String direccion,
                                 String usuario,
                                 String contrasena) {
        Vendedor vendedorExistente = obtenerVendedor(cedula);
        if (vendedorExistente == null) {
            Vendedor vendedor = Vendedor.builder()
                    .nombre(nombre)
                    .apellidos(apellidos)
                    .cedula(cedula)
                    .direccion(direccion)
                    .usuario(usuario)
                    .contrasena(contrasena)
                    .build();
            getListaVendedores().add(vendedor);
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizarVendedor(String nombre,
                                      String apellidos,
                                      String cedula,
                                      String direccion,
                                      String usuario,
                                      String contrasena) {
        Vendedor vendedorExistente = obtenerVendedor(cedula);
        if (vendedorExistente != null) {
            Vendedor vendedorActualizado = Vendedor.builder()
                    .nombre(nombre)
                    .apellidos(apellidos)
                    .direccion(direccion)
                    .usuario(usuario)
                    .contrasena(contrasena)
                    .build();
            getListaVendedores().remove(vendedorExistente);
            getListaVendedores().add(vendedorActualizado);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public  boolean actualizarVendedor(String cedulaActual, Vendedor vendedor){
        Vendedor vendedorActual=obtenerVendedor(cedulaActual);
        if(vendedorActual==null){
            throw new RuntimeException("El vendedor a actualizar no existe");
        }else{
            vendedorActual.setNombre(vendedor.getNombre());
            vendedorActual.setApellidos(vendedor.getApellidos());
            vendedorActual.setCedula(vendedor.getCedula());
            vendedorActual.setDireccion(vendedor.getDireccion());
            vendedorActual.setUsuario(vendedor.getUsuario());
            vendedorActual.setContrasena(vendedor.getContrasena());
            return true;
        }

    }

    public boolean crearVendedor(Vendedor nuevoVendedor){
        Vendedor vendedorEncontrado = obtenerVendedor(nuevoVendedor.getCedula());
        if(vendedorEncontrado == null){
            getListaVendedores().add(nuevoVendedor);
            return true;
        }else{
            return  false;
        }
    }

    private Vendedor obtenerVendedor(String cedula) {
        Vendedor vendedorExistente = null;
        for (Vendedor vendedor : getListaVendedores()) {
            if (vendedor.getCedula().equalsIgnoreCase(cedula)) {
                vendedorExistente = vendedor;
                break;
            }
        }
        return vendedorExistente;
    }

    public boolean eliminarVendedor(String cedula) throws VendedorException {
        Vendedor vendedorExistente = null;
        boolean flagExiste=false;
        vendedorExistente = obtenerVendedor(cedula);
        if(vendedorExistente==null)
            throw new VendedorException("El vendedor a eliminar no existe");
        else {
            getListaVendedores().remove(vendedorExistente);
            flagExiste=true;
        }
        return flagExiste;
    }

    @Override
    public boolean crearProducto(String nombre,
                                 String imagen,
                                 String categoria,
                                 double precio,
                                 EstadoProducto estadoProducto,
                                 LocalDate fechaPublicacion) {
        Producto productoExistente = obtenerProducto(nombre);
        if (productoExistente == null) {
            Producto producto = Producto.builder()
                    .nombre(nombre)
                    .imagen(imagen)
                    .categoria(categoria)
                    .precio(precio)
                    .estadoProducto(estadoProducto)
                    .fechaPublicacion(fechaPublicacion)
                    .build();
            getListaProductos().add(producto);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean actulizarProducto(String nombre,
                                     double precio,
                                     EstadoProducto estadoProducto) {
        Producto productoExistente = obtenerProducto(nombre);
        if (productoExistente != null) {
            Producto productoActualizado = Producto.builder()
                    .nombre(nombre)
                    .precio(precio)
                    .estadoProducto(estadoProducto)
                    .build();
            getListaProductos().remove(productoExistente);
            getListaProductos().add(productoActualizado);
            return true;
        } else {
            return false;
        }
    }

    private Producto obtenerProducto (String nombre) {
        Producto productoExistente = null;
        for (Producto producto : getListaProductos()) {
            if (producto.getNombre().equals(nombre)) {
                productoExistente = producto;
                break;
            }
        }
        return productoExistente;
    }

    @Override
    public boolean eliminarProducto(String nombre) {
        Producto productoExistente = obtenerProducto(nombre);
        if (productoExistente != null) {
            getListaProductos().remove(productoExistente);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean crearAdministrador(String nombre,
                                 String apellidos,
                                 String cedula,
                                 String direccion,
                                 String usuario,
                                 String contrasena) {
        Vendedor vendedorExistente = obtenerAdministrador(cedula);
        if (vendedorExistente == null) {
            Vendedor vendedor = Vendedor.builder()
                    .nombre(nombre)
                    .apellidos(apellidos)
                    .cedula(cedula)
                    .direccion(direccion)
                    .usuario(usuario)
                    .contrasena(contrasena)
                    .build();
            getListaVendedores().add(vendedor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean actualizarAdministrador(String nombre,
                                      String apellidos,
                                      String cedula,
                                      String direccion,
                                      String usuario,
                                      String contrasena) {
        Vendedor vendedorExistente = obtenerAdministrador(cedula);
        if (vendedorExistente != null) {
            Vendedor vendedorActualizado = Vendedor.builder()
                    .nombre(nombre)
                    .apellidos(apellidos)
                    .direccion(direccion)
                    .usuario(usuario)
                    .contrasena(contrasena)
                    .build();
            getListaVendedores().remove(vendedorExistente);
            getListaVendedores().add(vendedorActualizado);
            return true;
        } else {
            return false;
        }
    }

    private Vendedor obtenerAdministrador(String cedula) {
        Vendedor vendedorExistente = null;
        for (Vendedor vendedor : getListaVendedores()) {
            if (vendedor.getCedula().equalsIgnoreCase(cedula)) {
                vendedorExistente = vendedor;
                break;
            }
        }
        return vendedorExistente;
    }

    @Override
    public boolean eliminarAdministrador(String cedula) {
        Vendedor vendedorExistente = obtenerAdministrador(cedula);
        if (vendedorExistente != null) {
            getListaVendedores().remove(vendedorExistente);
            return true;
        } else {
            return false;
        }
    }
    public static void actualizarEmpleado(){}
}

