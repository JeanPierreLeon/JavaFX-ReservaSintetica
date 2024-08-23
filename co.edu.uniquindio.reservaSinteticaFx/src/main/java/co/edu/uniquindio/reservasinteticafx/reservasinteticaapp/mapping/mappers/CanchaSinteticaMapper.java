package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.mapping.mappers;

import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.mapping.dto.ReservaDto;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.CanchaSintetica;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.Reserva;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CanchaSinteticaMapper {
    CanchaSinteticaMapper INSTANCE = Mappers.getMapper(CanchaSinteticaMapper.class);

    @Named("reservaToReservaDto")
    ReservaDto reservaToReservaDto(Reserva reserva);

    Reserva reservaToReservaDto(ReservaDto reservaDto);

  //  @IterableMapping(qualifiedByName = "empleadoToEmpleadoDto")
 //   List<ReservaDto> getReservasDto(List<Reserva> listaEmpleados);


}
