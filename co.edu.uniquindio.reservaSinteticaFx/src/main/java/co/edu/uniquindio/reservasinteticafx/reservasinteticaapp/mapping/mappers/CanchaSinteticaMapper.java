package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.mapping.mappers;

import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.mapping.dto.ReservaDto;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.mapping.dto.UsuarioDto;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.Reserva;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.Usuario;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface CanchaSinteticaMapper {
    CanchaSinteticaMapper INSTANCE = Mappers.getMapper(CanchaSinteticaMapper.class);

    @Named("empleadoToEmpleadoDto")
    ReservaDto empleadoToEmpleadoDto(Reserva reserva);

    Reserva empleadoDtoToEmpleado(ReservaDto empleadoDto);

    @IterableMapping(qualifiedByName = "empleadoToEmpleadoDto")
    List<ReservaDto> getEmpleadosDto(List<Reserva> listaEmpleados);

//    @Named("mappingToEmpeladoDto")
//    EmpleadoDto mappingToEmpeladoDto(Empleado empleado);


    @Mapping(target = "idUsuario", source = "usuario.nombre")
    @IterableMapping(qualifiedByName = "usuarioToUsuarioDto")
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);
}
