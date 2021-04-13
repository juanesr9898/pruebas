package co.edu.utp.isc.gia.pruebas.data.entity.respuestas;

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
@Table(name = "Respuestas_Unica")
//@Inheritance(strategy=InheritanceType.JOINED)
public class RespuestaMultiple1Opcion extends Respuesta{
    private int respuesta_opcion_unica;
}
