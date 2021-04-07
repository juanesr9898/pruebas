package co.edu.utp.isc.gia.pruebas.web.dto;

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
public class PreguntaDto implements Serializable{
    private Long id;
    public String descripcion;
    public String imagen;
    public String respuesta;
    public float peso;
    public boolean correcta;
    
    public boolean isCorrecta() {
        return correcta;
    }
}
