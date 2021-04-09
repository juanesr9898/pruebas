package co.edu.utp.isc.gia.pruebas.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
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
@JsonInclude(JsonInclude.Include.NON_NULL) //No muestra valores nulos
public class PreguntaDto implements Serializable{
    private Long id;
    public String pregunta;
    public String imagen;
    public String respuesta;
    public float peso;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //Cuando se liste, no mostrar el tipo de pregunta
    public int tipo_pregunta;
}
