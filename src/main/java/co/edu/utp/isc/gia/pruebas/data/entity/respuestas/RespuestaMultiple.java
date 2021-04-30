package co.edu.utp.isc.gia.pruebas.data.entity.respuestas;

import co.edu.utp.isc.gia.pruebas.data.entity.Pregunta;
import co.edu.utp.isc.gia.pruebas.data.entity.Respuesta;
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
@Table(name = "Respuesta_Multiple")
//@Inheritance(strategy=InheritanceType.JOINED)
public class RespuestaMultiple extends Respuesta{
    private String respuesta_opcion_multiple;

}
