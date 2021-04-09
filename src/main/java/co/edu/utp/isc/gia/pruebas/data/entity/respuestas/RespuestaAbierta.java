package co.edu.utp.isc.gia.pruebas.data.entity.respuestas;

import co.edu.utp.isc.gia.pruebas.data.entity.Pregunta;
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
@Table(name = "Respuestas_abiertas")
public class RespuestaAbierta extends Pregunta{
    private String respuesta_abierta;

}
