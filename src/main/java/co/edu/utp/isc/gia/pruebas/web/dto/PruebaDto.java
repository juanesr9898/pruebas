package co.edu.utp.isc.gia.pruebas.web.dto;

import co.edu.utp.isc.gia.pruebas.data.entity.Pregunta;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class PruebaDto implements Serializable{
    private Long id;
    public String descripcion;
    public String enlace;
    public Pregunta pregunta;
    public float nota;
}
