package co.edu.uniquindio.finalprojectfx.finalprojectapp.mapping.dto;

import java.time.LocalDate;

public record ProductoDto(
        String nombre,
        String categoria,
        Double precio,
        LocalDate fechaPublicacion,
        String estadoProducto,
        String imagen
) {
}
