package co.edu.utp.isc.gia.pruebas.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL) //No muestra valores nulos 
public class PruebaDto implements Serializable{
    private Long id;
    public String descripcion;
    public String enlace;
    public String materia;
    public Long docenteID;
}
