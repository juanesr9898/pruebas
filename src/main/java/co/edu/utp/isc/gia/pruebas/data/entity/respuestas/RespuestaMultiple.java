package co.edu.utp.isc.gia.pruebas.data.entity.respuestas;

import co.edu.utp.isc.gia.pruebas.data.entity.Pregunta;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Respuestas_Multiples")
public class RespuestaMultiple extends Pregunta{
    private int respuesta_opcion_multiple;

}
