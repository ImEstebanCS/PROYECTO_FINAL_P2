package co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.mappers;

import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.dto.ProductoDto;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.Producto;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.Vendedor;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.model.builder.VendedorBuilder;
import co.edu.uniquindio.finalprojectfx.finalprojectapp.service.IMarketPlaceMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MarketPlaceMappingImpl implements IMarketPlaceMapping {

    @Override
    public List<VendedorDto> getVendedorDto(List<Vendedor> listaVendedores) {
        if(listaVendedores == null){
            return null;
        }
        List<VendedorDto> listaVendedoresDto = new ArrayList<VendedorDto>(listaVendedores.size());
        for (Vendedor vendedor : listaVendedores) {
            listaVendedoresDto.add(vendedorToVendedorDto(vendedor));
        }
        return listaVendedoresDto;
    }

    @Override
    public VendedorDto vendedorToVendedorDto(Vendedor vendedor) {
        return new VendedorDto(
                vendedor.getNombre(),
                vendedor.getApellidos(),
                vendedor.getCedula(),
                vendedor.getDireccion(),
                vendedor.getUsuario(),
                vendedor.getContrasena());
    }

    @Override
    public Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto) {
        return Vendedor.builder()
                .nombre(vendedorDto.nombre())
                .apellidos(vendedorDto.apellidos())
                .cedula(vendedorDto.cedula())
                .direccion(vendedorDto.direccion())
                .build();
    }

    @Override
    public List<ProductoDto> getProductoDto(List<Producto> listaProductos) {
        if(listaProductos == null){
            return null;
        }
        List<ProductoDto> listaProductosDto = new ArrayList<>(listaProductos.size());
        for (Producto producto : listaProductos) {
            listaProductosDto.add(productoToProductoDto(producto));
        }
        return listaProductosDto;
    }

    @Override
    public ProductoDto productoToProductoDto(Producto producto) {
        return new ProductoDto(
                producto.getNombre(),
                producto.getCategoria(),
                producto.getPrecio(),
                producto.getFechaPublicacion(),
                producto.getEstadoProducto(),
                producto.getImagen());
    }

    @Override
    public Producto ProductoDtoToProducto(ProductoDto productoDto) {
        return Producto.builder()
                .nombre(productoDto.nombre())
                .categoria(productoDto.categoria())
                .precio(productoDto.precio())
                .imagen(productoDto.imagen())
                .fechaPublicacion(productoDto.fechaPublicacion())
                .estadoProducto(productoDto.estadoProducto())
                .build();
    }


}
